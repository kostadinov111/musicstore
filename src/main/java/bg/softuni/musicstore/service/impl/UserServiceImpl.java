package bg.softuni.musicstore.service.impl;

import bg.softuni.musicstore.model.entity.*;
import bg.softuni.musicstore.model.enums.RoleNameEnums;
import bg.softuni.musicstore.model.service.UserRegisterServiceModel;
import bg.softuni.musicstore.model.view.UserManageViewModel;
import bg.softuni.musicstore.model.view.UserRolesManageViewModel;
import bg.softuni.musicstore.repository.*;
import bg.softuni.musicstore.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final MusicstoreUserServiceImpl musicstoreUserService;
    private final ModelMapper modelMapper;

    public UserServiceImpl(PasswordEncoder passwordEncoder, UserRepository userRepository, RoleRepository roleRepository, MusicstoreUserServiceImpl musicstoreUserService, ModelMapper modelMapper) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.musicstoreUserService = musicstoreUserService;
        this.modelMapper = modelMapper;
    }

    @Override
    public void registerAndLoginUser(UserRegisterServiceModel userRegisterServiceModel) {

        if (!isUsernameFree(userRegisterServiceModel.getUsername().toLowerCase()) || userRepository.count() == 0) {

            RoleEntity roleEntity = roleRepository.findByRole(RoleNameEnums.USER);

            UserEntity userEntity = new UserEntity();

            userEntity
                    .setUsername(userRegisterServiceModel.getUsername().toLowerCase())
                    .setEmail(userRegisterServiceModel.getEmail().toLowerCase())
                    .setFirstName(userRegisterServiceModel.getFirstName())
                    .setLastName(userRegisterServiceModel.getLastName())
                    .setPassword(passwordEncoder.encode(userRegisterServiceModel.getPassword()))
                    .setAge(userRegisterServiceModel.getAge())
                    .setRoles(List.of(roleEntity));

            userRepository.save(userEntity);

            UserDetails principal = musicstoreUserService.loadUserByUsername(userEntity.getUsername());

            Authentication authentication = new UsernamePasswordAuthenticationToken(
                    principal,
                    principal.getPassword(),
                    principal.getAuthorities()
            );

            SecurityContextHolder.getContext().setAuthentication(authentication);
        }

    }

    @Override
    public List<UserManageViewModel> findAll() {

        return userRepository
                .findAll()
                .stream()
                .map(userEntity -> modelMapper.map(userEntity, UserManageViewModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public UserEntity findById(Long id) {

        return userRepository
                .findById(id)
                .orElseThrow(() -> new UsernameNotFoundException("USER NOT FOUND"));
    }

    @Transactional
    @Override
    public void disableUserById(Long id) {

        UserEntity userEntity = findById(id);

        userEntity.setEnabled(false);

        userRepository.save(userEntity);
    }

    @Transactional
    @Override
    public void enableUserById(Long id) {

        UserEntity userEntity = findById(id);

        userEntity.setEnabled(true);

        userRepository.save(userEntity);
    }

    @Override
    public List<UserRolesManageViewModel> findUserRoles() {

        return userRepository
                .findAll()
                .stream()
                .map(userEntity -> {
                    UserRolesManageViewModel userRolesManageViewModel = new UserRolesManageViewModel();

                    userRolesManageViewModel
                            .setId(userEntity.getId())
                            .setUsername(userEntity.getUsername());

                    List<String> roleNames = initializeRoleNames(userEntity);

                    InitializeUserRolesManageViewModel(userEntity, userRolesManageViewModel, roleNames);

                    return userRolesManageViewModel;
                })
                .collect(Collectors.toList());
    }

    @Transactional
    @Override
    public void removeRole(Long id, String role) {

        UserEntity userEntity = findById(id);

        int indexToRemove = getIndexToRemoveRole(userEntity, role);

        userEntity.getRoles().remove(indexToRemove);

        userRepository.save(userEntity);
    }

    @Transactional
    @Override
    public void addRole(Long id, String role) {

        String roleToAdd = role.toUpperCase();

        UserEntity userEntity = findById(id);

        RoleEntity roleEntity = roleRepository
                .findByRole(RoleNameEnums.valueOf(roleToAdd));

        userEntity.getRoles().add(roleEntity);

        userRepository.save(userEntity);
    }

    private int getIndexToRemoveRole(UserEntity userEntity, String role) {

        String roleToRemove = role.toUpperCase();

        int rolesSize = userEntity.getRoles().size();
        int indexToRemove = -1;

        for (int i = 0; i < rolesSize; i++) {
            if (userEntity.getRoles().get(i).getRole().name().equals(roleToRemove)) {
                indexToRemove = i;
                break;
            }
        }

        return indexToRemove;
    }

    private void InitializeUserRolesManageViewModel(UserEntity userEntity, UserRolesManageViewModel userRolesManageViewModel, List<String> roleNames) {
        if (userEntity.getRoles().size() == 3) {
            userRolesManageViewModel
                    .setAdmin(true)
                    .setModerator(true)
                    .setUser(true);
        } else if (userEntity.getRoles().size() == 0) {
            userRolesManageViewModel
                    .setAdmin(false)
                    .setModerator(false)
                    .setUser(false);
        } else if (userEntity.getRoles().size() == 2 && roleNames.contains("ADMIN") && roleNames.contains("USER")) {
            userRolesManageViewModel
                    .setAdmin(true)
                    .setModerator(false)
                    .setUser(true);
        } else if (userEntity.getRoles().size() == 2 && roleNames.contains("ADMIN") && roleNames.contains("MODERATOR")) {
            userRolesManageViewModel
                    .setAdmin(true)
                    .setModerator(true)
                    .setUser(false);
        } else if (userEntity.getRoles().size() == 2 && roleNames.contains("MODERATOR") && roleNames.contains("USER")) {
            userRolesManageViewModel
                    .setAdmin(false)
                    .setModerator(true)
                    .setUser(true);
        } else if (userEntity.getRoles().size() == 1 && roleNames.contains("ADMIN")) {
            userRolesManageViewModel
                    .setAdmin(true)
                    .setModerator(false)
                    .setUser(false);
        } else if (userEntity.getRoles().size() == 1 && roleNames.contains("MODERATOR")) {
            userRolesManageViewModel
                    .setAdmin(false)
                    .setModerator(true)
                    .setUser(false);
        } else if (userEntity.getRoles().size() == 1 && roleNames.contains("USER")) {
            userRolesManageViewModel
                    .setAdmin(false)
                    .setModerator(false)
                    .setUser(true);
        }
    }

    private List<String> initializeRoleNames(UserEntity userEntity) {

        return userEntity
                .getRoles()
                .stream()
                .map(r -> r.getRole().name())
                .collect(Collectors.toList());
    }

    private boolean isUsernameFree(String username) {
        return userRepository
                .findByUsername(username)
                .isPresent();
    }
}