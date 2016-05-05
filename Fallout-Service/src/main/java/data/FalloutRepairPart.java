/************************************************************************
 *    Copyright (C) 2007 General Electric Company. All rights reserved    *
 *            File Name:FalloutRepairPart.java                           *
 *            Author Name:Tata Consultancy Services, Limited.            *
 *  Confidential and proprietary information of General Electric Company *
 ************************************************************************/
///CLOVER:OFF
/**
 * @author TCS
 * Purpose: 
 * Created : Apr 12, 2006
 */
package data;

import java.io.Serializable;
import java.util.ArrayList;



// TODO: Auto-generated Javadoc
/**
 * The Class FalloutRepairPart.
 * 
 * @author TCS Purpose : Extends : Implements :
 */
public class FalloutRepairPart implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** The lst part repair. */
	private ArrayList lstPartRepair = new ArrayList();

	/** The age of remaining part hrs. */
	private double ageOfRemainingPartHrs;

	/** The age of remaining part starts. */
	private double ageOfRemainingPartStarts;

	/** The rem parts since repair. */
	private double remPartsSinceRepair;

	// private int newPartCount = 0;
	/**
	 * Gets the age of remaining part hrs.
	 * 
	 * @return Returns the ageOfRemainingPartHrs.
	 */
	public double getAgeOfRemainingPartHrs() {
		return ageOfRemainingPartHrs;
	}

	/**
	 * Sets the age of remaining part hrs.
	 * 
	 * @param ageOfRemainingPartHrs
	 *            The ageOfRemainingPartHrs to set.
	 */
	public void setAgeOfRemainingPartHrs(double ageOfRemainingPartHrs) {
		this.ageOfRemainingPartHrs = ageOfRemainingPartHrs;
	}

	/**
	 * Gets the age of remaining part starts.
	 * 
	 * @return Returns the ageOfRemainingPartStarts.
	 */
	public double getAgeOfRemainingPartStarts() {
		return ageOfRemainingPartStarts;
	}

	/**
	 * Sets the age of remaining part starts.
	 * 
	 * @param ageOfRemainingPartStarts
	 *            The ageOfRemainingPartStarts to set.
	 */
	public void setAgeOfRemainingPartStarts(double ageOfRemainingPartStarts) {
		this.ageOfRemainingPartStarts = ageOfRemainingPartStarts;
	}

	/**
	 * Gets the lst part repair.
	 * 
	 * @return Returns the lstPartRepair.
	 */
	public ArrayList getLstPartRepair() {
		return lstPartRepair;
	}

	/**
	 * Sets the lst part repair.
	 * 
	 * @param lstPartRepair
	 *            The lstPartRepair to set.
	 */
	public void setLstPartRepair(ArrayList lstPartRepair) {
		this.lstPartRepair = lstPartRepair;
	}

	/**
	 * Gets the rem parts since repair.
	 * 
	 * @return Returns the newPartCount.
	 */
	/*
	 * public int getNewPartCount() { return newPartCount; } /** @param
	 * newPartCount The newPartCount to set.
	 */
	/*
	 * public void setNewPartCount(int newPartCount) { this.newPartCount =
	 * newPartCount; }
	 */
	/**
	 * @return Returns the remPartsSinceRepair.
	 */
	public double getRemPartsSinceRepair() {
		return remPartsSinceRepair;
	}

	/**
	 * Sets the rem parts since repair.
	 * 
	 * @param remPartsSinceRepair
	 *            The remPartsSinceRepair to set.
	 */
	public void setRemPartsSinceRepair(double remPartsSinceRepair) {
		this.remPartsSinceRepair = remPartsSinceRepair;
	}

	@Override
	public String toString() {
		return "lstPartRepair size: " + lstPartRepair.size() + " ageOfRemainingPartHrs: " + ageOfRemainingPartHrs + " ageOfRemainingPartStarts: " + ageOfRemainingPartStarts + " remPartsSinceRepair: "
				+ remPartsSinceRepair;
	}

}
