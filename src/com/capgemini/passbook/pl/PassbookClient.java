package com.capgemini.passbook.pl;

import java.sql.SQLException;
import java.util.Scanner;

import com.capgemini.passbook.exception.PassbookException;
import com.capgemini.passbook.service.PassbookService;
import com.capgemini.passbook.service.PassbookServiceImpl;

public class PassbookClient {
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String ch="yes";
		
		PassbookService service=null;
		
		try {
			service = new PassbookServiceImpl();
		} catch (SQLException e1) {
			System.err.println(e1.getMessage());
		}

		while (ch.equalsIgnoreCase("yes")) {
			System.out.println("Select Operation");
			System.out.println("1.Show passbook summary");
			System.out.println("2.Get passbook");

			int op = sc.nextInt();

			switch (op) {
			case 1:
				try {
					service.showAccountSummary();
				} catch (SQLException|PassbookException e1) {
					System.err.println(e1.getMessage());
				}
				break;
			
			case 2:
				try{
					service.insertPassbook();
				}
				catch (SQLException|PassbookException e1) {
					System.err.println(e1.getMessage());
				}
				break;
				
				
			default:
				break;
			}
			System.out.println("Continue yes\\not");
			ch = sc.next();
		}
            System.out.println("Thankyou");
	
	}

}
