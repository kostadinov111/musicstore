package bg.softuni.musicstore.web;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class ModeratorManageAlbumsControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @WithMockUser(username = "moderator", roles = {"MODERATOR"})
    void testManageAlbumsForm() throws Exception {

        mockMvc
                .perform(get("/artists/manage/albums"))
                .andExpect(status().isOk())
                .andExpect(view().name("moderator-manage-albums"))
                .andExpect(content().contentType("text/html;charset=UTF-8"));
    }

    @Test
    @WithMockUser
    void testManageAlbumsFormNotLoggedInWithModeratorRole() throws Exception {

        mockMvc
                .perform(get("/artists/manage/albums"))
                .andExpect(status().isForbidden());
    }

}