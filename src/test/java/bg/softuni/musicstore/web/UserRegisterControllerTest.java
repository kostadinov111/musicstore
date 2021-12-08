package bg.softuni.musicstore.web;

import bg.softuni.musicstore.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;

@SpringBootTest
@AutoConfigureMockMvc
class UserRegisterControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private UserRepository userRepository;

    @Test
    void testOpenRegisterForm() throws Exception {

        mockMvc
                .perform(get("/users/register"))
                .andExpect(status().isOk())
                .andExpect(view().name("register"));
    }

    private static final String TEST_USER_USERNAME = "pesho";
    private static final String TEST_USER_EMAIL = "pesho@email.com";

    @Test
    void testRegisterUser() throws Exception {

        mockMvc
                .perform(post("/users/register")
                        .param("username", TEST_USER_USERNAME)
                        .param("password", "1234")
                        .param("confirmPassword", "1234")
                        .param("email", TEST_USER_EMAIL)
                        .param("fisrtName", "Pesho")
                        .param("lastName", "Peshov")
                        .param("age", "20")
                        .with(csrf())
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                )
                .andExpect(status().is3xxRedirection());
    }


}