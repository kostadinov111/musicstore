package bg.softuni.musicstore.service.impl;

import bg.softuni.musicstore.model.entity.UserEntity;
import bg.softuni.musicstore.repository.UserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MusicstoreUserServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    public MusicstoreUserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserEntity userEntity = userRepository
                .findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException(String.format("Username with name \"%s\" is not found.", username)));

        return mapToUserDetails(userEntity);
    }

    private UserDetails mapToUserDetails(UserEntity userEntity) {

        List<GrantedAuthority> authorities =
                userEntity
                        .getRoles()
                        .stream()
                        .map(roleEntity -> new SimpleGrantedAuthority("ROLE_" + roleEntity.getRole().name()))
                        .collect(Collectors.toList());

        return new User(
                userEntity.getUsername(),
                userEntity.getPassword(),
                userEntity.getEnabled(),
                true,
                true,
                true,
                authorities
        );
    }
}