package com.capgemini.passbook.bean;

import java.sql.Date;
import java.time.LocalDate;

public class Passbook {
	private String accountId;
	private Date date;
	private float credit;
	private float debit;
	private float totalamount;
	private Date startdate;
	private Date enddate;


	
	public Passbook(String accountId, Date date, float credit, float debit, float totalamount, Date startdate,
			Date enddate) {
		super();
		this.accountId = accountId;
		this.date = date;
		this.credit = credit;
		this.debit = debit;
		this.totalamount = totalamount;
		this.startdate = startdate;
		this.enddate = enddate;
	}








	public Passbook(){
	
	}

	public String getAccountId() {
		return accountId;
	}


	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}


	public Date getDate() {
		return date;
	}



	public void setDate(Date date) {
		this.date = date;
	}



	public float getCredit() {
		return credit;
	}


	public void setCredit(float credit) {
		this.credit = credit;
	}


	public float getDebit() {
		return debit;
	}


	public void setDebit(float debit) {
		this.debit = debit;
	}



	public float getTotalamount() {
		return totalamount;
	}


	public void setTotalamount(float totalamount) {
		this.totalamount = totalamount;
	}
	
	


	public Date getStartdate() {
		return startdate;
	}








	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}








	public Date getEnddate() {
		return enddate;
	}


	public void setEnddate(Date enddate) {
		this.enddate = enddate;
	}








	@Override
	public String toString() {
		return "Passbook [accountId=" + accountId + ", date=" + date + ", credit=" + credit + ", debit=" + debit
				+ ", totalamount=" + totalamount + ", startdate=" + startdate + ", enddate=" + enddate + "]";
	}






	

}
