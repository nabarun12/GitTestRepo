/*************************************************************************
 *    Copyright (C) 2007 General Electric Company. All rights reserved   *
 *            File Name: ScheduleFallout.java                            *
 *            Author Name:Tata Consultancy Services, Limited.            *
 *  Confidential and proprietary information of General Electric Company *
 ************************************************************************/

/**
 * @author TCS
 * Purpose: 
 * Created : Mar 1, 2006
 */
package service;

import inputprocessor.InputService;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.nfunk.jep.JEP;
import org.nfunk.jep.function.Exp;
import org.nfunk.jep.function.NaturalLogarithm;
import org.nfunk.jep.function.Power;
import org.nfunk.jep.function.SquareRoot;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import Favorite.FavoriteRead;
import Favorite.FavoriteWrite;
import  data.ARConstants;
import  data.DistributionType;
import  data.FailureMode;
import  data.FalloutRepairPart;
import data.FalloutPartKit;
import  data.FinFalloutData;
import data.PartFalloutVO;
import data.PartLimitsVO;
import  data.FalloutPart;
import  data.StepPartKit;


// TODO: Auto-generated Javadoc

/**
 * The Class CalculateFalloutSvcImpl.
 * 
 * @author TCS Purpose : Extends : Implements :
 */
public class FalloutProcessor {

	/** The Constant DOUBLENUM. */
	public static final double DOUBLENUM = 2.71828182845904;

	/** The Constant DBHUNDRED. */
	public static final double DBHUNDRED = 100.00;

	/** The Constant THREEPOINTEIGHTNINE. */
	public static final double THREEPOINTEIGHTNINE = 3.89;
	
	private static final Logger logger = LoggerFactory.getLogger(FalloutProcessor.class);

	private static HashMap ztableMap;
	
	/** The _obj fallout data. */
	private FinFalloutData _objFalloutData;
	
	
	private InputService inputserv = new InputService();
	
	private FavoriteWrite favWrite = new FavoriteWrite();
	
	private FavoriteRead favRead = new FavoriteRead();
	
	public FalloutProcessor(){};

	public FalloutProcessor(FinFalloutData objFalloutData) {
		_objFalloutData = objFalloutData;
		
		ztableMap = new HashMap();
		ztableMap.putAll(objFalloutData.getzTableMap());
	}

	/**
	 * Process fallout.
	 * @throws IOException 
	 */
	public void getInput(PartFalloutVO partVo) throws IOException{
		
		_objFalloutData = inputserv.processInputFallOutData(partVo);
		ztableMap = new HashMap();
		//ztableMap.putAll(_objFalloutData.getzTableMap());
		
	}
	
   public void writeFavortie(PartFalloutVO partVo) throws IOException{
		
	    favWrite.processOutputFallOutData(partVo);
		
	}
   
   public PartFalloutVO readFromCSV() throws IOException{
		
	   return favRead.readFromCSV();
		
	}
   
	public PartFalloutVO processFallout(FalloutPart outPart) {
		int jVar = 0;
        PartFalloutVO partFallOutVo = new PartFalloutVO();
        PartLimitsVO partLimitsVo = new PartLimitsVO();
		FalloutPartKit objPartKit = null;
		FalloutPart objPart = null;
		List lstRepairPart = null;
		double falloutParts = 0;
		double falloutPct = 0;
		ArrayList lstFalloutParts = null;
		FalloutRepairPart objFalloutRepairPart = null;
		Map oldFalloutPct = new HashMap();
		float totPartCount;
		//try {
			lstRepairPart = (List) _objFalloutData.getPartData().get(outPart.getPartID());
			lstFalloutParts = new ArrayList(ARConstants.INITIAL_ARRAYLIST_SIZE);

			for (jVar = 0; jVar < lstRepairPart.size(); jVar++) {

				objPart = (FalloutPart) lstRepairPart.get(jVar);
				objPartKit = (FalloutPartKit) _objFalloutData.getPartKitData().get(objPart.getPartKitId());
				partLimitsVo=(PartLimitsVO)_objFalloutData.getPartKitLimitData().get(objPart.getPartKitId());
				if (null != objPartKit) {
					totPartCount = objPartKit.getNoOfParts();

					if (jVar == 0) {
						objFalloutRepairPart = new FalloutRepairPart();
						objFalloutRepairPart.setRemPartsSinceRepair(objPartKit.getNoOfParts());
						lstFalloutParts.add(objFalloutRepairPart);
					}
					if (totPartCount > 1 /*
										 * &&
										 * _objFalloutData.getLstFallOutEquip(
										 * ).containsKey(objPart.getEquipID())
										 */) {
						falloutParts = calculateFalloutParts(lstRepairPart, objPart, objPartKit, jVar, lstFalloutParts, oldFalloutPct);
						falloutPct = falloutParts / totPartCount;
					}
				}
			}
		/*} catch (Exception e) {
			logger.error("FalloutProcessor::processFallout: ", e);
		}*/
	    partFallOutVo.setFallOutPercentage(Double.toString((Math.round(falloutPct*100.0)/100.0)));
	    partFallOutVo.setFallOutCost(Double.toString((Math.round((Double.parseDouble(partLimitsVo.getReplaceCost())*falloutPct)*100.0)/100.0)));
	    
		return partFallOutVo;
	}

	/**
	 * Calculate age of part.
	 */
	private void calculateAgeOfPart(List lstRepairPart, FalloutPart objPart, FalloutRepairPart objFoutRepParts, int repairIndex) {

		FalloutPart objFstPartRep = null;
		FalloutPart prevPartRep = null;
		double fhs = 0;
		double fhh = 0;

		double hoursLife;
		double startsLife;

		objFstPartRep = (FalloutPart) lstRepairPart.get(repairIndex);

		if (repairIndex == 0) {
			hoursLife = objFstPartRep.getFFH();
			startsLife = objFstPartRep.getFFS();
		} else {
			prevPartRep = (FalloutPart) lstRepairPart.get(repairIndex - 1);
			hoursLife = objFstPartRep.getFFH() - prevPartRep.getFFH();
			startsLife = objFstPartRep.getFFS() - prevPartRep.getFFS();
		}
		fhh = objFoutRepParts.getAgeOfRemainingPartHrs() + hoursLife;
		fhs = objFoutRepParts.getAgeOfRemainingPartStarts() + startsLife;
		objPart.setAgeOfPartHrs(fhh);
		objPart.setAgeOfPartStarts(fhs);

	}

	/**
	 * Calculate fallout parts.
	 */
	private double calculateFalloutParts(List lstRepairPart, FalloutPart objPart, FalloutPartKit objPartKit, int repairIndex, ArrayList lstFalloutParts, Map oldFalloutPct) {
		double fallOutParts = 0;
		int distCount = 0;
		List lstDistType = null;
		List lstFailModes = null;
		double foutRepParts = 0;
		int repCnt = 0;
		double remPartsLastRepair = 0;
		FalloutRepairPart objFoutRepParts = null;
		FalloutPart zeroObjPart;
		if (null != objPartKit.getDistType()) {
				lstDistType = objPartKit.getDistType();
				DistributionType objDistType = null;
				FailureMode objFailMode = null;
				float falloutPercFailMode = 0;
				float startsFalloutPercFailMode = 0;
				float hoursFalloutPercFailMode = 0;
				float falloutPerc = 1;
				float startFalloutPerc;
				float endFalloutPerc;
				float endFalloutStartsPerc = 0;
				float endFalloutHoursPerc = 0;
				float startFalloutStartsPerc = 0;
				float startFalloutHoursPerc = 0;
				String strHoursFallPct;
				String strStartsFallPct;
				for (repCnt = 0; repCnt <= repairIndex; repCnt++) {
					foutRepParts = 0;
					falloutPerc = 1;
					objFoutRepParts = (FalloutRepairPart) lstFalloutParts.get(repCnt);
					remPartsLastRepair = objFoutRepParts.getRemPartsSinceRepair();
					calculateAgeOfPart(lstRepairPart, objPart, objFoutRepParts, repairIndex);
					int distSize = lstDistType.size();
					for (distCount = 0; distCount < distSize; distCount++) {
						objDistType = (DistributionType) lstDistType.get(distCount);
						lstFailModes = objDistType.getFailureModes();
						int failModeSz = lstFailModes.size();
						if (failModeSz == 1) {
							objFailMode = (FailureMode) lstFailModes.get(0);
							if (! "COMBINED".equals(objFailMode.getFailureMode())) {
								if (objPartKit.getDistributionType().equalsIgnoreCase("STEP")) {
									if (_objFalloutData.getStepPartKitData().containsKey(objPartKit.getPartKitId())) {
										List singleStepPartKitList = (List) _objFalloutData.getStepPartKitData().get(objPartKit.getPartKitId());
										endFalloutPerc = fallOutStepFailMode(objFailMode, objPart, singleStepPartKitList);
									} else {
										endFalloutPerc = 0;
									}
								} else {
									endFalloutPerc = fallOutDistFailMode(objDistType.getDistributionName(), objFailMode, objPart, repCnt);
								}
								startFalloutPerc = getRepairIndex(objPartKit, repairIndex, oldFalloutPct, repCnt, objDistType, objFailMode);
								if (endFalloutPerc < 1) {
									falloutPercFailMode = (endFalloutPerc - startFalloutPerc) / (1 - startFalloutPerc);
								} else {
									falloutPercFailMode = 1;
								}
								oldFalloutPct.put(repCnt + "^" + objDistType.getDistributionName() + "^" + objFailMode.getFailureMode(), endFalloutPerc + "");
							} else {
								falloutPercFailMode = fallOutDistFailMode(objDistType.getDistributionName(), objFailMode, objPart, repCnt);
							}
						} else {
							if (objPartKit.getDistributionType().equalsIgnoreCase("STEP")) {
								if (_objFalloutData.getStepPartKitData().containsKey(objPartKit.getPartKitId())) {
									List singleStepPartKitList = (List) _objFalloutData.getStepPartKitData().get(objPartKit.getPartKitId());
									objFailMode = (FailureMode) lstFailModes.get(0);
									endFalloutStartsPerc = fallOutStepFailMode(objFailMode, objPart, singleStepPartKitList);
									objFailMode = (FailureMode) lstFailModes.get(1);
									endFalloutHoursPerc = fallOutStepFailMode(objFailMode, objPart, singleStepPartKitList);
								} else {
									endFalloutStartsPerc = 0;
									endFalloutHoursPerc = 0;
								}
							} else {
								objFailMode = (FailureMode) lstFailModes.get(0);
								endFalloutStartsPerc = fallOutDistFailMode(objDistType.getDistributionName(), objFailMode, objPart, repCnt);
								objFailMode = (FailureMode) lstFailModes.get(1);
								endFalloutHoursPerc = fallOutDistFailMode(objDistType.getDistributionName(), objFailMode, objPart, repCnt);
							}
							if (repCnt == repairIndex) {
								zeroObjPart = new FalloutPart();
								if (objPartKit.getDistributionType().equalsIgnoreCase("STEP")) {
									startFalloutStartsPerc = 0;
									startFalloutHoursPerc = 0;
								} else {
									objFailMode = (FailureMode) lstFailModes.get(0);
									startFalloutStartsPerc = fallOutDistFailMode(objDistType.getDistributionName(), objFailMode, zeroObjPart, repCnt);
									objFailMode = (FailureMode) lstFailModes.get(1);
									startFalloutHoursPerc = fallOutDistFailMode(objDistType.getDistributionName(), objFailMode, zeroObjPart, repCnt);
								}
							} else {
								objFailMode = (FailureMode) lstFailModes.get(0);
								strStartsFallPct = (String) oldFalloutPct.get( (repCnt) + "^" + objDistType.getDistributionName() + "^" + objFailMode.getFailureMode());
								objFailMode = (FailureMode) lstFailModes.get(1);
								strHoursFallPct = (String) oldFalloutPct.get( (repCnt) + "^" + objDistType.getDistributionName() + "^" + objFailMode.getFailureMode());
								if (strStartsFallPct != null && ! strStartsFallPct.trim().equals("")) {
									startFalloutStartsPerc = Float.parseFloat(strStartsFallPct);
								} else {
									startFalloutStartsPerc = 0;
								}
								if (strHoursFallPct != null && ! strHoursFallPct.trim().equals("")) {
									startFalloutHoursPerc = Float.parseFloat(strHoursFallPct);
								} else {
									startFalloutHoursPerc = 0;
								}
							}
							checkFailuremode(oldFalloutPct, lstFailModes, repCnt, objDistType, endFalloutStartsPerc, endFalloutHoursPerc);
							if (endFalloutStartsPerc < 1) {
								startsFalloutPercFailMode = (endFalloutStartsPerc - startFalloutStartsPerc) / (1 - startFalloutStartsPerc);
							} else {
								startsFalloutPercFailMode = 1;
							}
							if (endFalloutHoursPerc < 1) {
								hoursFalloutPercFailMode = (endFalloutHoursPerc - startFalloutHoursPerc) / (1 - startFalloutHoursPerc);
							} else {
								hoursFalloutPercFailMode = 1;
							}
							if (objPartKit.getCombineFalloutInd().equalsIgnoreCase("Y")) {
								falloutPercFailMode = 1 - (1 - startsFalloutPercFailMode) * (1 - hoursFalloutPercFailMode);
							} else {
								if (startsFalloutPercFailMode > hoursFalloutPercFailMode) {
									falloutPercFailMode = startsFalloutPercFailMode;
								} else {
									falloutPercFailMode = hoursFalloutPercFailMode;
								}
							}
						}
						if (falloutPercFailMode > ARConstants.ONE) {
							falloutPercFailMode = ARConstants.ONE;
						} else if (falloutPercFailMode < ARConstants.ZERO) {
							falloutPercFailMode = ARConstants.ZERO;
						}
						falloutPercFailMode = 1 - falloutPercFailMode;
						falloutPerc = falloutPerc * falloutPercFailMode;
					}
					falloutPerc = 1 - falloutPerc;
					objPart.setFallOutPerc(falloutPerc);
					foutRepParts = foutRepParts + falloutPerc * remPartsLastRepair;
					objFoutRepParts.setRemPartsSinceRepair(remPartsLastRepair - foutRepParts);
					objFoutRepParts.setAgeOfRemainingPartHrs(objPart.getAgeOfPartHrs() * objPartKit.getPartKitRE());
					objFoutRepParts.setAgeOfRemainingPartStarts(objPart.getAgeOfPartStarts() * objPartKit.getPartKitRE());
					fallOutParts = fallOutParts + foutRepParts;
				}
				objFoutRepParts = new FalloutRepairPart();
				objFoutRepParts.setRemPartsSinceRepair(fallOutParts);
				lstFalloutParts.add(objFoutRepParts);
			}
		
			return fallOutParts;
	}

	private void checkFailuremode(Map oldFalloutPct, List lstFailModes, int repCnt, DistributionType objDistType, float endFalloutStartsPerc, float endFalloutHoursPerc) {
		FailureMode objFailMode;
		// if (repCnt == 0) {
		objFailMode = (FailureMode) lstFailModes.get(0);
		oldFalloutPct.put(repCnt + "^" + objDistType.getDistributionName() + "^" + objFailMode.getFailureMode(), endFalloutStartsPerc + "");
		objFailMode = (FailureMode) lstFailModes.get(1);
		oldFalloutPct.put(repCnt + "^" + objDistType.getDistributionName() + "^" + objFailMode.getFailureMode(), endFalloutHoursPerc + "");
		// }
	}

	private float getRepairIndex(FalloutPartKit objPartKit, int repairIndex, Map oldFalloutPct, int repCnt, DistributionType objDistType, FailureMode objFailMode)/* */{
		FalloutPart zeroObjPart;
		float startFalloutPerc;
		String strFallPct;
		if (repCnt == repairIndex) {
			zeroObjPart = new FalloutPart();
			if (objPartKit.getDistributionType().equalsIgnoreCase("STEP")) {
				startFalloutPerc = 0;
			} else {
				startFalloutPerc = fallOutDistFailMode(objDistType.getDistributionName(), objFailMode, zeroObjPart, repCnt);
			}
		} else {
			strFallPct = (String) oldFalloutPct.get( (repCnt) + "^" + objDistType.getDistributionName() + "^" + objFailMode.getFailureMode());
			if (strFallPct != null && ! strFallPct.trim().equals("")) {
				startFalloutPerc = Float.parseFloat(strFallPct);
			} else {
				startFalloutPerc = 0;
			}
		}
		return startFalloutPerc;
	}

	/**
	 * Fall out dist fail mode.
	 */
	private float fallOutDistFailMode(String distributionType, FailureMode objFailMode, FalloutPart objPart, int repairIndex) {
		String failMode = objFailMode.getFailureMode();

		float falloutPerc = 0;
		if (ARConstants.FAILUREMODE_FFH.equalsIgnoreCase(failMode)) {
			falloutPerc = calcIndFalloutPercentage(distributionType, objFailMode.getFailureMode(), objPart.getAgeOfPartHrs(), objFailMode.getFuncParams(), objFailMode.getFuncFormula());
		} else if (ARConstants.FAILUREMODE_FFS.equalsIgnoreCase(failMode)) {
			falloutPerc = calcIndFalloutPercentage(distributionType, objFailMode.getFailureMode(), objPart.getAgeOfPartStarts(), objFailMode.getFuncParams(), objFailMode.getFuncFormula());
		} else if (ARConstants.FAILUREMODE_COMBINED.equalsIgnoreCase(failMode)) {
			falloutPerc = calcCustomFalloutPercentage(objPart.getAgeOfPartHrs(), objPart.getAgeOfPartStarts(), objFailMode.getFuncParams(), objFailMode.getFuncFormula(), repairIndex);
		}

		return falloutPerc;
	}

	/**
	 * Step calculation =
	 */
	private float fallOutStepFailMode(FailureMode objFailMode, FalloutPart objPart, List singleStepPartKitList) {
		String failMode = objFailMode.getFailureMode();
		float falloutPerc = 0;
		StepPartKit tempStepData = null;
		List ffhStepDataList = new ArrayList();
		List ffsStepDataList = new ArrayList();
		if (singleStepPartKitList != null && singleStepPartKitList.size() > 0) {
			for (int i = 0; i < singleStepPartKitList.size(); i++) {
				tempStepData = (StepPartKit) singleStepPartKitList.get(i);
				if (ARConstants.FAILUREMODE_FFH.equalsIgnoreCase(tempStepData.getFailModeName())) {
					ffhStepDataList.add(tempStepData);
				} else if (ARConstants.FAILUREMODE_FFS.equalsIgnoreCase(tempStepData.getFailModeName())) {
					ffsStepDataList.add(tempStepData);
				}
			}

			if (ARConstants.FAILUREMODE_FFH.equalsIgnoreCase(failMode)) {
				falloutPerc = calcStepFalloutPercentage(objPart.getAgeOfPartHrs(), ffhStepDataList);
			} else if (ARConstants.FAILUREMODE_FFS.equalsIgnoreCase(failMode)) {
				falloutPerc = calcStepFalloutPercentage(objPart.getAgeOfPartStarts(), ffsStepDataList);
			}
		}
		if (falloutPerc > ARConstants.ONE) {
			falloutPerc = ARConstants.ONE;
		} else if (falloutPerc < ARConstants.ZERO) {
			falloutPerc = ARConstants.ZERO;
		}
		return falloutPerc;
	}

	/**
	 * Calc ind fallout percentage.
	 */
	private float calcIndFalloutPercentage(String distMode, String failureMode, double fhs, Map failModeParams, String formulaVal) {
		float indFalloutPercentage = 0;

		if (distMode.equalsIgnoreCase(ARConstants.DISTMODE_LOGNORMAL) && (failureMode.equalsIgnoreCase(ARConstants.FAILUREMODE_FFH) || failureMode.equalsIgnoreCase(ARConstants.FAILUREMODE_FFS))) {

			double stdDev1 = 0;
			double mean1 = 0;
			double ztblKey = 0;
			boolean zvalNegative = false;
			
			double dFalloutPercentage = 0;
			double param1 = 0;
			double param2 = 0;

			param1 = Double.parseDouble((String) failModeParams.get(ARConstants.EX));
			param2 = Double.parseDouble((String) failModeParams.get(ARConstants.SQRTVARX));

			BigDecimal roundfinalPrice = new BigDecimal(Math.sqrt(Math.log(1 + (param2 * param2 / (param1 * param1))))).setScale(9, BigDecimal.ROUND_HALF_UP);
			Double doublePrice = Double.valueOf(roundfinalPrice.doubleValue() + "");
			stdDev1 = doublePrice.doubleValue();

			roundfinalPrice = new BigDecimal(Math.log(param1) - 0.5 * (Math.pow(stdDev1, 2))).setScale(9, BigDecimal.ROUND_HALF_UP);
			doublePrice = Double.valueOf(roundfinalPrice.doubleValue() + "");
			mean1 = doublePrice.doubleValue();

			roundfinalPrice = new BigDecimal( (Math.log(fhs) - mean1) / stdDev1).setScale(9, BigDecimal.ROUND_HALF_UP);
			doublePrice = Double.valueOf(roundfinalPrice.doubleValue() + "");
			ztblKey = doublePrice.doubleValue();
			ztblKey = Math.round(ztblKey * ARConstants.HUNDRED) / DBHUNDRED;
			if (ztblKey < 0.0) {
				zvalNegative = true;
				ztblKey = ARConstants.NEG_ONE * ztblKey;
			}
			if (ztblKey > THREEPOINTEIGHTNINE) {
				dFalloutPercentage = 1.0;
			} else {
				String keyStrValue = (String) ztableMap.get(Double.valueOf(ztblKey + ""));
				if (keyStrValue == null) {
					dFalloutPercentage = 0;
				} else {
					keyStrValue = keyStrValue.substring(keyStrValue.indexOf('^') + 1);
					dFalloutPercentage = Double.parseDouble(keyStrValue);
				}
			}
			if (zvalNegative) {
				dFalloutPercentage = 1 - dFalloutPercentage;
			}

			indFalloutPercentage = (new Float(dFalloutPercentage)).floatValue();
		} else {
			JEP expParser = loadParser();
			expParser.addVariable("FHS", fhs);
			expParser.addVariable("PI", Math.PI);

			if (failModeParams != null) {
				Iterator failModeItr = failModeParams.entrySet().iterator();
				String failModeName = null;
				String failModeValue = null;
				while (failModeItr.hasNext()) {
					Map.Entry entry = (Map.Entry) failModeItr.next();
					failModeName = (String) entry.getKey();
					failModeValue = (String) entry.getValue();

					expParser.addVariable(failModeName, Double.parseDouble(failModeValue));
				}
			}
			expParser.parseExpression(formulaVal);

			indFalloutPercentage = Float.parseFloat(expParser.getValue() + "");
			if (Float.isInfinite(indFalloutPercentage) || Float.isNaN(indFalloutPercentage)) {
				indFalloutPercentage = 0;
			}
		}

		return indFalloutPercentage;
	}

	/**
	 * Step Fallout Percentage
	 */
	private float calcStepFalloutPercentage(double fhs, List singleStepPartKitList) {
		float indFalloutPercentage = 0;
		double slope = 0;
		double intercepts = 0;
		double diffFactVale = 0;
		double maxDiffPct = 0;
		double diffPct = 0;
		StepPartKit stepPartKitDataOne = null;
		StepPartKit stepPartKitDataTwo = null;
		StepPartKit maxStepPartKitDataOne = null;
		StepPartKit maxStepPartKitDataTwo = null;
		StepPartKit tempStepDataOne = null;
		StepPartKit tempStepDataTwo = null;

		if (singleStepPartKitList != null && singleStepPartKitList.size() > 0) {
			if (singleStepPartKitList.size() == 1) {
				stepPartKitDataOne = (StepPartKit) singleStepPartKitList.get(0);
				if (stepPartKitDataOne.getFactoredValue().equalsIgnoreCase("0")) {
					stepPartKitDataOne.setFactoredValue("1");
				}
				slope = Double.parseDouble(stepPartKitDataOne.getFalloutPct()) / Double.parseDouble(stepPartKitDataOne.getFactoredValue());
				intercepts = Double.parseDouble(stepPartKitDataOne.getFalloutPct()) - slope * Double.parseDouble(stepPartKitDataOne.getFactoredValue());
				indFalloutPercentage = (float) (slope * fhs + intercepts);
			} else if (singleStepPartKitList.size() > 1) {
				for (int i = 1; i < singleStepPartKitList.size(); i++) {
					tempStepDataOne = (StepPartKit) singleStepPartKitList.get(i - 1);
					tempStepDataTwo = (StepPartKit) singleStepPartKitList.get(i);
					if (fhs > Double.parseDouble(tempStepDataOne.getFactoredValue()) && fhs <= Double.parseDouble(tempStepDataTwo.getFactoredValue())) {
						stepPartKitDataOne = tempStepDataOne;
						stepPartKitDataTwo = tempStepDataTwo;
					}
					diffPct = (Double.parseDouble(tempStepDataTwo.getFalloutPct()) - Double.parseDouble(tempStepDataOne.getFalloutPct()));
					if (diffPct > maxDiffPct) {
						maxDiffPct = diffPct;
						maxStepPartKitDataOne = tempStepDataOne;
						maxStepPartKitDataTwo = tempStepDataTwo;
					}
				}
				if (stepPartKitDataOne != null && stepPartKitDataTwo != null) {
					diffFactVale = (Double.parseDouble(stepPartKitDataTwo.getFactoredValue()) - Double.parseDouble(stepPartKitDataOne.getFactoredValue()));
					if (diffFactVale == 0) {
						diffFactVale = 1;
					}
					slope = (Double.parseDouble(stepPartKitDataTwo.getFalloutPct()) - Double.parseDouble(stepPartKitDataOne.getFalloutPct())) / diffFactVale;
					intercepts = Double.parseDouble(stepPartKitDataOne.getFalloutPct()) - slope * Double.parseDouble(stepPartKitDataOne.getFactoredValue());
					indFalloutPercentage = (float) (slope * fhs + intercepts);
				} else {

					diffFactVale = (Double.parseDouble(maxStepPartKitDataTwo.getFactoredValue()) - Double.parseDouble(maxStepPartKitDataOne.getFactoredValue()));
					if (diffFactVale == 0) {
						diffFactVale = 1;
					}
					slope = (Double.parseDouble(maxStepPartKitDataTwo.getFalloutPct()) - Double.parseDouble(maxStepPartKitDataOne.getFalloutPct())) / diffFactVale;
					intercepts = Double.parseDouble(maxStepPartKitDataOne.getFalloutPct()) - slope * Double.parseDouble(maxStepPartKitDataOne.getFactoredValue());
					indFalloutPercentage = (float) (slope * fhs + intercepts);
				}
			}
		}
		return indFalloutPercentage;
	}

	/**
	 * Calc ind fallout percentage for combined formula.
	 */
	private float calcCustomFalloutPercentage(double ffh, double ffs, Map failModeParams, String formulaVal, int repairIndex) {
		float indFalloutPercentage = 0;
		double fncValue = 1.0;
		try {
			JEP expParser = loadParser();
			expParser.addVariable("FFH", ffh);
			expParser.addVariable("FFS", ffs);
			expParser.addVariable("PI", Math.PI);

			if (failModeParams != null) {
				if (repairIndex == 0) {
					try {
						fncValue = Double.parseDouble((String) failModeParams.get("F0"));
					} catch (NumberFormatException exc) {
						fncValue = 1.0;
						logger.error("FalloutProcessor::calcCustomFalloutPercentage: ", exc);
					}
				} else {
					try {
						fncValue = Double.parseDouble((String) failModeParams.get("FN"));
					} catch (NumberFormatException exc) {
						fncValue = 1.0;
						logger.error("FalloutProcessor::calcCustomFalloutPercentage: ", exc);
					}
				}
				expParser.addVariable("Fnc", fncValue);
				Iterator failModeItr = failModeParams.entrySet().iterator();

				String failModeName = null;
				String failModeValue = null;
				while (failModeItr.hasNext()) {
					Map.Entry entry = (Map.Entry) failModeItr.next();
					failModeName = (String) entry.getKey();
					failModeValue = (String) entry.getValue();

					expParser.addVariable(failModeName, Double.parseDouble(failModeValue));
				}
			}
			expParser.parseExpression(formulaVal);

			indFalloutPercentage = Float.parseFloat(expParser.getValue() + "");
			if (Float.isInfinite(indFalloutPercentage) || Float.isNaN(indFalloutPercentage)) {
				indFalloutPercentage = 0;
			}
		} catch (NumberFormatException e) {
			logger.error("FalloutProcessor::calcCustomFalloutPercentage: ", e);
		}
		return indFalloutPercentage;
	}

	private JEP loadParser() {
		JEP expParser = null;
		expParser = new JEP();
		expParser.setImplicitMul(true);
		expParser.setAllowAssignment(true);

		expParser.addFunction("exp", new Exp());
		expParser.addFunction("ln", new NaturalLogarithm());
		expParser.addFunction("power", new Power());
		expParser.addFunction("sqrt", new SquareRoot());

		return expParser;
	}


}
