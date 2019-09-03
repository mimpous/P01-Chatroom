package edu.udacity.java.nano.chat;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.websocket.EncodeException;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
 


/**
 * WebSocket Server
 *
 * @see ServerEndpoint WebSocket Client
 * @see Session   WebSocket Session
 */

@Component 
@ServerEndpoint(
		  value = "/chat", 
		  encoders = { MessageEncoder.class }, 
		  decoders = { MessageDecoder.class }
)
public class WebSocketChatServer {

	@Autowired
	private static WebSocketConfig config1;
 	 
	    
    /**
     * All chat sessions.
     */
    private static Map<String, Session> onlineSessions = new ConcurrentHashMap<>();
    
    /**
     * 
     * @param messageObj
     * @throws IOException
     * @throws EncodeException
     */
    private   void sendMessageToAll(Message  messageObj) throws IOException, EncodeException {
    	
   	 for (Map.Entry me : onlineSessions.entrySet()) {
   		 Session asession = (Session)me.getValue();
   		 asession.getBasicRemote().sendObject(messageObj);
     }  
   }
    

    /**
     * Open connection, 1) add session, 2) add user.
     * @throws EncodeException 
     * @throws IOException 
     */
    @OnOpen
    public void onOpen(Session session ) throws IOException, EncodeException {	
     	System.out.println(" username " + session.getId());
    	onlineSessions.put(session.getId(), session);
    	
    	sendMessageToAll(new Message( "ENTER",String.valueOf( onlineSessions.size() ), "", ""));    	
    }

    /**
     * Send message, 1) get username and session, 2) send message to all.
     * @throws IOException 
     * @throws EncodeException 
     */
    @OnMessage
    public void onMessage(Session session, String jsonStr) throws IOException, EncodeException {
    	 
    	JSONObject jsonObject = JSON.parseObject(jsonStr);
    	System.out.println(jsonStr);
    	String msg = jsonObject.getString("msg");
    	String userName = jsonObject.getString("username");
    	sendMessageToAll(new Message( "SPEAK",String.valueOf( onlineSessions.size() ), userName, msg));
    	 	 
    }
  
    /**
     * Close connection, 1) remove session, 2) update user.
     * @throws EncodeException 
     * @throws IOException 
     */
    @OnClose
    public void onClose(Session session) throws IOException, EncodeException { 
    	onlineSessions.remove(session.getId() );

    	if (onlineSessions.size() > 0)
    		sendMessageToAll(new Message( "QUIT",String.valueOf( onlineSessions.size() ), "", ""));
    }

    /**
     * Print exception.
     */
    @OnError
    public void onError(Session session, Throwable error) {
        error.printStackTrace();
    }

}
