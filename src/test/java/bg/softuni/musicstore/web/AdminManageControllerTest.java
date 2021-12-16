package bg.softuni.musicstore.web;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@SpringBootTest
@AutoConfigureMockMvc
class AdminManageControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @WithMockUser(username="admin",roles={"ADMIN"})
    void testOpenAdminManageForm() throws Exception {

        mockMvc
                .perform(get("/admin/manage"))
                .andExpect(status().isOk())
                .andExpect(view().name("admin-manage"));
    }

    @Test
    @WithMockUser
    void testOpenAdminManageFormWithUserAccount() throws Exception {

        mockMvc
                .perform(get("/admin/manage"))
                .andExpect(status().isForbidden());
    }
}