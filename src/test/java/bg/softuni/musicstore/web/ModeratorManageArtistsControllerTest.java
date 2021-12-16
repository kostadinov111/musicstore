package bg.softuni.musicstore.web;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@SpringBootTest
@AutoConfigureMockMvc
class ModeratorManageArtistsControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @WithMockUser
    void testOpenShowMusiciansForm() throws Exception {

        mockMvc
                .perform(get("/artists"))
                .andExpect(status().isOk())
                .andExpect(view().name("moderator-show-musicians"));
    }

    @Test
    @WithMockUser(username = "moderator", roles = {"MODERATOR"})
    void testOpenManageMusiciansForm() throws Exception {

        mockMvc
                .perform(get("/artists/manage"))
                .andExpect(status().isOk())
                .andExpect(view().name("moderator-manage-artists"));
    }

    @Test
    @WithMockUser
    void testOpenManageMusiciansFormNotLoggedAsModerator() throws Exception {

        mockMvc
                .perform(get("/artists/manage"))
                .andExpect(status().isForbidden());
    }
}