package com.capgemini.passbook.test;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.capgemini.passbook.bean.Passbook;
import com.capgemini.passbook.dao.PassbookDao;
import com.capgemini.passbook.dao.PassbookDaoImpl;

public class PassbookDaoImplTest {

	PassbookDao dao;

	@Before
	public void setUp() throws Exception {
		dao = new PassbookDaoImpl();

	}

	@After
	public void tearDown() throws Exception {
		dao = null;
	}

	/*
	 * @Test public void testPassbookDaoImpl() { fail("Not yet implemented"); }
	 * 
	 */
	@Test
	public void testUpdatePassbook() throws SQLException {
		Passbook passbook = new Passbook();
		passbook.setAccountId("1234567890");
		assertTrue(dao.updatePassbook(passbook));
		assertFalse(dao.updatePassbook(passbook));
		
	}

	
	  /*@Test public void testGetAccountSummary() {
		 
	  }*/
	 

}
