package com.challenge.DigitalFarm.resources;

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
class HarvestResourceTest {

    @Autowired
    private HarvestBuilder harvestBuilder;

    @Autowired
    private MockMvc mvc;

    @Test
    void getAllHarvests() throws Exception {

        harvestBuilder.persistHarvest();

        mvc.perform(get("/harvest")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content()
                        .contentTypeCompatibleWith(MediaType.APPLICATION_JSON));

    }

    @Test
    void addHarvest() throws Exception {

        mvc.perform( MockMvcRequestBuilders
                .post("/harvest")
                .content(new ObjectMapper().writeValueAsString(harvestBuilder.createHarvest()))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());

    }
}