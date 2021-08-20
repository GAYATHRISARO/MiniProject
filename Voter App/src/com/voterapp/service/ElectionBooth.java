package com.voterapp.service;

import java.util.Scanner;

import com.voterapp.exception.*;

public class ElectionBooth {

	String[] localities = { "ABC Nagar", "KK Nagar", "Anna Nagar" };

	public boolean checkAge(int age) throws UnderAgeException {
		if (age <= 18) {
			throw new UnderAgeException("Age is less then 18...");
		}
		return true;
	}

	public boolean checkLocality(String locality) throws LocalityFileNotException {
		boolean isPresent = false;
		for (String loc : localities) {
			if (loc.equals(locality)) {
				isPresent = true;
			}
		}
		if (isPresent == true) {
			return true;
		} else {
			throw new LocalityFileNotException("Locality is not available");

		}
	}

	public boolean checkVoterID(int vid) throws NoVoterIDException {
		if (vid < 1000 || vid > 9000) {
			throw new NoVoterIDException("Voter id is not available");
		}
		return true;
	}

	public boolean checkEligibility(int age, String locality, int vid) throws NotEligibleException {

		try {
			checkAge(age);
		} catch (UnderAgeException e) {

			throw e;
		}
		try {
			checkLocality(locality);
		} catch (LocalityFileNotException e1) {

			throw e1;
		}
		try {
			checkVoterID(vid);
		} catch (NoVoterIDException e2) {

			throw e2;
		}

		return true;
	}

}
