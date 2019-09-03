package edu.udacity.java.nano.chat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@WebMvcTest
public class WebSocketChatApplicationTest {

	@Autowired
	private MockMvc mockMvc;
	
	private Message message;
//	
//	@Test
//    public void login() throws Exception {
//        this.mockMvc.perform(get("/")).andDo(print()).andExpect(status().isOk())
//                .andExpect(view().name("/login"));
//    }
	
}
