package com.capgemini.passbook.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Scanner;

import com.capgemini.passbook.bean.Passbook;
import com.capgemini.passbook.util.DatabaseUtil;

public class PassbookDaoImpl implements PassbookDao{
	
	Connection connection;
	Statement st;
	ResultSet rs;
	PreparedStatement pst;
	Passbook passbook;
	String ch;
	String accountId;
	Scanner sc=new Scanner(System.in);
	
	HashMap<String,Passbook> hashMap;
	/*This transaction will be committed when connection. commit() is invoked, as opposed to after
	 *  each execute() call on individual Statement */
	public PassbookDaoImpl() throws SQLException{
		connection = DatabaseUtil.myconnection();
		connection.setAutoCommit(false);
	}
	
	
	@Override
	public boolean updatePassbook(Passbook passbook1) throws SQLException {
		passbook = search(passbook1.getAccountId());
		if(passbook!=null){
			pst = null;
			pst=connection.prepareStatement("select * from transaction where accountId=?");
			pst.setString(1,passbook1.getAccountId());
			ResultSet res = pst.executeQuery();
			while (res.next()) {
			
				System.out.println(res.getString(1)+"   "+res.getDate(2)+"   "+res.getFloat(3)+"  "
						+ " "+res.getFloat(4)+"   "+res.getFloat(5));
			
			}
			return true;
			
		}
		
		return false;
	}


	@Override
	public boolean getAccountSummary(String accountId, LocalDate startDate, LocalDate endDate) throws SQLException {
		passbook = search(accountId);
		if (passbook != null) {
			pst = null;
			pst = connection.prepareStatement("select * from transaction where accountId=? and sdate between ? and ?");
			pst.setString(1,accountId);
			pst.setDate(2,Date.valueOf(startDate));
			pst.setDate(3, Date.valueOf(endDate));
			ResultSet res = pst.executeQuery();
			while (res.next()) {
			
				System.out.println(res.getString(1)+"   "+res.getDate(2)+"   "+res.getFloat(3)+"   "+res.getFloat(4)+"   "+res.getFloat(5));
			
			}
			return true;
		}
		return false;
	}


	@Override
	public Passbook search(String accountId) throws SQLException {
		pst = connection.prepareStatement("select * from transaction where accountId=?");
		pst.setString(1, accountId);
		rs = null;
		rs = pst.executeQuery();

		if (rs.next()) {
			passbook = null;
			passbook = new Passbook();

			passbook.setAccountId(rs.getString(1));
			passbook.setDate(rs.getDate(2));
			passbook.setDebit(rs.getFloat(3));
			passbook.setCredit(rs.getFloat(4));
			passbook.setTotalamount(rs.getFloat(5));
		 
		}  
		return passbook;
	}
	

}
