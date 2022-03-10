package com.company.weddingrsvpservice.controller;

import com.company.weddingrsvpservice.model.RsvpEvent;
import com.company.weddingrsvpservice.model.RsvpGuests;
import com.company.weddingrsvpservice.repository.EventRepository;
import com.company.weddingrsvpservice.repository.GuestRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.jupiter.MockitoSettings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.mockito.Mockito.doReturn;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(RsvpController.class)
public class RsvpControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    EventRepository eventRepository;

    @MockBean
    GuestRepository guestRepository;

    private ObjectMapper objectMapper = new ObjectMapper();


    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void shouldReturnTheEventById() throws Exception {

        RsvpGuests guests = new RsvpGuests();
        guests.setGuestName("Snow");
        guests.setTotalInvited(5);
        guests.setGuestEmail("one@mail.com");
        guests.setGuestId(3);
        guests.setId(4);
        guests.setAttending(true);

        Set<RsvpGuests> guestList = new HashSet<>();
        guestList.add(guests);

        RsvpEvent outputEvent = new RsvpEvent();
        outputEvent.setEventName("Tom and Jerry");
        outputEvent.setLocation("ST.Luke church");
        outputEvent.setId(3);
        outputEvent.setGuests(guestList);



        String outputJson = objectMapper.writeValueAsString(outputEvent);

        when(eventRepository.findById(3)).thenReturn(Optional.of(outputEvent));

        mockMvc.perform(get("/events/3"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(outputJson));
    }

    @Test
    public void shouldReturnAllGuests() throws Exception {

        RsvpGuests outputGuests = new RsvpGuests();
        outputGuests.setGuestName("Tom");
        outputGuests.setGuestId(2);
        outputGuests.setId(3);
        outputGuests.setGuestEmail("tom@gmail.com");
        outputGuests.setAttending(true);
        outputGuests.setTotalInvited(5);

        Set<RsvpGuests> guestList = new HashSet<>();
        guestList.add(outputGuests);

        String outputJson = objectMapper.writeValueAsString(guestList);

//        when(guestRepository.findAll()).thenReturn();

        mockMvc.perform(get("/guests"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(outputJson));
    }

    @Test
    public void shouldCreateAnEvent() throws Exception {

        RsvpEvent inputEvent = new RsvpEvent();
        inputEvent.setEventName("Tom and Jerry");
        inputEvent.setLocation("New York");

        String inputJson = objectMapper.writeValueAsString(inputEvent);

        RsvpEvent outputEvent = new RsvpEvent();
        outputEvent.setEventName("Tom and Jerry");
        outputEvent.setLocation("New York");
        outputEvent.setId(3);

        String outputJson = objectMapper.writeValueAsString(outputEvent);

        mockMvc.perform(
                        post("/rsvpEvent")
                                .content(inputJson)
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(content().json(outputJson));
    }
}