package com.capgemini.passbook.service;

import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.HashMap;
import java.util.Scanner;

import javax.swing.text.DateFormatter;

import com.capgemini.passbook.bean.Passbook;
import com.capgemini.passbook.dao.PassbookDao;
import com.capgemini.passbook.dao.PassbookDaoImpl;
import com.capgemini.passbook.exception.PassbookException;

public class PassbookServiceImpl implements PassbookService {

	PassbookDao passbookDao;
	HashMap<String, Passbook> hashMap;
	Passbook passbook = null;
	Scanner sc = new Scanner(System.in);

	private String accountId;
	private LocalDate date;
	private LocalDate startdate;
	private LocalDate enddate;
	private float credit;
	private float debit;
	private float totalamount;

	public PassbookServiceImpl() throws SQLException {
		passbookDao = new PassbookDaoImpl();
	}

	@Override
	public void showAccountSummary() throws PassbookException, SQLException {

		System.out.println("Enter accountId");
		passbook = null;
		passbook = new Passbook();
		accountId = sc.next();
		if (!accountId.matches("[0-9]{10}"))
			throw new PassbookException("Invalid account id");
		else
			passbook.setAccountId(accountId);

		System.out.println("enter start date in format yyyy-MM-dd");
		String s = sc.next();

		startdate = LocalDate.parse(s);
		if(startdate.isBefore(LocalDate.now())==false)
			throw new PassbookException(" start date can not be greater than current date");
		
			

		System.out.println("enter end date in format yyyy-MM-dd");
		s = sc.next();
		enddate = LocalDate.parse(s);
		
		if(enddate.isBefore(LocalDate.now())==false || enddate.isAfter(startdate)==false)
			throw new PassbookException("end date can not be greater than current date and less than start date");
		
		
		
		if(passbookDao.getAccountSummary(accountId,startdate,enddate))
			System.out.println("list of transaction between " + startdate+" and "+enddate);
		else
			System.out.println("something wrong");

	}

	@Override
	public void insertPassbook() throws PassbookException,SQLException {
		System.out.println("Enter accountId");
		passbook = null;
		passbook = new Passbook();
		accountId = sc.next();
		if (!accountId.matches("[0-9]{10}"))
			throw new PassbookException("Invalid account id");
		else
			passbook.setAccountId(accountId);
		
		if(passbookDao.updatePassbook(passbook))
			System.out.println("all transaction printed");
		else
			System.out.println("something wrong");
	}

}
