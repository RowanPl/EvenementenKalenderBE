package com.example.evenementenkalenderbe.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.hamcrest.Matchers.is;
import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8;

@SpringBootTest
@AutoConfigureMockMvc(addFilters = false)
class EventControllerTest {


    @Autowired
    MockMvc mockMvc;


    @Test
    @WithMockUser(username = "testAdmin", password = "test", authorities = {"CREATOR", "ROLE_ADMIN"})
    public void shouldRetrieveCorrectNameOfEvent() throws Exception {

        String requestJson = """
                    {
                       
                        "nameOfEvent": "De nieuwe kleren van de keizer",
                        "linkToEvent": "spelgroep.nl",
                        "time": "20:00",
                        "moreInformation": "There is no more info",
                        "location": "Bennekom",
                        "eventType": "Theater"
                       
                   
                    }
                """;

        MvcResult result = this.mockMvc
                .perform(MockMvcRequestBuilders.post("/events")
                        .contentType(APPLICATION_JSON_UTF8)
                        .content(requestJson))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.header().exists("Location"))
                .andReturn();

        String location = result.getResponse().getHeader("Location");


        mockMvc
                .perform(MockMvcRequestBuilders.get(location))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.nameOfEvent", is("De nieuwe kleren van de keizer")));

    }


    @Test
    @WithMockUser(username = "testAdmin", password = "test", authorities = {"CREATOR", "ROLE_ADMIN"})
    public void shouldDeleteEvent() throws Exception {

            String requestJson = """
                        {
                        
                            "nameOfEvent": "De nieuwe kleren van de keizer",
                            "linkToEvent": "spelgroep.nl",
                            "time": "20:00",
                            "moreInformation": "There is no more info",
                            "location": "Bennekom",
                            "eventType": "Theater"
                        
                    
                        }
                    """;

            MvcResult result = this.mockMvc
                    .perform(MockMvcRequestBuilders.post("/events")
                            .contentType(APPLICATION_JSON_UTF8)
                            .content(requestJson))
                    .andDo(MockMvcResultHandlers.print())
                    .andExpect(MockMvcResultMatchers.status().isCreated())
                    .andExpect(MockMvcResultMatchers.header().exists("Location"))
                    .andReturn();

            String location = result.getResponse().getHeader("Location");

            mockMvc
                    .perform(MockMvcRequestBuilders.delete(location))
                    .andDo(MockMvcResultHandlers.print())
                    .andExpect(MockMvcResultMatchers.status().isNoContent());

    }

}