package bg.softuni.musicstore.web;

import bg.softuni.musicstore.model.entity.UserEntity;
import bg.softuni.musicstore.repository.AlbumRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureMockMvc
class ModeratorManageAlbumsRESTControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private AlbumRepository albumRepository;

    private UserEntity testUser;

    @BeforeEach
    void setUp() {

        testUser = new UserEntity();
        testUser.setUsername("admin");
        testUser.setEmail("admin@email.com");
        testUser.setFirstName("Admin");
        testUser.setLastName("Adminov");
        testUser.setAge(23);
        testUser.setEnabled(true);
    }

//    @Test
//    void getAlbums() throws Exception {
//
//        mockMvc.perform(get("/albums"))
//                .andExpect(status().isOk());
//
//    }

}