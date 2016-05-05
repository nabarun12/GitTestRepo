package data;



import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import data.ARConstants;



// TODO: Auto-generated Javadoc
/**
 * The Class FinFalloutData.
 * 
 * @author TCS Purpose : Extends : Implements :
 */
public class FinFalloutData implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** The part lst. */
	private ArrayList partLst = new ArrayList(ARConstants.INITIAL_ARRAYLIST_SIZE);

	/** The part data. */
	private Map partData = new HashMap();

	/** The failure mode params. */
	private Map failureModeParams;

	/** The part kit data. */
	private HashMap partKitData = new HashMap();

	/** The lst fall out equip. */
	private HashMap lstFallOutEquip;

	/** The model ver id. */
	private String modelVerId;

	/** The equip id. */
	private String equipId;

	/** The fall out ind. */
	private String fallOutInd;

	/** The lst fallout. */
	private List lstFallout = new ArrayList(ARConstants.INITIAL_ARRAYLIST_SIZE);

	/** The user id. */
	private String userId;

	/** The step part kit data. */
	private HashMap stepPartKitData;
	
	
	/** The step part kit limt data. */
	private HashMap<String, PartLimitsVO> partKitLimitData;
	
	/* The Fallout ZTable*/
	private TreeMap<Double, Object> zTableMap;
	
	private String falloutPctInd;

	
	
	public TreeMap<Double, Object> getzTableMap() {
		return zTableMap;
	}

	public void setzTableMap(TreeMap<Double, Object> zTableMap) {
		this.zTableMap = zTableMap;
	}

	public HashMap getPartKitLimitData() {
		return partKitLimitData;
	}

	public void setPartKitLimitData(HashMap partKitLimitData) {
		this.partKitLimitData = partKitLimitData;
	}

	/**
	 * Gets the user id.
	 * 
	 * @return Returns the userId.
	 */
	public String getUserID() {
		return userId;
	}

	/**
	 * Sets the user id.
	 * 
	 * @param userId
	 *            The userId to set.
	 */
	public void setUserID(String inUserId) {
		this.userId = inUserId;
	}

	/**
	 * Gets the lst fall out equip.
	 * 
	 * @return Returns the lstFallOutEquip.
	 */
	public HashMap getLstFallOutEquip() {
		return lstFallOutEquip;
	}

	/**
	 * Sets the lst fall out equip.
	 * 
	 * @param lstFallOutEquip
	 *            The lstFallOutEquip to set.
	 */
	public void setLstFallOutEquip(HashMap lstFallOutEquip) {
		this.lstFallOutEquip = lstFallOutEquip;
	}

	/**
	 * Gets the failure mode params.
	 * 
	 * @return Returns the failureModeParams.
	 */
	public Map getFailureModeParams() {
		return failureModeParams;
	}

	/**
	 * Sets the failure mode params.
	 * 
	 * @param failureModeParams
	 *            The failureModeParams to set.
	 */
	public void setFailureModeParams(Map failureModeParams) {
		this.failureModeParams = failureModeParams;
	}

	/**
	 * Gets the part data.
	 * 
	 * @return Returns the partData.
	 */
	public Map getPartData() {
		return partData;
	}

	/**
	 * Sets the part data.
	 * 
	 * @param partData
	 *            The partData to set.
	 */
	public void setPartData(Map partData) {
		this.partData = partData;
	}

	/**
	 * Gets the part kit data.
	 * 
	 * @return Returns the partKitData.
	 */
	public HashMap getPartKitData() {
		return partKitData;
	}

	/**
	 * Sets the part kit data.
	 * 
	 * @param partKitData
	 *            The partKitData to set.
	 */
	public void setPartKitData(HashMap partKitData) {
		this.partKitData = partKitData;
	}

	/**
	 * Gets the equip id.
	 * 
	 * @return Returns the equipId.
	 */
	public String getEquipId() {
		return equipId;
	}

	/**
	 * Sets the equip id.
	 * 
	 * @param equipId
	 *            The equipId to set.
	 */
	public void setEquipId(String inEquipId) {
		this.equipId = inEquipId;
	}

	/**
	 * Gets the fall out ind.
	 * 
	 * @return Returns the fallOutInd.
	 */
	public String getFallOutInd() {
		return fallOutInd;
	}

	/**
	 * Sets the fall out ind.
	 * 
	 * @param fallOutInd
	 *            The fallOutInd to set.
	 */
	public void setFallOutInd(String fallOutInd) {
		this.fallOutInd = fallOutInd;
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
	 * Sets the model ver id.
	 * 
	 * @param modelVerId
	 *            The modelVerId to set.
	 */
	public void setModelVerID(String inModelVerID) {
		this.modelVerId = inModelVerID;
	}

	/**
	 * Gets the part lst.
	 * 
	 * @return Returns the partLst.
	 */
	public List getPartLst() {
		return partLst;
	}

	/**
	 * Sets the part lst.
	 * 
	 * @param partLst
	 *            The partLst to set.
	 */
	public void setPartLst(ArrayList partLst) {
		this.partLst = partLst;
	}

	/**
	 * Gets the lst fallout.
	 * 
	 * @return Returns the lstFallout.
	 */
	public List getLstFallout() {
		return lstFallout;
	}

	/**
	 * Sets the lst fallout.
	 * 
	 * @param lstFallout
	 *            The lstFallout to set.
	 */
	public void setLstFallout(List lstFallout) {
		this.lstFallout = lstFallout;
	}

	/**
	 * Gets the step partkit data.
	 * 
	 * @return Returns the stepPartKitData.
	 */
	public HashMap getStepPartKitData() {
		return stepPartKitData;
	}

	/**
	 * Sets the step partkit data.
	 * 
	 * @param stepPartKitData
	 *            The stepPartKitData to set.
	 */
	public void setStepPartKitData(HashMap stepPartKitData) {
		this.stepPartKitData = stepPartKitData;
	}

	public String getFalloutPctInd() {
		return falloutPctInd;
	}

	public void setFalloutPctInd(String falloutPctInd) {
		this.falloutPctInd = falloutPctInd;
	}

	@Override
	public String toString() {
		return "stepPartKitData: " + stepPartKitData + "falloutPctInd: " + falloutPctInd;
	}

}
