package com.example.clubspring.controllersTest;

import com.example.clubspring.controllers.ClubController;
import com.example.clubspring.models.club.Club;
import com.example.clubspring.models.clubDto.ClubDto;
import com.example.clubspring.services.impl.ClubService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcResultHandlersDsl;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@WebMvcTest(controllers = ClubController.class)
@AutoConfigureMockMvc(addFilters = false)
@ExtendWith(MockitoExtension.class)
public class ClubControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private ClubService clubService;

    @Autowired
    private ObjectMapper objectMapper;

    private Club club;

    private ClubDto clubDto;

    @BeforeEach
    public void init(){
        club = Club.builder().title("Football Club").photoUrl("photo.jpg").build();
        clubDto = ClubDto.builder().title("Football Club").photoUrl("photo.jpg").build();
    }

    @Test
    public void ClubController_CreateClub_ReturnCreated() throws Exception {
        given(clubService.createClub(ArgumentMatchers.any())).willAnswer((invocation -> invocation.getArgument(0)));

        ResultActions response = mockMvc.perform(post("/club/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(clubDto)));

        response.andExpect(MockMvcResultMatchers.status().isCreated());

    }


}
