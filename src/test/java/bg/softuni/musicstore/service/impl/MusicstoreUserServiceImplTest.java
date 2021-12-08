package bg.softuni.musicstore.service.impl;

import bg.softuni.musicstore.model.entity.RoleEntity;
import bg.softuni.musicstore.model.entity.UserEntity;
import bg.softuni.musicstore.model.enums.RoleNameEnums;
import bg.softuni.musicstore.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class MusicstoreUserServiceImplTest {

    private UserEntity testUser;
    private RoleEntity adminRole, moderatorRole, userRole;

    MusicstoreUserServiceImpl serviceToTest;

    @Mock
    private UserRepository mockUserRepository;

    @BeforeEach
    void init() {

        // Arrange
        serviceToTest = new MusicstoreUserServiceImpl(mockUserRepository);

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
    void testUsernameNotFound() {

        Assertions.assertThrows(
                UsernameNotFoundException.class,
                () -> serviceToTest.loadUserByUsername("invalid-user-email@wrong-domain"));
    }

//    @Test
//    void testUsernameFound() {
//
//        // Arrange
//        Mockito.when(mockUserRepository.findByUsername(testUser.getUsername()))
//                .thenReturn(Optional.of(testUser));
//
//        // Act
//        var actual =
//                serviceToTest.loadUserByUsername(testUser.getUsername());
//
//        System.out.println();
//        // Assert
//        Assertions.assertEquals(actual.getUsername(), testUser.getUsername());
//    }

}