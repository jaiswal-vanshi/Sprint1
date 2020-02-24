package com.capgemini.passbook.service;

import java.sql.SQLException;

import com.capgemini.passbook.exception.PassbookException;

public interface PassbookService {
	
	public void showAccountSummary() throws PassbookException, SQLException, SQLException;
	public void insertPassbook() throws PassbookException,SQLException;
	

}
