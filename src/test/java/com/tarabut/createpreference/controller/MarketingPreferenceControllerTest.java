package com.tarabut.createpreference.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rama.createpreference.controller.MarketingPreferenceController;
import com.rama.createpreference.dto.PostMarketingPreferenceDTO;
import com.rama.createpreference.dto.UpdateMarketingPreferenceDTO;
import com.rama.createpreference.entity.MarketingPreference;
import com.rama.createpreference.service.MarketingPreferenceService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
public class MarketingPreferenceControllerTest {

    @Mock
    private MarketingPreferenceService marketingPreferenceService;
    private MockMvc mockMvc;

    @BeforeEach
    public void setup() {
        MarketingPreferenceController marketingPreferenceController =
                new MarketingPreferenceController(marketingPreferenceService);
        mockMvc =
                MockMvcBuilders.standaloneSetup(marketingPreferenceController)
                        .build();
    }

    @Test
    public void shouldAbleToUpdateMarketPreference() throws Exception {
        // Arrange
        MarketingPreference marketingPreference = new MarketingPreference();
        marketingPreference.setId(1);
        marketingPreference.setCustomerId(1);
        marketingPreference.setEmail(true);
        marketingPreference.setPost(true);
        marketingPreference.setSms(true);
        ObjectMapper objectMapper = new ObjectMapper();
        String requestPayload = objectMapper.writeValueAsString(marketingPreference);
        when(marketingPreferenceService.findOne(eq(1))).thenReturn(marketingPreference.toGetMarketingPreferenceDTO());
        when(marketingPreferenceService.update(any(UpdateMarketingPreferenceDTO.class))).thenReturn(marketingPreference.toGetMarketingPreferenceDTO().get());

        // Act
        MvcResult mockMvcResult =
                this.mockMvc.perform(MockMvcRequestBuilders.put("/marketing-preferences").contentType(MediaType.APPLICATION_JSON).content(requestPayload)).andExpect(status().isOk())
                        .andExpect(content().contentType("application/json"))
                        .andExpect(jsonPath("$.id", is(notNullValue())))
                        .andExpect(jsonPath("$.customerId", is(notNullValue())))
                        .andExpect(jsonPath("$.customerId", is(1)))
                        .andExpect(jsonPath("$.email", is(true)))
                        .andExpect(jsonPath("$.post", is(true)))
                        .andExpect(jsonPath("$.sms", is(true))).andReturn();

        // Assert
        Assertions.assertThat(mockMvcResult.getResponse().getStatus()).isEqualTo(HttpStatus.OK.value());
    }

    @Test
    public void shouldNotAbleToUpdateMarketPreferenceWithInvalidData() throws Exception {
        // Arrange
        MarketingPreference marketingPreference = new MarketingPreference();
        marketingPreference.setId(0);
        marketingPreference.setCustomerId(0);
        marketingPreference.setEmail(true);
        marketingPreference.setPost(true);
        marketingPreference.setSms(true);
        ObjectMapper objectMapper = new ObjectMapper();
        String requestPayload = objectMapper.writeValueAsString(marketingPreference);
        when(marketingPreferenceService.findOne(eq(1))).thenReturn(marketingPreference.toGetMarketingPreferenceDTO());
        when(marketingPreferenceService.update(any(UpdateMarketingPreferenceDTO.class))).thenReturn(marketingPreference.toGetMarketingPreferenceDTO().get());

        // Act
        MvcResult mockMvcResult =
                this.mockMvc.perform(MockMvcRequestBuilders.put("/marketing-preferences").contentType(MediaType.APPLICATION_JSON)
                        .content(requestPayload))
                        .andExpect(status().is(400))
                        .andReturn();

        // Assert
        Assertions.assertThat(mockMvcResult.getResponse().getStatus()).isEqualTo(HttpStatus.BAD_REQUEST.value());
    }

    @Test
    public void shouldAbleToSave() throws Exception {
        // Arrange
        MarketingPreference marketingPreference = new MarketingPreference();
        marketingPreference.setId(1);
        marketingPreference.setCustomerId(1);
        marketingPreference.setEmail(true);
        marketingPreference.setPost(true);
        marketingPreference.setSms(true);
        ObjectMapper objectMapper = new ObjectMapper();
        String requestPayload = objectMapper.writeValueAsString(marketingPreference);
        when(marketingPreferenceService.save(any(PostMarketingPreferenceDTO.class))).thenReturn(marketingPreference.toGetMarketingPreferenceDTO().get());

        // Act
        MvcResult mockMvcResult =
                this.mockMvc.perform(MockMvcRequestBuilders.post("/marketing-preferences").contentType(MediaType.APPLICATION_JSON).content(requestPayload).accept(
                        "application/json"))
                        .andExpect(jsonPath("$.customerId", is(notNullValue())))
                        .andExpect(jsonPath("$.customerId", is(1)))
                        .andExpect(jsonPath("$.email", is(true)))
                        .andExpect(jsonPath("$.post", is(true)))
                        .andExpect(jsonPath("$.sms", is(true)))
                        .andExpect(status().is(HttpStatus.CREATED.value()))
                        .andExpect(content().contentType("application/json"))
                        .andReturn();

        // Assert
        Assertions.assertThat(mockMvcResult.getResponse().getStatus()).isEqualTo(HttpStatus.CREATED.value());
    }

    @Test
    public void shouldAbleToDelete() throws Exception {
        // Arrange
        doNothing().when(marketingPreferenceService).delete(any(Integer.class));

        // Act
        MvcResult mockMvcResult =
                this.mockMvc.perform(MockMvcRequestBuilders.delete("/marketing-preferences/1").accept(
                        "application/json")).andReturn();

        // Assert
        Assertions.assertThat(mockMvcResult.getResponse().getStatus()).isEqualTo(HttpStatus.NO_CONTENT.value());
    }

}