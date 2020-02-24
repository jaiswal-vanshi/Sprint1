package com.capgemini.passbook.dao;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.HashMap;

import com.capgemini.passbook.bean.Passbook;

public interface PassbookDao {
	public boolean getAccountSummary(String accountId,LocalDate startdate,LocalDate enddate ) throws SQLException;
	public boolean updatePassbook(Passbook passbook) throws SQLException;
	public Passbook search(String accountId)throws SQLException;

}
