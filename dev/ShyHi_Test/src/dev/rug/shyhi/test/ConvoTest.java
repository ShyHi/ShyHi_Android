package dev.rug.shyhi.test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import android.test.AndroidTestCase;
import dev.rug.shyhi.Convo;
import dev.rug.shyhi.Message;

public class ConvoTest extends AndroidTestCase{
	Convo testConvo;
	ArrayList<Message> messagesArray;
	Message msg1;
	Message msg2;
	@Before
	public void setUp() throws Exception {
		msg1 = new Message("user1", "user2","time", "Message Content");
        msg2 = new Message("user2", "user1","time", "Message 2 Content");
        messagesArray = new ArrayList<Message>();
        messagesArray.add(msg1);
        messagesArray.add(msg2);
		testConvo = new Convo("testConvo","user1","user2",messagesArray);

	}

	@Test
	public void testGetId() {
		assertEquals("testId","testConvo",testConvo.getId());
	}

	@Test
	public void testGetUser1() {
		assertEquals("testUser1","user1",testConvo.getUser1());
	}
	@Test
	public void testGetUser2() {
		assertEquals("testUser2","user2",testConvo.getUser2());
	}

	@Test
	public void testGetOtherUser() {
		assertEquals("testGetOtherUser", "user2", testConvo.getOtherUser("user1"));
	}

	@Test
	public void testGetMessages() {
		assertEquals("testGetMessages",messagesArray,testConvo.getMessages());
	}

	@Test
	public void testAddMessage() {
        Message msg3 = new Message("user2", "user1", "Time","add Message Content");
        testConvo.addMessage(msg3);
        assertEquals("testAddMessages",msg3,testConvo.getMessages().get(2));
	}

	@Test
	public void testGetMostRecentMessage() {
        Message msg3 = new Message("user2", "user1", "Time","add Message Content");
        testConvo.addMessage(msg3);
        assertEquals("testGetMostRecentMessages","add Message Content",msg3.getMessage());
	}

}
