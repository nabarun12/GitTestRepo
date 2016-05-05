/************************************************************************
 *    Copyright (C) 2007 General Electric Company. All rights reserved   *
 *            File Name:FailureMode.java                                 *
 *            Author Name:Tata Consultancy Services, Limited.            *
 *  Confidential and proprietary information of General Electric Company *
 ************************************************************************/
///CLOVER:OFF
package data;

import java.io.Serializable;
import java.util.Map;


/**
 * The Class FailureMode.
 * 
 * @author TCS Purpose : Extends : Implements :
 */
public class FailureMode implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** The failure mode. */
	private String failureMode;

	/** The fall out percent. */
	private String fallOutPercent;

	/** The func params. */
	private Map funcParams;

	/** The func params. */
	private String funcFormula;

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
	 * Gets the func params.
	 * 
	 * @return Returns the funcParams.
	 */
	public Map getFuncParams() {
		return funcParams;
	}

	/**
	 * Sets the func params.
	 * 
	 * @param funcParams
	 *            The funcParams to set.
	 */
	public void setFuncParams(Map funcParams) {
		this.funcParams = funcParams;
	}

	/**
	 * Gets the fall out percent.
	 * 
	 * @return Returns the fallOutPercent.
	 */
	public String getFallOutPercent() {
		return fallOutPercent;
	}

	/**
	 * Sets the fall out percent.
	 * 
	 * @param fallOutPercent
	 *            The fallOutPercent to set.
	 */
	public void setFallOutPercent(String fallOutPercent) {
		this.fallOutPercent = fallOutPercent;
	}

	/**
	 * @return Returns the funcFormula.
	 */
	public String getFuncFormula() {
		return funcFormula;
	}

	/**
	 * @param funcFormula
	 *            The funcFormula to set.
	 */
	public void setFuncFormula(String funcFormula) {
		this.funcFormula = funcFormula;
	}

	@Override
	public String toString() {
		return "failureMode : " + failureMode + " fallOutPercent: " + fallOutPercent;
	}

}
