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
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class OrderControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @WithMockUser
    void testMyOrderForm() throws Exception {

        mockMvc
                .perform(get("/orders/show"))
                .andExpect(status().isOk())
                .andExpect(view().name("orders-show"))
                .andExpect(content().contentType("text/html;charset=UTF-8"));
    }

    @Test
    @WithMockUser
    void testOrderAddForm() throws Exception {

        mockMvc
                .perform(get("/orders/add"))
                .andExpect(status().isOk())
                .andExpect(view().name("orders-add"))
                .andExpect(content().contentType("text/html;charset=UTF-8"));
    }
}