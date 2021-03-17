package com.challenge.DigitalFarm.resources;

import com.challenge.DigitalFarm.builder.MillBuilder;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class MillResourceTest{

    @Autowired
    private MillBuilder millBuilder;

    @Autowired
    private MockMvc mvc;

    @Test
    void getAllMills() throws Exception {

        millBuilder.persistMill();

        mvc.perform(get("/mill")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content()
                        .contentTypeCompatibleWith(MediaType.APPLICATION_JSON));

    }

    @Test
    void addMill() throws Exception {

        mvc.perform( MockMvcRequestBuilders
                .post("/mill")
                .content(new ObjectMapper().writeValueAsString(millBuilder.createMill()))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());

    }
}