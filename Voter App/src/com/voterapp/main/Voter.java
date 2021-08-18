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
		/*
		 * try { booth.checkAge(age); } catch (UnderAgeException e1) {
		 * e1.printStackTrace(); }
		 */
		/*
		 * try { booth.checkAge(age); } catch (UnderAgeException e2) {
		 * e2.printStackTrace(); }
		 */
		System.out.println("Enter your localitiy");
	    String local=s.next();
	    System.out.println("Enter your vid");
		int vid=s.nextInt();
            try {
		booth.checkEligibility(age,local,vid);
            }
            catch(NotEligibleException e) {
            	System.out.println(e.getMessage());
            }
		s.close();

	}

}



