package com.sachindramaharjan.catalogue.test.controller;

import com.sachindramaharjan.catalogue.core.entity.User;
import com.sachindramaharjan.catalogue.core.service.UserService;
import com.sachindramaharjan.catalogue.mvc.restcontroller.UserController;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.internal.exceptions.ExceptionIncludingMockitoWarnings;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.Matchers.endsWith;
import static org.hamcrest.Matchers.hasItem;
import static org.mockito.Mockito.when;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.*;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.verify;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Created by sachindra.maharjan on 4/13/16.
 */
public class UserControllerTest {

    @InjectMocks
    private UserController userController;

    @Mock
    private UserService userService;

    MockMvc mockMvc;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
    }

    @Test
    public void findUser() throws Exception{

        User user = new User();
        user.setId(new Long(1));
        user.setUsername("sachindra");
        user.setPassword("maharjan");


        when(userService.findUserByUsername("sachindra")).thenReturn(user);

        mockMvc.perform(get("/catalogue/rest/findUser/sachindra"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.username", is("sachindra")))
                .andExpect(jsonPath("$.links[*].href", hasItem(endsWith("/findUser/sachindra"))))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andDo(print());

    }

    @Test
    public void loginUser() throws Exception {
        User user = new User();
        user.setId(new Long(1));
        user.setUsername("sachindra");
        user.setPassword("maharjan");

        when(userService.isValidUser(any(User.class))).thenReturn(true);

        mockMvc.perform(post("/catalogue/rest/login")
                        .content("{\"username\":\"sachindra\",\"password\":\"maharjan\"}")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(header().string("Location", endsWith("/catalogue/rest/findUser/sachindra")))
                .andDo(print());

    }

}
