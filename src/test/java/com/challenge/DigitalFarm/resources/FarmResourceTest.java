package com.challenge.DigitalFarm.resources;

import com.challenge.DigitalFarm.builder.FarmBuilder;
import com.challenge.DigitalFarm.builder.HarvestBuilder;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class FarmResourceTest {

    @Autowired
    private FarmBuilder farmBuilder;

    @Autowired
    private MockMvc mvc;

    @Test
    void getAllFarms() throws Exception {

        farmBuilder.persistFarm();

        mvc.perform(get("/farm")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content()
                        .contentTypeCompatibleWith(MediaType.APPLICATION_JSON));

    }

    @Test
    void addFarm()  throws Exception {

        mvc.perform( MockMvcRequestBuilders
                .post("/farm")
                .content(new ObjectMapper().writeValueAsString(farmBuilder.createFarm()))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());

    }
}