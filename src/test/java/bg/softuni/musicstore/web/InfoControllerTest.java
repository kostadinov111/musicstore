package bg.softuni.musicstore.web;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@SpringBootTest
@AutoConfigureMockMvc
class InfoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testOpenInfoJazzForm() throws Exception {

        mockMvc
                .perform(get("/info/jazz"))
                .andExpect(status().isOk())
                .andExpect(view().name("info-jazz"));
    }

    @Test
    void testOpenInfoRocksForm() throws Exception {

        mockMvc
                .perform(get("/info/hard-rock"))
                .andExpect(status().isOk())
                .andExpect(view().name("info-hard-rock"));
    }

    @Test
    void testOpenInfoBreakForm() throws Exception {

        mockMvc
                .perform(get("/info/hip-hop"))
                .andExpect(status().isOk())
                .andExpect(view().name("info-hip-hop"));
    }

}