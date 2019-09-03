package edu.udacity.java.nano;

import java.net.UnknownHostException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class WebSocketChatApplicationController {

	  /**
     * Login Page
     */
    @GetMapping("/")
    public ModelAndView login() {
        return new ModelAndView("login");
    }
    
    /**
     * Chatroom Page
     */
    @GetMapping("/index")
    public ModelAndView index(String username, HttpServletRequest request) throws UnknownHostException {
    	request.setAttribute("username", username);
    	request.getSession().setAttribute("username", username);
    	return new ModelAndView("chat");
    }

}
