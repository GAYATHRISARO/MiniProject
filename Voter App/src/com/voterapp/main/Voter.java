package com.voterapp.main;
import java.util.Scanner;

import com.voterapp.exception.NotEligibleException;
import com.voterapp.service.*;
public class Voter {

	public static void main(String[] args) throws NotEligibleException {
		ElectionBooth booth=new ElectionBooth();
		
		System.out.println("Checking...");
		Scanner s = new Scanner(System.in);
		System.out.println("Enter your age");
		int age=s.nextInt();
		System.out.println("Enter your localitiy");
		s.nextLine();
	    String localname=s.nextLine();
	    System.out.println("Enter your vid");
		int vid=s.nextInt();
		System.out.println(localname);
            try {
		       booth.checkEligibility(age,localname,vid);
            }
            catch(NotEligibleException e) {
            	
            	System.out.println(e.getMessage());
            }
            finally {
    			System.out.println("Have a nice Day...");
    		}
		s.close();

	}

}



