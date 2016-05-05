/************************************************************************
 *    Copyright (C) 2007 General Electric Company. All rights reserved    *
 *            File Name:PartsLimitVO.java                     *
 *            Author Name:Tata Consultancy Services, Limited.            *
 *  Confidential and proprietary information of General Electric Company *
 ************************************************************************/
///CLOVER:OFF
package data;

import java.io.Serializable;

/**
 * @author 585324
 * 
 */
public class PartLimitsVO implements Serializable {
	/**
	 * Serial Version UID
	 */
	private static final long serialVersionUID = 2204997041076994679L;
	/**
	 * Equipment Id
	 */
	private String equipId;
	/**
	 * Part Kit Id
	 */
	private String partKitId;
	/**
	 * The Apply Customization to Supersecedure flag
	 */
	private String applyCustomToSup;
	/**
	 * Start Date
	 */
	private String startDate;
	/**
	 * End Date
	 */
	private String endDate;
	/**
	 * Repair Limit FFH
	 */
	private String repairLimitFFH;
	/**
	 * Repair Limit FFS
	 */
	private String repairLimitFFS;
	/**
	 * Replace Limit FFH
	 */
	private String replaceLimitFFH;
	/**
	 * Replace Limit FFS
	 */
	private String replaceLimitFFS;
	/**
	 * Model Version Id
	 */
	private String modelVerId;

	/**
	 * Model Version Id
	 */
	private String fleetID;
	/**
	 * Section Id
	 */
	private String sectionId;
	/**
	 * COMB Repair Limit FFH
	 */
	private String combrepairLimitFFH;
	/**
	 * COMB Repair Limit FFS
	 */
	private String combrepairLimitFFS;
	/**
	 * COMB Repair Limit FFH
	 */
	private String combinspectLimitFFH;
	/**
	 * COMB Repair Limit FFS
	 */
	private String combinspectLimitFFS;
	/**
	 * COMB Replace Limit FFH
	 */
	private String combreplaceLimitFFH;
	/**
	 * COMB Replace Limit FFS
	 */
	private String combreplaceLimitFFS;
	/**
	 * Inspection Limit FFH VAL
	 */
	private String inspectLimitFFHVal;
	/**
	 * Inspection Limit FFS VAL
	 */
	private String inspectLimitFFSVal;
	/**
	 * Repair Level
	 */
	private String repairLevel;
	/**
	 * Repair Lead Time
	 */
	private String repairLeadTime;
	/**
	 * Customer Flag
	 */
	private String customflag;
	/**
	 * Apply Customer To SUP Float
	 */
	private String applyCustomToSupFloat;
	/**
	 * Repair Inspect HRS Limit
	 */
	private String repairInspHrsLimit;
	/**
	 * Repair Inspect Start Limit
	 */
	private String repairInspStrtLimit;
	/**
	 * Repair Mandatory HRS Limit
	 */
	private String repairMandHrsLimit;
	/**
	 * Repair Mandatory Start Limit
	 */
	private String repairMandStrtLimit;
	/**
	 * Repair Count
	 */
	private String repairCountVal;
	/**
	 * COMB Lower Repair Limit FFH
	 */
	private String combLowerRepairLimitFFH;
	/**
	 * COMB Lower Repair Limit FFS
	 */
	private String combLowerRepairLimitFFS;
	/**
	 * COMB Lower Replace Limit FFH
	 */
	private String combLowerReplaceLimitFFH;
	/**
	 * COMB Lower Replace Limit FFS
	 */
	private String combLowerReplaceLimitFFS;
	/**
	 * Fall Out Threshould
	 */
	private String falloutThreshold;
	/**
	 * Repair Cost
	 */
	private String repairCost;
	/**
	 * Repair Price
	 */
	private String repairPrice;
	/**
	 * Replace Cost
	 */
	private String replaceCost;
	/**
	 * Replace Price
	 */
	private String replacePrice;
	/**
	 * Repair Cost ADJ
	 */
	private String repairCostAdj;
	/**
	 * Repair Price ADJ
	 */
	private String repairPriceAdj;
	/**
	 * Float Flag
	 */
	private String floatFlag;

	/** default constructor */
	public PartLimitsVO() {
	}

	/**
	 * equipId Getters
	 * 
	 * @return Returns the equipId
	 */
	public String getEquipId() {
		return equipId;
	}

	/**
	 * equipId Setters
	 * 
	 * @param equipId
	 *            the equipId to set
	 */
	public void setEquipId(String equipId) {
		this.equipId = equipId;
	}

	/**
	 * partKitId Getters
	 * 
	 * @return Returns the partKitId
	 */
	public String getPartKitId() {
		return partKitId;
	}

	/**
	 * partKitId Setters
	 * 
	 * @param partKitId
	 *            the partKitId to set
	 */
	public void setPartKitId(String partKitId) {
		this.partKitId = partKitId;
	}

	/**
	 * applyCustomToSup Getters
	 * 
	 * @return Returns the applyCustomToSup
	 */
	public String getApplyCustomToSup() {
		return applyCustomToSup;
	}

	/**
	 * applyCustomToSup Setters
	 * 
	 * @param applyCustomToSup
	 *            the applyCustomToSup to set
	 */
	public void setApplyCustomToSup(String applyCustomToSup) {
		this.applyCustomToSup = applyCustomToSup;
	}

	/**
	 * startDate Getters
	 * 
	 * @return Returns the startDate
	 */
	public String getStartDate() {
		return startDate;
	}

	/**
	 * startDate Setters
	 * 
	 * @param startDate
	 *            the startDate to set
	 */
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	/**
	 * endDate Getters
	 * 
	 * @return Returns the endDate
	 */
	public String getEndDate() {
		return endDate;
	}

	/**
	 * endDate Setters
	 * 
	 * @param endDate
	 *            the endDate to set
	 */
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	/**
	 * repairLimitFFH Getters
	 * 
	 * @return Returns the repairLimitFFH
	 */
	public String getRepairLimitFFH() {
		return repairLimitFFH;
	}

	/**
	 * repairLimitFFH Setters
	 * 
	 * @param repairLimitFFH
	 *            the repairLimitFFH to set
	 */
	public void setRepairLimitFFH(String repairLimitFFH) {
		this.repairLimitFFH = repairLimitFFH;
	}

	/**
	 * repairLimitFFS Getters
	 * 
	 * @return Returns the repairLimitFFS
	 */
	public String getRepairLimitFFS() {
		return repairLimitFFS;
	}

	/**
	 * repairLimitFFS Setters
	 * 
	 * @param repairLimitFFS
	 *            the repairLimitFFS to set
	 */
	public void setRepairLimitFFS(String repairLimitFFS) {
		this.repairLimitFFS = repairLimitFFS;
	}

	/**
	 * replaceLimitFFH Getters
	 * 
	 * @return Returns the replaceLimitFFH
	 */
	public String getReplaceLimitFFH() {
		return replaceLimitFFH;
	}

	/**
	 * replaceLimitFFH Setters
	 * 
	 * @param replaceLimitFFH
	 *            the replaceLimitFFH to set
	 */
	public void setReplaceLimitFFH(String replaceLimitFFH) {
		this.replaceLimitFFH = replaceLimitFFH;
	}

	/**
	 * replaceLimitFFS Getters
	 * 
	 * @return Returns the replaceLimitFFS
	 */
	public String getReplaceLimitFFS() {
		return replaceLimitFFS;
	}

	/**
	 * replaceLimitFFS Setters
	 * 
	 * @param replaceLimitFFS
	 *            the replaceLimitFFS to set
	 */
	public void setReplaceLimitFFS(String replaceLimitFFS) {
		this.replaceLimitFFS = replaceLimitFFS;
	}

	/**
	 * modelVerId Getters
	 * 
	 * @return Returns the modelVerId
	 */
	public String getModelVerId() {
		return modelVerId;
	}

	/**
	 * modelVerId Setters
	 * 
	 * @param modelVerId
	 *            the modelVerId to set
	 */
	public void setModelVerId(String modelVerId) {
		this.modelVerId = modelVerId;
	}

	/**
	 * sectionId Getters
	 * 
	 * @return Returns the sectionId
	 */
	public String getSectionId() {
		return sectionId;
	}

	/**
	 * sectionId Setters
	 * 
	 * @param sectionId
	 *            the sectionId to set
	 */
	public void setSectionId(String sectionId) {
		this.sectionId = sectionId;
	}

	/**
	 * combrepairLimitFFH Getters
	 * 
	 * @return Returns the combrepairLimitFFH
	 */
	public String getCombrepairLimitFFH() {
		return combrepairLimitFFH;
	}

	/**
	 * combrepairLimitFFH Setters
	 * 
	 * @param combrepairLimitFFH
	 *            the combrepairLimitFFH to set
	 */
	public void setCombrepairLimitFFH(String combrepairLimitFFH) {
		this.combrepairLimitFFH = combrepairLimitFFH;
	}

	/**
	 * combrepairLimitFFS Getters
	 * 
	 * @return Returns the combrepairLimitFFS
	 */
	public String getCombrepairLimitFFS() {
		return combrepairLimitFFS;
	}

	/**
	 * combrepairLimitFFS Setters
	 * 
	 * @param combrepairLimitFFS
	 *            the combrepairLimitFFS to set
	 */
	public void setCombrepairLimitFFS(String combrepairLimitFFS) {
		this.combrepairLimitFFS = combrepairLimitFFS;
	}

	/**
	 * combinspectLimitFFH Getters
	 * 
	 * @return Returns the combinspectLimitFFH
	 */
	public String getCombinspectLimitFFH() {
		return combinspectLimitFFH;
	}

	/**
	 * combinspectLimitFFH Setters
	 * 
	 * @param combinspectLimitFFH
	 *            the combinspectLimitFFH to set
	 */
	public void setCombinspectLimitFFH(String combinspectLimitFFH) {
		this.combinspectLimitFFH = combinspectLimitFFH;
	}

	/**
	 * combinspectLimitFFS Getters
	 * 
	 * @return Returns the combinspectLimitFFS
	 */
	public String getCombinspectLimitFFS() {
		return combinspectLimitFFS;
	}

	/**
	 * combinspectLimitFFS Setters
	 * 
	 * @param combinspectLimitFFS
	 *            the combinspectLimitFFS to set
	 */
	public void setCombinspectLimitFFS(String combinspectLimitFFS) {
		this.combinspectLimitFFS = combinspectLimitFFS;
	}

	/**
	 * combreplaceLimitFFH Getters
	 * 
	 * @return Returns the combreplaceLimitFFH
	 */
	public String getCombreplaceLimitFFH() {
		return combreplaceLimitFFH;
	}

	/**
	 * combreplaceLimitFFH Setters
	 * 
	 * @param combreplaceLimitFFH
	 *            the combreplaceLimitFFH to set
	 */
	public void setCombreplaceLimitFFH(String combreplaceLimitFFH) {
		this.combreplaceLimitFFH = combreplaceLimitFFH;
	}

	/**
	 * combreplaceLimitFFS Getters
	 * 
	 * @return Returns the combreplaceLimitFFS
	 */
	public String getCombreplaceLimitFFS() {
		return combreplaceLimitFFS;
	}

	/**
	 * combreplaceLimitFFS Setters
	 * 
	 * @param combreplaceLimitFFS
	 *            the combreplaceLimitFFS to set
	 */
	public void setCombreplaceLimitFFS(String combreplaceLimitFFS) {
		this.combreplaceLimitFFS = combreplaceLimitFFS;
	}

	/**
	 * inspectLimitFFHVal Getters
	 * 
	 * @return Returns the inspectLimitFFHVal
	 */
	public String getInspectLimitFFHVal() {
		return inspectLimitFFHVal;
	}

	/**
	 * inspectLimitFFHVal Setters
	 * 
	 * @param inspectLimitFFHVal
	 *            the inspectLimitFFHVal to set
	 */
	public void setInspectLimitFFHVal(String inspectLimitFFHVal) {
		this.inspectLimitFFHVal = inspectLimitFFHVal;
	}

	/**
	 * inspectLimitFFSVal Getters
	 * 
	 * @return Returns the inspectLimitFFSVal
	 */
	public String getInspectLimitFFSVal() {
		return inspectLimitFFSVal;
	}

	/**
	 * inspectLimitFFSVal Setters
	 * 
	 * @param inspectLimitFFSVal
	 *            the inspectLimitFFSVal to set
	 */
	public void setInspectLimitFFSVal(String inspectLimitFFSVal) {
		this.inspectLimitFFSVal = inspectLimitFFSVal;
	}

	/**
	 * repairLevel Getters
	 * 
	 * @return Returns the repairLevel
	 */
	public String getRepairLevel() {
		return repairLevel;
	}

	/**
	 * repairLevel Setters
	 * 
	 * @param repairLevel
	 *            the repairLevel to set
	 */
	public void setRepairLevel(String repairLevel) {
		this.repairLevel = repairLevel;
	}

	/**
	 * repairLeadTime Getters
	 * 
	 * @return Returns the repairLeadTime
	 */
	public String getRepairLeadTime() {
		return repairLeadTime;
	}

	/**
	 * repairLeadTime Setters
	 * 
	 * @param repairLeadTime
	 *            the repairLeadTime to set
	 */
	public void setRepairLeadTime(String repairLeadTime) {
		this.repairLeadTime = repairLeadTime;
	}

	/**
	 * customflag Getters
	 * 
	 * @return Returns the customflag
	 */
	public String getCustomflag() {
		return customflag;
	}

	/**
	 * customflag Setters
	 * 
	 * @param customflag
	 *            the customflag to set
	 */
	public void setCustomflag(String customflag) {
		this.customflag = customflag;
	}

	/**
	 * applyCustomToSupFloat Getters
	 * 
	 * @return Returns the applyCustomToSupFloat
	 */
	public String getApplyCustomToSupFloat() {
		return applyCustomToSupFloat;
	}

	/**
	 * applyCustomToSupFloat Setters
	 * 
	 * @param applyCustomToSupFloat
	 *            the applyCustomToSupFloat to set
	 */
	public void setApplyCustomToSupFloat(String applyCustomToSupFloat) {
		this.applyCustomToSupFloat = applyCustomToSupFloat;
	}

	/**
	 * repairInspHrsLimit Getters
	 * 
	 * @return Returns the repairInspHrsLimit
	 */
	public String getRepairInspHrsLimit() {
		return repairInspHrsLimit;
	}

	/**
	 * repairInspHrsLimit Setters
	 * 
	 * @param repairInspHrsLimit
	 *            the repairInspHrsLimit to set
	 */
	public void setRepairInspHrsLimit(String repairInspHrsLimit) {
		this.repairInspHrsLimit = repairInspHrsLimit;
	}

	/**
	 * repairInspStrtLimit Getters
	 * 
	 * @return Returns the repairInspStrtLimit
	 */
	public String getRepairInspStrtLimit() {
		return repairInspStrtLimit;
	}

	/**
	 * repairInspStrtLimit Setters
	 * 
	 * @param repairInspStrtLimit
	 *            the repairInspStrtLimit to set
	 */
	public void setRepairInspStrtLimit(String repairInspStrtLimit) {
		this.repairInspStrtLimit = repairInspStrtLimit;
	}

	/**
	 * repairMandHrsLimit Getters
	 * 
	 * @return Returns the repairMandHrsLimit
	 */
	public String getRepairMandHrsLimit() {
		return repairMandHrsLimit;
	}

	/**
	 * repairMandHrsLimit Setters
	 * 
	 * @param repairMandHrsLimit
	 *            the repairMandHrsLimit to set
	 */
	public void setRepairMandHrsLimit(String repairMandHrsLimit) {
		this.repairMandHrsLimit = repairMandHrsLimit;
	}

	/**
	 * repairMandStrtLimit Getters
	 * 
	 * @return Returns the repairMandStrtLimit
	 */
	public String getRepairMandStrtLimit() {
		return repairMandStrtLimit;
	}

	/**
	 * repairMandStrtLimit Setters
	 * 
	 * @param repairMandStrtLimit
	 *            the repairMandStrtLimit to set
	 */
	public void setRepairMandStrtLimit(String repairMandStrtLimit) {
		this.repairMandStrtLimit = repairMandStrtLimit;
	}

	/**
	 * repairCountVal Getters
	 * 
	 * @return Returns the repairCountVal
	 */
	public String getRepairCountVal() {
		return repairCountVal;
	}

	/**
	 * repairCountVal Setters
	 * 
	 * @param repairCountVal
	 *            the repairCountVal to set
	 */
	public void setRepairCountVal(String repairCountValLocal) {
		repairCountVal = repairCountValLocal;
	}

	/**
	 * combLowerRepairLimitFFH Getters
	 * 
	 * @return Returns the combLowerRepairLimitFFH
	 */
	public String getCombLowerRepairLimitFFH() {
		return combLowerRepairLimitFFH;
	}

	/**
	 * combLowerRepairLimitFFH Setters
	 * 
	 * @param combLowerRepairLimitFFH
	 *            the combLowerRepairLimitFFH to set
	 */
	public void setCombLowerRepairLimitFFH(String combLowerRepairLimitFFH) {
		this.combLowerRepairLimitFFH = combLowerRepairLimitFFH;
	}

	/**
	 * combLowerRepairLimitFFS Getters
	 * 
	 * @return Returns the combLowerRepairLimitFFS
	 */
	public String getCombLowerRepairLimitFFS() {
		return combLowerRepairLimitFFS;
	}

	/**
	 * combLowerRepairLimitFFS Setters
	 * 
	 * @param combLowerRepairLimitFFS
	 *            the combLowerRepairLimitFFS to set
	 */
	public void setCombLowerRepairLimitFFS(String combLowerRepairLimitFFS) {
		this.combLowerRepairLimitFFS = combLowerRepairLimitFFS;
	}

	/**
	 * combLowerReplaceLimitFFH Getters
	 * 
	 * @return Returns the combLowerReplaceLimitFFH
	 */
	public String getCombLowerReplaceLimitFFH() {
		return combLowerReplaceLimitFFH;
	}

	/**
	 * combLowerReplaceLimitFFH Setters
	 * 
	 * @param combLowerReplaceLimitFFH
	 *            the combLowerReplaceLimitFFH to set
	 */
	public void setCombLowerReplaceLimitFFH(String combLowerReplaceLimitFFH) {
		this.combLowerReplaceLimitFFH = combLowerReplaceLimitFFH;
	}

	/**
	 * combLowerReplaceLimitFFS Getters
	 * 
	 * @return Returns the combLowerReplaceLimitFFS
	 */
	public String getCombLowerReplaceLimitFFS() {
		return combLowerReplaceLimitFFS;
	}

	/**
	 * combLowerReplaceLimitFFS Setters
	 * 
	 * @param combLowerReplaceLimitFFS
	 *            the combLowerReplaceLimitFFS to set
	 */
	public void setCombLowerReplaceLimitFFS(String combLowerReplaceLimitFFS) {
		this.combLowerReplaceLimitFFS = combLowerReplaceLimitFFS;
	}

	/**
	 * falloutThreshold Getters
	 * 
	 * @return Returns the falloutThreshold
	 */
	public String getFalloutThreshold() {
		return falloutThreshold;
	}

	/**
	 * falloutThreshold Setters
	 * 
	 * @param falloutThreshold
	 *            the falloutThreshold to set
	 */
	public void setFalloutThreshold(String falloutThreshold) {
		this.falloutThreshold = falloutThreshold;
	}

	/**
	 * repairCost Getters
	 * 
	 * @return Returns the repairCost
	 */
	public String getRepairCost() {
		return repairCost;
	}

	/**
	 * repairCost Setters
	 * 
	 * @param repairCost
	 *            the repairCost to set
	 */
	public void setRepairCost(String repairCost) {
		this.repairCost = repairCost;
	}

	/**
	 * repairPrice Getters
	 * 
	 * @return Returns the repairPrice
	 */
	public String getRepairPrice() {
		return repairPrice;
	}

	/**
	 * repairPrice Setters
	 * 
	 * @param repairPrice
	 *            the repairPrice to set
	 */
	public void setRepairPrice(String repairPrice) {
		this.repairPrice = repairPrice;
	}

	/**
	 * replaceCost Getters
	 * 
	 * @return Returns the replaceCost
	 */
	public String getReplaceCost() {
		return replaceCost;
	}

	/**
	 * replaceCost Setters
	 * 
	 * @param replaceCost
	 *            the replaceCost to set
	 */
	public void setReplaceCost(String replaceCost) {
		this.replaceCost = replaceCost;
	}

	/**
	 * replacePrice Getters
	 * 
	 * @return Returns the replacePrice
	 */
	public String getReplacePrice() {
		return replacePrice;
	}

	/**
	 * replacePrice Setters
	 * 
	 * @param replacePrice
	 *            the replacePrice to set
	 */
	public void setReplacePrice(String replacePrice) {
		this.replacePrice = replacePrice;
	}

	/**
	 * repairCostAdj Getters
	 * 
	 * @return Returns the repairCostAdj
	 */
	public String getRepairCostAdj() {
		return repairCostAdj;
	}

	/**
	 * repairCostAdj Setters
	 * 
	 * @param repairCostAdj
	 *            the repairCostAdj to set
	 */
	public void setRepairCostAdj(String repairCostAdj) {
		this.repairCostAdj = repairCostAdj;
	}

	/**
	 * repairPriceAdj Getters
	 * 
	 * @return Returns the repairPriceAdj
	 */
	public String getRepairPriceAdj() {
		return repairPriceAdj;
	}

	/**
	 * repairPriceAdj Setters
	 * 
	 * @param repairPriceAdj
	 *            the repairPriceAdj to set
	 */
	public void setRepairPriceAdj(String repairPriceAdj) {
		this.repairPriceAdj = repairPriceAdj;
	}

	/**
	 * floatFlag Getters
	 * 
	 * @return Returns the floatFlag
	 */
	public String getFloatFlag() {
		return floatFlag;
	}

	/**
	 * floatFlag Setters
	 * 
	 * @param floatFlag
	 *            the floatFlag to set
	 */
	public void setFloatFlag(String floatFlag) {
		this.floatFlag = floatFlag;
	}

	public String getFleetID() {
		return fleetID;
	}

	public void setFleetID(String fleetID) {
		this.fleetID = fleetID;
	}
}
