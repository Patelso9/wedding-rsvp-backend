package com.company.weddingrsvpservice.controller;

import com.company.weddingrsvpservice.exceptions.NotFoundException;
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

import java.util.*;

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
    public void shouldReturn404StatusCodeWhenInvalidEventId() throws Exception {

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

        when(eventRepository.findById(5)).thenThrow(NotFoundException.class);

        mockMvc.perform(
                        get("/events/5")
                                .content(outputJson)
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isNotFound());
    }

    @Test
    public void shouldCreateEventAndGuest() throws Exception {

        RsvpGuests inputGuests = new RsvpGuests();
        inputGuests.setGuestName("Snow");
        inputGuests.setTotalInvited(5);
        inputGuests.setGuestEmail("one@mail.com");
        inputGuests.setGuestId(3);
        inputGuests.setId(4);
        inputGuests.setAttending(true);

        Set<RsvpGuests> guestList = new HashSet<>();
        guestList.add(inputGuests);

        RsvpEvent inputEventAndGuest = new RsvpEvent();
        inputEventAndGuest.setEventName("Tom and Jerry");
        inputEventAndGuest.setLocation("ST.Luke church");
        inputEventAndGuest.setGuests(guestList);


        String inputJson = objectMapper.writeValueAsString(inputEventAndGuest);

        RsvpGuests outputGuests = new RsvpGuests();
        outputGuests.setGuestName("Snow");
        outputGuests.setTotalInvited(5);
        outputGuests.setGuestEmail("one@mail.com");
        outputGuests.setGuestId(3);
        outputGuests.setId(4);
        outputGuests.setAttending(true);

        Set<RsvpGuests> outputGuestList = new HashSet<>();
        outputGuestList.add(outputGuests);

        RsvpEvent outputEventAndGuest = new RsvpEvent();
        outputEventAndGuest.setEventName("Tom and Jerry");
        outputEventAndGuest.setLocation("ST.Luke church");
        outputEventAndGuest.setId(4);
        outputEventAndGuest.setGuests(outputGuestList);


        String outputJson = objectMapper.writeValueAsString(outputEventAndGuest);

        doReturn(outputEventAndGuest).when(eventRepository).save(inputEventAndGuest);

        mockMvc.perform(
                        post("/rsvpEvent/addEventGuest")
                                .content(inputJson)
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(content().json(outputJson));
    }

    @Test
    public void shouldReturnAllGuests() throws Exception {

        List<RsvpGuests> guestsList = new ArrayList<>();
        RsvpGuests outputGuests = new RsvpGuests();

        outputGuests.setGuestName("Tom");
        outputGuests.setGuestId(2);
        outputGuests.setId(3);
        outputGuests.setGuestEmail("tom@gmail.com");
        outputGuests.setAttending(true);
        outputGuests.setTotalInvited(5);
        guestsList.add(outputGuests);

//        Set<RsvpGuests> guestList = new HashSet<>();
//        guestList.add(outputGuests);

        String outputJson = objectMapper.writeValueAsString(guestsList);

//        when(guestRepository.findAll()).thenReturn(outputGuests);
        when(guestRepository.findAll()).thenReturn(guestsList);

        mockMvc.perform(get("/guests"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(outputJson));
    }

    @Test
    public void shouldReturnAllEvents() throws Exception {

        List<RsvpEvent> eventList = new ArrayList<>();

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

        eventList.add(outputEvent);

//        Set<RsvpGuests> guestList = new HashSet<>();
//        guestList.add(outputGuests);

        String outputJson = objectMapper.writeValueAsString(eventList);

        when(eventRepository.findAll()).thenReturn(eventList);

        mockMvc.perform(get("/events"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(outputJson));
    }

    @Test
    public void shouldReturnGuestsById() throws Exception {

        RsvpGuests outputGuests = new RsvpGuests();

        outputGuests.setGuestName("Tom");
        outputGuests.setGuestId(2);
        outputGuests.setId(3);
        outputGuests.setGuestEmail("tom@gmail.com");
        outputGuests.setAttending(true);
        outputGuests.setTotalInvited(5);

        String outputJson = objectMapper.writeValueAsString(outputGuests);

        when(guestRepository.findById(3)).thenReturn(Optional.of(outputGuests));

        mockMvc.perform(get("/guests/3"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(outputJson));
    }

    @Test
    public void shouldReturn404StatusCodeWhenInvalidGuestId() throws Exception {

        RsvpGuests outputGuests = new RsvpGuests();

        outputGuests.setGuestName("Tom");
        outputGuests.setGuestId(2);
        outputGuests.setId(5);
        outputGuests.setGuestEmail("tom@gmail.com");
        outputGuests.setAttending(true);
        outputGuests.setTotalInvited(5);

        String outputJson = objectMapper.writeValueAsString(outputGuests);

        when(guestRepository.findById(8)).thenThrow(NotFoundException.class);

        mockMvc.perform(
                        get("/guests/8")
                                .content(outputJson)
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isNotFound());
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

        doReturn(outputEvent).when(eventRepository).save(inputEvent);

        mockMvc.perform(
                        post("/rsvpEvent")
                                .content(inputJson)
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(content().json(outputJson));
    }

    @Test
    public void shouldCreateAGuest() throws Exception {

        RsvpGuests inputGuests = new RsvpGuests();
        inputGuests.setGuestName("John Snow");
        inputGuests.setGuestId(3);
        inputGuests.setGuestEmail("snow@gmail.com");
        inputGuests.setAttending(true);
        inputGuests.setTotalInvited(5);

        String inputJson = objectMapper.writeValueAsString(inputGuests);

        RsvpGuests outputGuests = new RsvpGuests();
        outputGuests.setGuestName("John Snow");
        outputGuests.setGuestId(3);
        outputGuests.setGuestEmail("snow@gmail.com");
        outputGuests.setAttending(true);
        outputGuests.setTotalInvited(5);
        outputGuests.setId(5);

        String outputJson = objectMapper.writeValueAsString(outputGuests);


        doReturn(outputGuests).when(guestRepository).save(inputGuests);

        mockMvc.perform(
                        post("/rsvpGuest")
                                .content(inputJson)
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(content().json(outputJson));
    }

    @Test
    public void shouldRespondWith204WhenUpdatingGuestById() throws Exception {

        RsvpGuests inputGuests = new RsvpGuests();
        inputGuests.setGuestName("John Snow");
        inputGuests.setGuestId(3);
        inputGuests.setGuestEmail("snow@gmail.com");
        inputGuests.setAttending(true);
        inputGuests.setTotalInvited(5);
        inputGuests.setId(1);

        String inputJson = objectMapper.writeValueAsString(inputGuests);


        mockMvc.perform(put("/guests/1")
                        .content(inputJson)
                        .contentType(MediaType.APPLICATION_JSON))
                        .andExpect(status().isNoContent());
    }

    @Test
    public void shouldRespondWith422WhenUpdatingGuestByInvalidId() throws Exception {

        RsvpGuests inputGuests = new RsvpGuests();
        inputGuests.setGuestName("John Snow");
        inputGuests.setGuestId(3);
        inputGuests.setGuestEmail("snow@gmail.com");
        inputGuests.setAttending(true);
        inputGuests.setTotalInvited(5);
        inputGuests.setId(1);

        String inputJson = objectMapper.writeValueAsString(inputGuests);


        mockMvc.perform(put("/guests/5")
                        .content(inputJson)
                        .contentType(MediaType.APPLICATION_JSON))
                        .andExpect(status().isUnprocessableEntity());
    }

    @Test
    public void shouldRespondWith204WhenUpdatingEventById() throws Exception {

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


        mockMvc.perform(put("/events/3")
                        .content(outputJson)
                        .contentType(MediaType.APPLICATION_JSON))
                        .andExpect(status().isNoContent());
    }

    @Test
    public void shouldRespondWith422WhenUpdatingEventByInvalidId() throws Exception {

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


        mockMvc.perform(put("/events/21")
                        .content(outputJson)
                        .contentType(MediaType.APPLICATION_JSON))
                        .andExpect(status().isUnprocessableEntity());
    }

    @Test
    public void deleteTheGuestById() throws Exception {

        guestRepository.deleteById(1);

        mockMvc.perform(delete("/guests/1"))
                .andExpect(status().isNoContent());
    }

    @Test
    public void deleteTheEventById() throws Exception {

        eventRepository.deleteById(1);

        mockMvc.perform(delete("/events/1"))
                .andExpect(status().isNoContent());
    }
}