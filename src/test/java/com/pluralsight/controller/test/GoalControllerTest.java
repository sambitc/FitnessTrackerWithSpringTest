/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pluralsight.controller.test;

import com.pluralsight.filter.ExUsernamePasswordAuthenticationFilter;
import com.pluralsight.model.Goal;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.web.FilterChainProxy;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.util.NestedServletException;

/**
 *
 * @author sambitc
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {
    "/testConfig/security-config.xml",
    "/testConfig/servlet-config.xml",
    "/testConfig/jpaContext.xml"})
public class GoalControllerTest extends AbstractSecurityTest{

    @Autowired
    private FilterChainProxy springSecurityFilterChain;

    @Autowired
    private WebApplicationContext wac;

    @Autowired
    ExUsernamePasswordAuthenticationFilter filter;

    private MockMvc mockMvc;

    @Before
    public void init() {
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }

    @Test
    public void addGoalTest() throws Exception {

        login("prasady:mindfire");

        this.mockMvc.perform(post("/addGoal")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("minutes", "30")
                .sessionAttr("goal", new Goal())
        )
                .andExpect(status().isMovedTemporarily())
                .andExpect(redirectedUrl("index.jsp"));
    }

    @Test
    public void addGoalInvalidTest() throws Exception {
        login("prasady:mindfire");

        this.mockMvc.perform(post("/addGoal")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("minutes", "-1")
                .sessionAttr("goal", new Goal())
        )
                .andExpect(view().name("addGoal"));
    }

    @Test(expected = NestedServletException.class)
    public void addGoalUnAuthTest() throws Exception {
        login("sambitc:mindfire");

        this.mockMvc.perform(post("/addGoal")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("minutes", "30")
                .sessionAttr("goal", new Goal())
        );
    }
}
