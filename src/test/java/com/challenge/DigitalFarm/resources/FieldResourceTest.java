package com.challenge.DigitalFarm.resources;

import com.challenge.DigitalFarm.builder.FieldBuilder;
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
class FieldResourceTest {

    @Autowired
    private FieldBuilder fieldBuilder;

    @Autowired
    private MockMvc mvc;

    @Test
    void getAllFields() throws Exception{

        fieldBuilder.persistField();

        mvc.perform(get("/field")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content()
                        .contentTypeCompatibleWith(MediaType.APPLICATION_JSON));

    }

    @Test
    void addField()  throws Exception {

        mvc.perform( MockMvcRequestBuilders
                .post("/field")
                .content(new ObjectMapper().writeValueAsString(fieldBuilder.createField()))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());

    }
}