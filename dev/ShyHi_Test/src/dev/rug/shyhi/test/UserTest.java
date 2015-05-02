package dev.rug.shyhi.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import dev.rug.shyhi.User;
import android.test.AndroidTestCase;

public class UserTest extends AndroidTestCase{
	User user;
	@Before
	public void setUp() throws Exception {
		user = new User("user1","rev","lat","long");
	}
	
	@Test
	public void testGetID() {
		assertEquals("testGetId","user1",user.getID());
	}

	@Test
	public void testGetRev() {
		assertEquals("testGetRev","rev",user.getRev());
	}

	@Test
	public void testGetLat() {
		assertEquals("testGetLat","lat",user.getLat());
	}

	@Test
	public void testGetLong() {
		assertEquals("testGetLong","long",user.getLong());
	}

	@Test
	public void testSetLat() {
		user.setLat("test");
		assertEquals("testSetLat","test",user.getLat());
	}

	@Test
	public void testSetLong() {
		user.setLong("test");
		assertEquals("testSetLong","test",user.getLong());
	}

	@Test
	public void testSetID() {
		user.setID("test");
		assertEquals("testGetId","test",user.getID());
	}

	@Test
	public void testGetUserForPost() {
		String t = "{"+"\"_id\":"+user.getID()+","+
				"\"type\":"+"\"user\","+
				"\"latitude\":"+user.getLat()+","+
				"\"longitude\":"+user.getLong()+"}";
		assertEquals("testGetUserForPost",t,user.getUserForPost());
		
	}

}
