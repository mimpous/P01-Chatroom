package edu.udacity.java.nano.chat;

import javax.websocket.EncodeException;
import javax.websocket.Encoder;
import javax.websocket.EndpointConfig;

import com.alibaba.fastjson.JSONObject;

public class MessageEncoder implements Encoder.Text<Message> {

  @Override
  public String encode(Message message) throws EncodeException {
	JSONObject retObj = new JSONObject();

	retObj.put("type", message.getType());
	retObj.put("onlineCount", message.getOnlineCount());
	retObj.put("username", message.getUsername());
	retObj.put("msg", message.getMsg());
	
    return retObj.toString();

  }

  @Override
  public void init(EndpointConfig ec) {
    System.out.println("MessageEncoder - init method called");
  }

  @Override
  public void destroy() {
    System.out.println("MessageEncoder - destroy method called");
  }

}
