package org.lion;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by lion on 2/12/17.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ApiTests {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testApiDir() throws Exception {

        this.mockMvc.perform(get("/api/report/host")).andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("$.retcode").value(0));
        this.mockMvc.perform(get("/api/report/host?parent=tmp")).andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("$.retcode").value(0));
    }


}
