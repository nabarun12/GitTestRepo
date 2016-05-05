/************************************************************************
 *    Copyright (C) 2007 General Electric Company. All rights reserved    *
 *            File Name:PartKit.java                           *
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



// TODO: Auto-generated Javadoc
/**
 * The Class PartKit.
 * 
 * @author TCS Purpose : Extends : Implements :
 */
public class StepPartKit  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** The part kit id. */
	private String partKitId;

	/** The fail mode id. */
	private String failModeName;

	/** The repair count. */
	private String repairCount;

	/** The fallout percenter. */
	private String falloutPct;

	/** The factore value. */
	private String factoredValue;

	/**
	 * Gets the factore value.
	 * 
	 * @return Returns the factoreValue.
	 */
	public String getFactoredValue() {
		return factoredValue;
	}

	/**
	 * Sets the factore value.
	 * 
	 * @param factoreValue
	 *            The factoreValue to set.
	 */
	public void setFactoredValue(String factoredValue) {
		this.factoredValue = factoredValue;
	}

	/**
	 * Gets the fail mode name.
	 * 
	 * @return Returns the failModeName.
	 */
	public String getFailModeName() {
		return failModeName;
	}

	/**
	 * Sets the fail mode name.
	 * 
	 * @param failModeName
	 *            The failModeName to set.
	 */
	public void setFailModeName(String failModeName) {
		this.failModeName = failModeName;
	}

	/**
	 * Gets the fallout percenter.
	 * 
	 * @return Returns the falloutPct.
	 */
	public String getFalloutPct() {
		return falloutPct;
	}

	/**
	 * Sets the fallout percenter.
	 * 
	 * @param falloutPct
	 *            The falloutPct to set.
	 */
	public void setFalloutPct(String falloutPct) {
		this.falloutPct = falloutPct;
	}

	/**
	 * Gets the repair count.
	 * 
	 * @return Returns the repairCount.
	 */
	public String getRepairCount() {
		return repairCount;
	}

	/**
	 * Sets the repair count.
	 * 
	 * @param repairCount
	 *            The repairCount to set.
	 */
	public void setRepairCount(String repairCount) {
		this.repairCount = repairCount;
	}

	/**
	 * Gets the part kit id.
	 * 
	 * @return Returns the partKitId.
	 */
	public String getPartKitId() {
		return partKitId;
	}

	/**
	 * Sets the part kit id.
	 * 
	 * @param partKitId
	 *            The partKitId to set.
	 */
	public void setPartKitId(String partKitId) {
		this.partKitId = partKitId;
	}

	@Override
	public String toString() {
		return "partKitId: " + partKitId + " failModeName: " + failModeName + " falloutPct: " + falloutPct;
	}

}
