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
import java.util.ArrayList;
import java.util.Map;

import data.ARConstants;



// TODO: Auto-generated Javadoc
/**
 * The Class PartKit.
 * 
 * @author TCS Purpose : Extends : Implements :
 */
public class FalloutPartKit implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** The part kit id. */
	private String partKitId;

	/** The part price. */
	private String partPrice;

	/** The part cost. */
	private String partCost;

	/** The no of parts. */
	private String noOfParts;

	/** The fail mode. */
	private ArrayList failMode;

	/** The dist type. */
	private ArrayList distType;// = new
	// ArrayList(AppConstants.INITIAL_ARRAYLIST_SIZE);

	/** The params. */
	private Map params;

	/** The param name. */
	private String paramName;

	/** The param value. */
	private String paramValue;

	/** The part kit re. */
	private String partKitRE;

	/** The failure mode. */
	private String failureMode;

	/** The distribution type. */
	private String distributionType;

	/** The distribution type func. */
	private String distributionTypeFunc;

	/** The combine fallout ind */
	private String combineFalloutInd;

	/**
	 * Gets the distribution type.
	 * 
	 * @return Returns the distributionType.
	 */
	public String getDistributionType() {
		return distributionType;
	}

	/**
	 * Sets the distribution type.
	 * 
	 * @param distributionType
	 *            The distributionType to set.
	 */
	public void setDistributionType(String distributionType) {
		this.distributionType = distributionType;
	}

	/**
	 * Gets the failure mode.
	 * 
	 * @return Returns the failureMode.
	 */
	public String getFailureMode() {
		return failureMode;
	}

	/**
	 * Sets the failure mode.
	 * 
	 * @param failureMode
	 *            The failureMode to set.
	 */
	public void setFailureMode(String failureMode) {
		this.failureMode = failureMode;
	}

	/**
	 * Gets the dist type.
	 * 
	 * @return Returns the distType.
	 */
	public ArrayList getDistType() {
		if (null != distType) {
			return distType;
		} else {
			return null;
		}
	}

	/**
	 * Sets the dist type.
	 * 
	 * @param distType
	 *            The distType to set.
	 */
	public void setDistType(ArrayList distType) {
		this.distType = distType;
	}

	/**
	 * Gets the fail mode.
	 * 
	 * @return Returns the failMode.
	 */
	public ArrayList getFailMode() {
		return failMode;
	}

	/**
	 * Sets the fail mode.
	 * 
	 * @param failMode
	 *            The failMode to set.
	 */
	public void setFailMode(ArrayList failMode) {
		this.failMode = failMode;
	}

	/**
	 * Gets the no of parts.
	 * 
	 * @return Returns the noOfParts.
	 */
	public int getNoOfParts() {
		if (null != noOfParts && ! "".equals(noOfParts)) {
			return Integer.parseInt(noOfParts);
		} else {
			return 1;
		}
	}

	/**
	 * Sets the no of parts.
	 * 
	 * @param noOfParts
	 *            The noOfParts to set.
	 */
	public void setNoOfParts(String noOfParts) {
		this.noOfParts = noOfParts;
	}

	/**
	 * Gets the param name.
	 * 
	 * @return Returns the paramName.
	 */
	public String getParamName() {
		return paramName;
	}

	/**
	 * Sets the param name.
	 * 
	 * @param paramName
	 *            The paramName to set.
	 */
	public void setParamName(String paramName) {
		this.paramName = paramName;
	}

	/**
	 * Gets the params.
	 * 
	 * @return Returns the params.
	 */
	public Map getParams() {
		return params;
	}

	/**
	 * Sets the params.
	 * 
	 * @param params
	 *            The params to set.
	 */
	public void setParams(Map params) {
		this.params = params;
	}

	/**
	 * Gets the param value.
	 * 
	 * @return Returns the paramValue.
	 */
	public String getParamValue() {
		return paramValue;
	}

	/**
	 * Sets the param value.
	 * 
	 * @param paramValue
	 *            The paramValue to set.
	 */
	public void setParamValue(String paramValue) {
		this.paramValue = paramValue;
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

	/**
	 * Gets the part kit re.
	 * 
	 * @return Returns the partKitRE.
	 */
	public double getPartKitRE() {
		if (null != partKitRE && ! "".equals(partKitRE)) {
			return 1 - (Double.valueOf(partKitRE).doubleValue() / ARConstants.HUNDRED);
		} else {
			return 1;
		}

	}

	/**
	 * Sets the part kit re.
	 * 
	 * @param partKitRE
	 *            The partKitRE to set.
	 */
	public void setPartKitRE(String partKitRE) {
		this.partKitRE = partKitRE;
	}

	/**
	 * Gets the part cost.
	 * 
	 * @return Returns the partCost.
	 */
	public double getPartCost() {
		if (null != partCost && ! "".equals(partCost)) {
			return Double.valueOf(partCost).doubleValue();
		} else {
			return 0.0;
		}
	}

	/**
	 * Sets the part cost.
	 * 
	 * @param partCost
	 *            The partCost to set.
	 */
	public void setPartCost(String partCost) {
		this.partCost = partCost;
	}

	/**
	 * Gets the part price.
	 * 
	 * @return Returns the partPrice.
	 */
	public double getPartPrice() {
		if (null != partPrice && ! "".equals(partPrice)) {
			return Double.valueOf(partPrice).doubleValue();
		} else {
			return 0.0;
		}
	}

	/**
	 * Sets the part price.
	 * 
	 * @param partPrice
	 *            The partPrice to set.
	 */
	public void setPartPrice(String partPrice) {
		this.partPrice = partPrice;
	}

	/**
	 * Gets the distribution type func.
	 * 
	 * @return Returns the distributionTypeFunc.
	 */
	public String getDistributionTypeFunc() {
		return distributionTypeFunc;
	}

	/**
	 * Sets the distribution type func.
	 * 
	 * @param distributionTypeFunc
	 *            The distributionTypeFunc to set.
	 */
	public void setDistributionTypeFunc(String distributionTypeFunc) {
		this.distributionTypeFunc = distributionTypeFunc;
	}

	/**
	 * Gets the cost per part.
	 * 
	 * @return the cost per part
	 */
	public double getCostPerPart() {
		return getPartCost() / getNoOfParts();
	}

	/**
	 * Gets the price per part.
	 * 
	 * @return the price per part
	 */
	public double getPricePerPart() {
		return getPartPrice() / getNoOfParts();
	}

	/**
	 * Gets the ind for combine fallout.
	 * 
	 * @return the ind for combine fallout
	 */
	public String getCombineFalloutInd() {
		return combineFalloutInd;
	}

	/**
	 * Sets the combine falout ind.
	 * 
	 * @param combineFalloutInd
	 *            The combineFalloutInd to set.
	 */
	public void setCombineFalloutInd(String combineFalloutInd) {
		this.combineFalloutInd = combineFalloutInd;
	}
}
