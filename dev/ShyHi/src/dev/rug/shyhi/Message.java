package dev.rug.shyhi;

import java.security.Timestamp;
import java.util.UUID;
import com.google.gson.annotations.SerializedName;

public class Message {
	
	@SerializedName("to")
	private UUID toID;
	@SerializedName("from")
	private UUID fromID;
	@SerializedName("timestamp")
	private Timestamp msgTimestamp;
	@SerializedName("message")
	private String message;
	
	public Message(){};
	public Message(UUID to, UUID from, Timestamp ts,String msg){
		toID = to;
		fromID = from;
		msgTimestamp = ts;
		message = msg;
	}
	
	public UUID getToID(){
		return toID;
	}
	public UUID getFromID(){
		return fromID;
	}
	public Timestamp getTimestamp(){
		return msgTimestamp;
	}
	public String getMessage(){
		return message;
	}
	public void setToID(UUID t){
		toID = t;
	}
	public void setFromID(UUID f){
		fromID = f;
	}
	public void setMessage(String msg){
		message = msg;
	}
	
}
