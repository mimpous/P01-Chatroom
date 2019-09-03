package edu.udacity.java.nano.chat;

import com.alibaba.fastjson.JSONObject;

public class Message {

	 private JSONObject json;
	/**
	 * 
	 */
    private String type;
    
    /**
     * 
     */
    private String onlineCount;
    
    /**
     * 
     */
    private String username;
    
    /**
     * 
     */
    private String msg;
    
    /**
     * 
     * @param type
     * @param count
     * @param userName
     * @param msg
     */
    public Message( String type , String count, String userName ,String msg ) {
    	this.type = type;
    	this.onlineCount = count;
    	this.username = userName;
    	this.msg = msg;
    }

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getOnlineCount() {
		return onlineCount;
	}

	public void setOnlineCount(String onlineCount) {
		this.onlineCount = onlineCount;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
 
}
