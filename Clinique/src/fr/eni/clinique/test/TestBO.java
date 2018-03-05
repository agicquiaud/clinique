package fr.eni.clinique.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import fr.eni.clinique.bo.User;

public class TestBO {

	protected User p;
	
	@Before
	public void set(){
		p = new User();
	}
	
	@After
	public void tearDown(){
		
	}
	
	@Test
	public void testCreerUsers() {
		fail("Not yet implemented");
	}

}
