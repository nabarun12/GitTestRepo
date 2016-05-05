/************************************************************************
 *    Copyright (C) 2007 General Electric Company. All rights reserved    *
 *            File Name:Part.java                           *
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
import java.util.HashMap;
import java.util.Map;

//import com.ge.energy.config.model.UserData;

// TODO: Auto-generated Javadoc
/**
 * The Class Part.
 * 
 * @author TCS Purpose : Extends : Implements :
 */
public class FalloutPart implements Serializable{//extends UserData {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** The age of part hrs. */
	private double ageOfPartHrs;

	/** The age of part starts. */
	private double ageOfPartStarts;

	/** The equip id. */
	private String equipId;

	/** The event id. */
	private String eventId;

	/** The fleet id. */
	private String fleetID;

	/** The fall out part cost. */
	private double fallOutPartCost;

	/** The fall out part price. */
	private double fallOutPartPrice;

	/** The fall out parts. */
	private int fallOutParts;

	/** The fall out perc. */
	private float fallOutPerc;

	/** The ffh. */
	private String ffh;

	/** The ffs. */
	private String ffs;

	/** The hours since install. */
	private String hoursSinceInstall;

	/** The lst fallout details. */
	private ArrayList lstFalloutDetails = new ArrayList();

	/** The lst part repair. */
	private ArrayList lstPartRepair = new ArrayList();

	/** The model ver id. */
	private String modelVerId;

	/** The old part count. */
	private Map oldPartCount = new HashMap();

	/** The part id. */
	private String partId;

	/** The part kit id. */
	private String partKitId;

	/** The repair count. */
	private String repairCount;

	/** The starts since install. */
	private String startsSinceInstall;

	/** The user id. */
	// private String userId;

	/** The Project Schedule. */
	private boolean isProjected;

	/** The Back Calculation. */
	private boolean isBackCalculation;

	/**
	 * Gets the age of part hrs.
	 * 
	 * @return Returns the ageOfPartHrs.
	 */
	public double getAgeOfPartHrs() {
		return ageOfPartHrs;
	}

	/**
	 * Gets the age of part starts.
	 * 
	 * @return Returns the ageOfPartStarts.
	 */
	public double getAgeOfPartStarts() {
		return ageOfPartStarts;
	}

	/**
	 * Gets the equip id.
	 * 
	 * @return Returns the equipId.
	 */
	public String getEquipID() {
		return equipId;
	}

	/**
	 * Gets the event id.
	 * 
	 * @return Returns the eventId.
	 */
	public String getEventID() {
		return eventId;
	}

	/**
	 * Gets the fall out part cost.
	 * 
	 * @return Returns the fallOutPartCost.
	 */
	public double getFallOutPartCost() {
		return fallOutPartCost;
	}

	/**
	 * Gets the fall out part price.
	 * 
	 * @return Returns the fallOutPartPrice.
	 */
	public double getFallOutPartPrice() {
		return fallOutPartPrice;
	}

	/**
	 * Gets the fall out parts.
	 * 
	 * @return Returns the fallOutParts.
	 */
	public int getFallOutParts() {
		return fallOutParts;
	}

	/**
	 * Gets the fall out perc.
	 * 
	 * @return Returns the fallOutPerc.
	 */
	public float getFallOutPerc() {
		return fallOutPerc;
	}

	/**
	 * Gets the ffh.
	 * 
	 * @return Returns the ffh.
	 */
	public double getFFH() {
		if (null != ffh) {
			return Double.valueOf(ffh).doubleValue();
		} else {
			return 0;
		}

	}

	/**
	 * Gets the ffs.
	 * 
	 * @return Returns the ffs.
	 */
	public double getFFS() {
		if (null != ffs) {
			return Double.valueOf(ffs).doubleValue();
		} else {
			return 0;
		}
	}

	/**
	 * Gets the hours since install.
	 * 
	 * @return Returns the hoursSinceInstall.
	 */
	public double getHoursSinceInstall() {
		if (null != hoursSinceInstall) {
			return Double.valueOf(hoursSinceInstall).doubleValue();
		} else {
			return 0;
		}
	}

	/**
	 * Gets the lst fallout details.
	 * 
	 * @return Returns the lstFalloutDetails.
	 */
	public ArrayList getLstFalloutDetails() {
		return lstFalloutDetails;
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
	 * Gets the model ver id.
	 * 
	 * @return Returns the modelVerId.
	 */
	public String getModelVerID() {
		return modelVerId;
	}

	/**
	 * Gets the old part count.
	 * 
	 * @return Returns the oldPartCount.
	 */
	public Map getOldPartCount() {
		return oldPartCount;
	}

	/**
	 * Gets the part id.
	 * 
	 * @return Returns the partId.
	 */
	public String getPartID() {
		return partId;
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
	 * Gets the repair count.
	 * 
	 * @return Returns the repairCount.
	 */
	public int getRepairCount() {
		if (null != repairCount) {
			return Integer.parseInt(repairCount);
		} else {
			return 0;
		}
	}

	/**
	 * Gets the starts since install.
	 * 
	 * @return Returns the startsSinceInstall.
	 */
	public double getStartsSinceInstall() {
		if (null != startsSinceInstall) {
			return Double.valueOf(startsSinceInstall).doubleValue();
		} else {
			return 0;
		}
	}

	/**
	 * Sets the age of part hrs.
	 * 
	 * @param ageOfPartHrs
	 *            The ageOfPartHrs to set.
	 */
	public void setAgeOfPartHrs(double ageOfPartHrs) {
		this.ageOfPartHrs = ageOfPartHrs;
	}

	/**
	 * Sets the age of part starts.
	 * 
	 * @param ageOfPartStarts
	 *            The ageOfPartStarts to set.
	 */
	public void setAgeOfPartStarts(double ageOfPartStarts) {
		this.ageOfPartStarts = ageOfPartStarts;
	}

	/**
	 * Sets the equip id.
	 * 
	 * @param equipId
	 *            The equipId to set.
	 */
	public void setEquipID(String inEquipId) {
		this.equipId = inEquipId;
	}

	/**
	 * Sets the event id.
	 * 
	 * @param idEventId
	 *            The eventId to set.
	 */
	public void setEventID(String idEventId) {
		this.eventId = idEventId;
	}

	/**
	 * Sets the fall out part cost.
	 * 
	 * @param fallOutPartCost
	 *            The fallOutPartCost to set.
	 */
	public void setFallOutPartCost(double fallOutPartCost) {
		this.fallOutPartCost = fallOutPartCost;
	}

	/**
	 * Sets the fall out part cost.
	 * 
	 * @param fallOutPartCost
	 *            The fallOutPartCost to set.
	 */
	public void setFallOutPartCost(float fallOutPartCost) {
		this.fallOutPartCost = fallOutPartCost;
	}

	/**
	 * Sets the fall out part price.
	 * 
	 * @param fallOutPartPrice
	 *            The fallOutPartPrice to set.
	 */
	public void setFallOutPartPrice(double fallOutPartPrice) {
		this.fallOutPartPrice = fallOutPartPrice;
	}

	/**
	 * Sets the fall out part price.
	 * 
	 * @param fallOutPartPrice
	 *            The fallOutPartPrice to set.
	 */
	public void setFallOutPartPrice(float fallOutPartPrice) {
		this.fallOutPartPrice = fallOutPartPrice;
	}

	/**
	 * Sets the fall out parts.
	 * 
	 * @param fallOutParts
	 *            The fallOutParts to set.
	 */
	public void setFallOutParts(int fallOutParts) {
		this.fallOutParts = fallOutParts;
	}

	/**
	 * Sets the fall out perc.
	 * 
	 * @param fallOutPerc
	 *            The fallOutPerc to set.
	 */
	public void setFallOutPerc(float fallOutPerc) {
		this.fallOutPerc = fallOutPerc;
	}

	/**
	 * Sets the ffh.
	 * 
	 * @param ffh
	 *            The ffh to set.
	 */
	public void setFFH(String inFfh) {
		this.ffh = inFfh;
	}

	/**
	 * Sets the ffs.
	 * 
	 * @param inFfs
	 *            The ffs to set.
	 */
	public void setFFS(String inFfs) {
		this.ffs = inFfs;
	}

	/**
	 * Sets the hours since install.
	 * 
	 * @param hoursSinceInstall
	 *            The hoursSinceInstall to set.
	 */
	public void setHoursSinceInstall(String hoursSinceInstall) {
		this.hoursSinceInstall = hoursSinceInstall;
	}

	/**
	 * Sets the lst fallout details.
	 * 
	 * @param lstFalloutDetails
	 *            The lstFalloutDetails to set.
	 */
	public void setLstFalloutDetails(ArrayList lstFalloutDetails) {
		this.lstFalloutDetails = lstFalloutDetails;
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
	 * Sets the model ver id.
	 * 
	 * @param modelVerId
	 *            The modelVerId to set.
	 */
	public void setModelVerID(String aModelVerId) {
		this.modelVerId = aModelVerId;
	}

	/**
	 * Sets the old part count.
	 * 
	 * @param oldPartCount
	 *            The oldPartCount to set.
	 */
	public void setOldPartCount(Map oldPartCount) {
		this.oldPartCount = oldPartCount;
	}

	/**
	 * Sets the part id.
	 * 
	 * @param inPartId
	 *            The partId to set.
	 */
	public void setPartID(String inPartId) {
		this.partId = inPartId;
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
	 * Sets the starts since install.
	 * 
	 * @param startsSinceInstall
	 *            The startsSinceInstall to set.
	 */
	public void setStartsSinceInstall(String startsSinceInstall) {
		this.startsSinceInstall = startsSinceInstall;
	}

	public boolean isProjected() {
		return isProjected;
	}

	public void setProjected(boolean iProjected) {
		this.isProjected = iProjected;
	}

	public boolean isBackCalculation() {
		return isBackCalculation;
	}

	public void setBackCalculation(boolean iBackCalculation) {
		this.isBackCalculation = iBackCalculation;
	}

	@Override
	public String toString() {
		return "Part [partId=" + partId + ", partKitId=" + partKitId + ", repairCount=" + repairCount + ", isProjected=" + isProjected + ", isBackCalculation=" + isBackCalculation + ", ffh=" + ffh
				+ ", ffs=" + ffs + ", hoursSinceInstall=" + hoursSinceInstall + ", startsSinceInstall=" + startsSinceInstall + "]";
	}

	public String getFleetID() {
		return fleetID;
	}

	public void setFleetID(String fleetID) {
		this.fleetID = fleetID;
	}

}
