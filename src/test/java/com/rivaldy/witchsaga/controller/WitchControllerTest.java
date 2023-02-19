package com.rivaldy.witchsaga.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rivaldy.witchsaga.constant.Message;
import com.rivaldy.witchsaga.dto.*;
import com.rivaldy.witchsaga.service.IWitch;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.ArrayList;
import java.util.List;

import static com.rivaldy.witchsaga.constant.Message.ERR_REA_TOTAL_IS_NOT_MATCH;
import static com.rivaldy.witchsaga.constant.Message.ERR_TOTAL_IS_NOT_MATCH;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = WitchController.class)
@Slf4j
class WitchControllerTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private IWitch witchService;

    private String url;
    private VillagerRequest request;
    private int totalPerson;
    private List<PersonRequest> persons;

    @BeforeEach
    void setUp() {
        url = "/witch";
        totalPerson = 2;
        persons = new ArrayList<>();
        persons.add(new PersonRequest(10, 12));
        persons.add(new PersonRequest(13, 17));

        request = new VillagerRequest(totalPerson, persons);
    }

    @Test
    @DisplayName("Will throw error 404 when trying to send request body with totalPerson = 0")
    void whenRequestBodyIsInvalid_thenReturnStatusBadRequest() throws Exception{
        String method = Thread.currentThread().getStackTrace()[1].getMethodName();

        totalPerson = 0;
        request = new VillagerRequest(totalPerson, persons);
        ExceptionResponse expectedRes = new ExceptionResponse(false,
                Message.ERR_DATA_BAD_REQUEST, List.of("Must set the value totalPerson more than 1"));
        String expectedJson = objectMapper.writeValueAsString(expectedRes);

        String body = objectMapper.writeValueAsString(request);

        MvcResult result = mvc
                .perform(post(url)
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .content(body))
                .andExpect(status().isBadRequest())
                .andReturn();

        String actualJson = result.getResponse().getContentAsString();
        ExceptionResponse actualRes = objectMapper.readValue(actualJson, ExceptionResponse.class);

        assertEquals(expectedJson, actualJson);
        assertEquals(expectedRes, actualRes);
        log.info(Message.RESPONSE_TEST, HttpStatus.BAD_REQUEST.value(), result.getResponse().getStatus(), method);
    }

    @Test
    @DisplayName("Will throw error 409 when trying to send request body with total person is not equal to person size")
    void whenRequestTotalPersonIsNotEqualToPersonSize_thenReturnStatusConflict() throws Exception{
        String method = Thread.currentThread().getStackTrace()[1].getMethodName();

        totalPerson = 3;
        request = new VillagerRequest(totalPerson, persons);

        ExceptionResponse expectedRes = new ExceptionResponse(false, ERR_TOTAL_IS_NOT_MATCH, String.format(ERR_REA_TOTAL_IS_NOT_MATCH, totalPerson, persons.size()));
        String expectedJson = objectMapper.writeValueAsString(expectedRes);

        String body = objectMapper.writeValueAsString(request);

        MvcResult result = mvc
                .perform(post(url)
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .content(body))
                .andExpect(status().isConflict())
                .andReturn();

        String actualJson = result.getResponse().getContentAsString();
        ExceptionResponse actualRes = objectMapper.readValue(actualJson, ExceptionResponse.class);

        assertEquals(expectedJson, actualJson);
        assertEquals(expectedRes, actualRes);

        log.info(Message.RESPONSE_TEST, HttpStatus.CONFLICT.value(), result.getResponse().getStatus(), method);
    }

    @Test
    @DisplayName("Will get status 200 when trying to send valid request body")
    void whenRequestIsValid_thenReturnStatusOk() throws Exception{
        String method = Thread.currentThread().getStackTrace()[1].getMethodName();
        request = new VillagerRequest(totalPerson, persons);

        String body = objectMapper.writeValueAsString(request);
        MvcResult result = mvc
                .perform(post(url)
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .content(body))
                .andExpect(status().isOk())
                .andDo(print())
                .andReturn();

        log.info(Message.RESPONSE_TEST, HttpStatus.OK.value(), result.getResponse().getStatus(), method);
    }
}