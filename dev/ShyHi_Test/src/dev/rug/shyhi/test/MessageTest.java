package dev.rug.shyhi.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import dev.rug.shyhi.Message;
import android.test.AndroidTestCase;

public class MessageTest extends AndroidTestCase{
	Message msg;
	@Before
	public void setUp() throws Exception {
		msg = new Message("user1","user2","time","message");
	}

	@Test
	public void testGetToID() {
		assertEquals("testToID","user1",msg.getToID());
	}

	@Test
	public void testGetFromID() {
		assertEquals("testFromID","user2",msg.getFromID());
	}

	@Test
	public void testGetTimestamp() {
		assertEquals("testTime","time",msg.getTimestamp());
	}

	@Test
	public void testGetMessage() {
		assertEquals("testToID","message",msg.getMessage());
	}

	@Test
	public void testSetToID() {
		msg.setToID("test");
		assertEquals("testSetToID","test",msg.getToID());
	}

	@Test
	public void testSetFromID() {
		msg.setFromID("test");
		assertEquals("testSetFromID","test",msg.getFromID());
	}

	@Test
	public void testSetMessage() {
		msg.setMessage("test");
		assertEquals("testSetMessage","test",msg.getMessage());
	}

}
