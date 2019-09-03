package edu.udacity.java.nano.chat;

import javax.websocket.DecodeException;
import javax.websocket.Decoder;
import javax.websocket.EndpointConfig;

import com.alibaba.fastjson.JSONObject;

public class MessageDecoder implements Decoder.Text<Message> {

	

	@Override
	public void init(EndpointConfig endpointConfig) {
		System.out.println("MessageDecoder.init()");
		
	}

	@Override
	public void destroy() {
		System.out.println("MessageDecoder.destroy()");
		
	} 
	
	@Override
	public Message decode(String s) throws DecodeException {
		
		 JSONObject jsonObject = JSONObject.parseObject(s);
		  
			    Message message = new Message(
			    		jsonObject.getString("type"),
			    		jsonObject.getString("onlineCount"),
			    		jsonObject.getString("username"),
			    		jsonObject.getString("msg")
			    		); 
		return message;			     
	}

	@Override
	public boolean willDecode(String s) {
		try {
				JSONObject jsonObject = JSONObject.parseObject(s);
		      return true;
		    } catch (Exception e) {
		      return false;
		    }
		  
	}

}
