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
class EventControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @WithMockUser
    void testOpenEventsForm() throws Exception {

        mockMvc
                .perform(get("/events/show"))
                .andExpect(status().isOk())
                .andExpect(view().name("events-show"))
                .andExpect(content().contentType("text/html;charset=UTF-8"));
    }

    @Test
    void testOpenEventsFormAnonymously() throws Exception {

        mockMvc
                .perform(get("/events/show"))
                .andExpect(status().is3xxRedirection());
    }

    @Test
    @WithMockUser(username="admin",roles={"USER","MODERATOR","ADMIN"})
    void testOpenManageEventsForm() throws Exception {

        mockMvc
                .perform(get("/events/manage"))
                .andExpect(status().isOk())
                .andExpect(view().name("events-manage"));
    }

    @Test
    @WithMockUser(username="admin",roles={"USER","MODERATOR","ADMIN"})
    void testOpenEventEditFormWithIncorrectId() throws Exception {

        mockMvc
                .perform(get("/events/manage/edit/1"))
                .andExpect(status().isNotFound())
                .andExpect(view().name("object-not-found"));
    }

    @Test
    @WithMockUser(username="admin",roles={"USER","MODERATOR","ADMIN"})
    void testOpenEventEditForm() throws Exception {

        mockMvc
                .perform(get("/events/manage/edit/1"))
                .andExpect(view().name("object-not-found"));
    }



}