package com.voterapp.service;

import java.util.Scanner;

import com.voterapp.exception.*;
 public class ElectionBooth {

	 String[] localities= {"ABC Nagar","KK Nagar","Anna Nagar"};
	public boolean checkAge(int age)throws UnderAgeException{
		if(age<18) {
			throw new UnderAgeException("Age is less then 18...");
		}
		return true;
	}
	public boolean checkLocality(String locality)throws LocalityFileNotException{
		for(String loc:localities) {
			if(!loc.equals(locality)) {
				throw new LocalityFileNotException("Locality is not available");
				
			}
		}
		return true;
	}
	public boolean checkVoterID(int vid)throws NoVoterIDException{
		if(vid<1000 || vid>9000) {
			throw new NoVoterIDException("Voter id is not available");
		}
		return true;
	}
	public boolean checkEligibility(int age,String locality,int vid ) throws NotEligibleException{
		boolean result;
		//ElectionBooth booth=new ElectionBooth();
		try(Scanner s=new Scanner(System.in);){
			result = checkAge(age);
			System.out.println("Enter the locality");
			try {
				//System.out.println("Enter the locality");
				result=checkLocality(locality);
			}catch (LocalityFileNotException e) {
				System.out.println(e.getMessage());
				throw e;
			}
			try {
				result=checkVoterID(vid);
			}
			catch (NoVoterIDException e1) {
				System.out.println(e1.getMessage());
				throw e1;
			}
		  }catch(UnderAgeException e3) {
			  System.out.println(e3.getMessage());
              throw e3;
		  }
		finally {
			System.out.println("Welcome voter");
		}
	return true;
  }
		
 }


