package com.example.demo;


import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@WebMvcTest
class ControllerTest {
	
	private static final ObjectMapper om = new ObjectMapper();
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private UserService userService;

	@Test
	public void testget() throws Exception{
		User user = new User();
		user.setId(1);
		user.setUserName("Amit");
		user.setPwd("Opentext@767");
		
		when(userService.findByuserNameAndPwd("Amit", "Opentext@767")).thenReturn(user);
		
		this.mockMvc.perform(get("/user/Amit/Opentext@767")).andExpect(status().isOk());
	}
	
	@Test
	public void testpost() throws Exception{
		User user = new User();
		user.setId(1);
		user.setUserName("Pankaj");
		user.setPwd("Dualipa#95");
		
		
		when(userService.save(user)).thenReturn(user);
		
		 mockMvc.perform(post("/user").content(om.writeValueAsString(user))
	     .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON))
         .andExpect(status().isOk());
	}

}
