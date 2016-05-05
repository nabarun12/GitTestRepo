/************************************************************************
 *    Copyright (C) 2007 General Electric Company. All rights reserved    *
 *            File Name:DistributionType.java                           *
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



/**
 * The Class DistributionType.
 * 
 * @author TCS Purpose : Extends : Implements :
 */
public class DistributionType  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** The distribution name. */
	private String distributionName;

	/** The failure modes. */
	private ArrayList failureModes;

	/**
	 * Gets the distribution name.
	 * 
	 * @return Returns the distributionName.
	 */
	public String getDistributionName() {
		return distributionName;
	}

	/**
	 * Sets the distribution name.
	 * 
	 * @param distributionName
	 *            The distributionName to set.
	 */
	public void setDistributionName(String distributionName) {
		this.distributionName = distributionName;
	}

	/**
	 * Gets the failure modes.
	 * 
	 * @return Returns the failureModes.
	 */
	public ArrayList getFailureModes() {
		return failureModes;
	}

	/**
	 * Sets the failure modes.
	 * 
	 * @param failureModes
	 *            The failureModes to set.
	 */
	public void setFailureModes(ArrayList failureModes) {
		this.failureModes = failureModes;
	}

	@Override
	public String toString() {
		return "distributionName" + distributionName;
	}

}
