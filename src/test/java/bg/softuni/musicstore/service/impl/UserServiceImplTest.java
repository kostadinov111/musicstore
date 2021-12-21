package bg.softuni.musicstore.service.impl;

import bg.softuni.musicstore.model.entity.RoleEntity;
import bg.softuni.musicstore.model.entity.UserEntity;
import bg.softuni.musicstore.model.enums.RoleNameEnums;
import bg.softuni.musicstore.repository.RoleRepository;
import bg.softuni.musicstore.repository.UserRepository;
import bg.softuni.musicstore.web.ObjectNotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {

    private UserEntity testUser;
    private RoleEntity adminRole, moderatorRole, userRole;

    UserServiceImpl serviceToTest;

    PasswordEncoder testPasswordEncoder;
    private UserRepository testUserRepository;
    private RoleRepository testRoleRepository;
    private MusicstoreUserServiceImpl testMusicstoreUserService;
    private ModelMapper testModelMapper;

    @Mock
    UserRepository mockUserRepository;

    @BeforeEach
    void setUp() {

        adminRole = new RoleEntity();
        adminRole.setRole(RoleNameEnums.ADMIN);

        moderatorRole = new RoleEntity();
        moderatorRole.setRole(RoleNameEnums.MODERATOR);

        userRole = new RoleEntity();
        userRole.setRole(RoleNameEnums.USER);

        testUser = new UserEntity();
        testUser.setId(1L);
        testUser.setUsername("admin");
        testUser.setEmail("admin@email.com");
        testUser.setPassword("1234");
        testUser.setRoles(List.of(adminRole, moderatorRole, userRole));
    }

    @Test
    void testFindByUsername() {

        Mockito.when(mockUserRepository.findByUsername(testUser.getUsername()))
                .thenReturn(Optional.of(testUser));

        var actual =
                mockUserRepository.findByUsername(testUser.getUsername());

        Assertions.assertEquals(actual.get().getUsername(), testUser.getUsername());
    }

}