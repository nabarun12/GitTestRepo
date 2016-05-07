package inputprocessor;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import data.PartLimitsVO;
import service.FalloutProcessor;
import data.ARConstants;
import data.DistributionType;
import data.FailureMode;
import data.FalloutPart;
import data.FalloutPartKit;
import data.FinFalloutData;
import data.PartFalloutVO;
import data.StepPartKit;

public class InputService {

	public FinFalloutData processInputFallOutData(PartFalloutVO partVO) throws IOException{
		FalloutPart inputData = new FalloutPart();
		FinFalloutData inputDataFin = new FinFalloutData();
		fillOutExcelWithInputData(partVO);
		fillOutFinFalloutData(inputDataFin,partVO);
		
		return inputDataFin;
		
	}

	
public void fillOutExcelWithInputData(PartFalloutVO objFalloutData) throws IOException{
	
	FileInputStream fsIP= new FileInputStream("src/main/resources/FallOut_17396256.xlsx"); 
	XSSFWorkbook wb = new XSSFWorkbook(fsIP); 
	XSSFSheet worksheet = wb.getSheetAt(0); 
	XSSFCell cell = null; 
    cell = worksheet.getRow(1).getCell(3);   
    cell.setCellValue(objFalloutData.getReplacePrice1());
    cell = worksheet.getRow(1).getCell(4);   
    cell.setCellValue(objFalloutData.getReplaceCost1());
    cell = worksheet.getRow(2).getCell(3);   
    cell.setCellValue(objFalloutData.getReplacePrice2());
    cell = worksheet.getRow(2).getCell(4);   
    cell.setCellValue(objFalloutData.getReplaceCost2());
    worksheet = wb.getSheetAt(2);
    cell = worksheet.getRow(1).getCell(5);   
    cell.setCellValue(objFalloutData.getFhSinceRepair1());
    cell = worksheet.getRow(1).getCell(6);   
    cell.setCellValue(objFalloutData.getFsSinceRepair1());
    cell = worksheet.getRow(2).getCell(5);   
    cell.setCellValue(objFalloutData.getFhSinceRepair2());
    cell = worksheet.getRow(2).getCell(6);   
    cell.setCellValue(objFalloutData.getFsSinceRepair2());
    fsIP.close(); 
    FileOutputStream output_file =new FileOutputStream("src/main/resources/FallOut_17396256.xlsx"); 
    wb.write(output_file); 
    output_file.close();  
}


public void fillOutFinFalloutData(FinFalloutData objFalloutData,PartFalloutVO partVO) throws IOException{
   
	List<FalloutPart> foPartLst = fillFalloutPart(partVO);
	Map<String,List<FalloutPart>> outMap =  objFalloutData.getPartData();
	List<FalloutPart> partRepairList = new ArrayList<FalloutPart>(ARConstants.INITIAL_ARRAYLIST_SIZE);
	String attribVal = null;
	for (FalloutPart part : foPartLst) {
		if (null == attribVal || ! attribVal.equals(part.getPartID())) {
			if (null != attribVal) {
				outMap.put(attribVal, partRepairList);
				partRepairList = new ArrayList<FalloutPart>(ARConstants.INITIAL_ARRAYLIST_SIZE);
			}
			attribVal = part.getPartID();
		}
		partRepairList.add(part);
	}
	if (null != attribVal) { // for last part id
		outMap.put(attribVal, partRepairList);
	}
	List<FalloutPartKit> lstPartData = null;
	List<FalloutPartKit> foPartKistLst = fillFalloutPartKit(partVO);
	lstPartData = foPartKistLst;
	
	if (lstPartData != null && lstPartData.size() > 0) {
		FalloutPartKit objPartKit = null;
		FalloutPartKit objNxtPartKit = null;
		ArrayList<DistributionType> lstDistType = new ArrayList<DistributionType>(ARConstants.INITIAL_ARRAYLIST_SIZE);
		ArrayList<FailureMode> lstFailMode = new ArrayList<FailureMode>(ARConstants.INITIAL_ARRAYLIST_SIZE);

		DistributionType objDistributionType = null;
		FailureMode objFailureMode = null;
		String strDistType = null;
		String strFailMode = null;
		boolean lastRec = false;
		Map<String,String> distParams = new HashMap<String,String>();
		int iVar = 0;
		int partKitCount = lstPartData.size();
		String partKitId = null;
		for (; iVar < partKitCount; iVar++) {
			objPartKit = (FalloutPartKit) lstPartData.get(iVar);
			strFailMode = objPartKit.getFailureMode();
			strDistType = objPartKit.getDistributionType();
			partKitId = objPartKit.getPartKitId();
			distParams.put(objPartKit.getParamName(), objPartKit.getParamValue());
			if (iVar < partKitCount - 1) {
				objNxtPartKit = (FalloutPartKit) lstPartData.get(iVar + 1);
			} else {
				lastRec = true;
			}
			if (! strFailMode.equals(objNxtPartKit.getFailureMode()) || ! strDistType.equals(objNxtPartKit.getDistributionType()) || ! partKitId.equals(objNxtPartKit.getPartKitId()) || lastRec) {
				objFailureMode = new FailureMode();
				objFailureMode.setFailureMode(strFailMode);
				objFailureMode.setFuncParams(distParams);
				objFailureMode.setFuncFormula(objPartKit.getDistributionTypeFunc());
				lstFailMode.add(objFailureMode);
				distParams = new HashMap<String,String>();
			}

			if (! strDistType.equals(objNxtPartKit.getDistributionType()) || ! partKitId.equals(objNxtPartKit.getPartKitId()) || lastRec) {
				objDistributionType = new DistributionType();
				objDistributionType.setDistributionName(strDistType);
				objDistributionType.setFailureModes(lstFailMode);
				lstDistType.add(objDistributionType);
				lstFailMode = new ArrayList<FailureMode>(ARConstants.INITIAL_ARRAYLIST_SIZE);
			}

			if (! partKitId.equals(objNxtPartKit.getPartKitId()) || lastRec) {
				objPartKit.setDistType(new ArrayList<DistributionType>(ARConstants.INITIAL_ARRAYLIST_SIZE));
				objPartKit.setDistType(lstDistType);
				objFalloutData.getPartKitData().put(partKitId, objPartKit);
				lstDistType = new ArrayList<DistributionType>(ARConstants.INITIAL_ARRAYLIST_SIZE);
			}
		}
	}
	
	List <StepPartKit> stepPartKitList = (List<StepPartKit>)fillStepPartKitList();
	HashMap<String,List<StepPartKit>> stepPartKitMap = new HashMap<String,List<StepPartKit>>();
	if (stepPartKitList != null && stepPartKitList.size() > 0) {
		String firstPartKitId = "";
		StepPartKit stepPartKit = null;
		List<StepPartKit> singleStepPartKit = new ArrayList<StepPartKit>();
		stepPartKit = (StepPartKit) stepPartKitList.get(0);
		firstPartKitId = stepPartKit.getPartKitId();
		for (int i = 0; i < stepPartKitList.size(); i++) {
			stepPartKit = (StepPartKit) stepPartKitList.get(i);
			if (stepPartKit.getPartKitId().equalsIgnoreCase(firstPartKitId)) {
				singleStepPartKit.add(stepPartKit);
			} else {
				stepPartKitMap.put(firstPartKitId, singleStepPartKit);
				singleStepPartKit = new ArrayList<StepPartKit>();
				singleStepPartKit.add(stepPartKit);
				firstPartKitId = stepPartKit.getPartKitId();
			}
		}
		stepPartKitMap.put(firstPartKitId, singleStepPartKit);
	}
	objFalloutData.setStepPartKitData(stepPartKitMap);
	List<PartLimitsVO> foCatPrmLst =  (List<PartLimitsVO>)fillSCatPrmList(partVO);
	if(foCatPrmLst != null && foCatPrmLst.size() > 0){
		HashMap<String, PartLimitsVO> partKitCtlg = new HashMap<String, PartLimitsVO>();
		for(int i = 0; i < foCatPrmLst.size(); i++){
			PartLimitsVO partLimitsVO = foCatPrmLst.get(i);
			partKitCtlg.put(partLimitsVO.getPartKitId(), partLimitsVO);
		}
		objFalloutData.setPartKitLimitData(partKitCtlg);
	}
	//List equipMentList = new ArrayList<Integer>();
	//objFalloutData.setLstFallOutEquip(new ArrayList<Integer>(1,3));

 }

public List<FalloutPart> fillFalloutPart(PartFalloutVO partVO) throws IOException{
	
    List <FalloutPart> l1 = new ArrayList<FalloutPart>();
	FalloutPart part=new FalloutPart(),part1= new FalloutPart();
	part.setPartID("68823531");
	part.setRepairCount("1");
	part.setPartKitId("13035219");
	part.setEventID("707717");
	part.setEquipID("3");
	part.setHoursSinceInstall(partVO.getFhSinceRepair1());
	part.setStartsSinceInstall(partVO.getFsSinceRepair1());
	part.setFFH(partVO.getFhSinceRepair1());
	part.setFFS(partVO.getFsSinceRepair1());
	System.out.println(part.getFFH());
	System.out.println(part.getFFS());
	part1.setPartID("68823531");
	part1.setRepairCount("2");
	part1.setPartKitId("13035219");
	part1.setEventID("707857");
	part1.setEquipID("1");
	part1.setHoursSinceInstall(partVO.getFhSinceRepair2());
	part1.setStartsSinceInstall(partVO.getFsSinceRepair2());
	part1.setFFH(Double.toString((Double.parseDouble(partVO.getFhSinceRepair1())+Double.parseDouble(partVO.getFhSinceRepair2()))));
	part1.setFFS(Double.toString((Double.parseDouble(partVO.getFsSinceRepair1())+Double.parseDouble(partVO.getFsSinceRepair2()))));
	System.out.println(partVO.getFhSinceRepair2());
	System.out.println(partVO.getFsSinceRepair2());
	l1.add(part);l1.add(part1);
	
	return l1;
}

public List<FalloutPartKit> fillFalloutPartKit(PartFalloutVO  partVO) throws IOException{
	
	FalloutPartKit partKit = new FalloutPartKit();
	FalloutPartKit partKit1 = new FalloutPartKit();
	List<FalloutPartKit> lstFalloutPartKit = new ArrayList<FalloutPartKit>();
	partKit.setPartKitId("13035219");
	partKit.setNoOfParts("92");
	partKit.setPartKitRE("0");
	partKit.setPartPrice(partVO.getReplacePrice1());
	partKit.setPartCost(partVO.getReplaceCost1());
	partKit.setDistributionType("STEP");
	partKit.setFailureMode("FFH");
	partKit.setDistributionTypeFunc("Constant");
	partKit.setParamName("Constant");
	partKit.setParamValue("0");
	partKit.setCombineFalloutInd("N");

	lstFalloutPartKit.add(partKit);
	
	partKit1.setPartKitId("13035219");
	partKit1.setNoOfParts("92");
	partKit1.setPartKitRE("0");
	partKit1.setPartPrice(partVO.getReplacePrice2());
	partKit1.setPartCost(partVO.getReplaceCost2());
	partKit1.setDistributionType("STEP");
	partKit1.setFailureMode("FFS");
	partKit1.setDistributionTypeFunc("Constant");
	partKit1.setParamName("Constant");
	partKit1.setParamValue("0");
	partKit1.setCombineFalloutInd("N");

	lstFalloutPartKit.add(partKit1);
	
	return lstFalloutPartKit;
}


public  List<StepPartKit> fillStepPartKitList() throws IOException{
	
  List <StepPartKit> lstStepPartKit = new ArrayList<StepPartKit>();
    //InputStream ExcelFileToRead = new FileInputStream("C:/Projects/ICam/FallOut_17396256.xlsx");
  InputStream ExcelFileToRead = new FileInputStream("src/main/resources/FallOut_17396256.xlsx");
  //InputStream ExcelFileToRead = new FileInputStream("FallOut_17396256.xlsx");
  System.out.println("Get file");
	XSSFWorkbook  wb = new XSSFWorkbook(ExcelFileToRead);
	XSSFSheet sheet = wb.getSheetAt(3);
	XSSFRow row; 
	XSSFCell cell;

	Iterator rows = sheet.rowIterator();
	rows.next();
	while (rows.hasNext())
	{
		row=(XSSFRow) rows.next();
		Iterator cells = row.cellIterator();
		cell=(XSSFCell) cells.next();
		StepPartKit stepPartKitObj = new StepPartKit();
	    stepPartKitObj.setPartKitId(new BigDecimal(cell.getNumericCellValue())+"");
	    cell=(XSSFCell) cells.next();
	    stepPartKitObj.setFailModeName(cell.getStringCellValue()+"");
	    cell=(XSSFCell) cells.next();
	    stepPartKitObj.setRepairCount(cell.getNumericCellValue()+"");
	    cell=(XSSFCell) cells.next();
	    stepPartKitObj.setFalloutPct(cell.getNumericCellValue()+"");
	    cell=(XSSFCell) cells.next();
	    stepPartKitObj.setFactoredValue(cell.getNumericCellValue()+"");
	    System.out.println(stepPartKitObj);
        lstStepPartKit.add(stepPartKitObj);
         
}

	return lstStepPartKit;
}


public List<PartLimitsVO> fillSCatPrmList(PartFalloutVO partVO) throws IOException{
	
	 List <PartLimitsVO> lstPartLimitsVo = new ArrayList<PartLimitsVO>();
	    //InputStream ExcelFileToRead = new FileInputStream("C:/Projects/ICam/FallOut_17396256.xlsx");
	    InputStream ExcelFileToRead = new FileInputStream("src/main/resources/FallOut_17396256.xlsx");
	 //InputStream ExcelFileToRead = new FileInputStream("FallOut_17396256.xlsx");
	    System.out.println("Got file");
	    XSSFWorkbook  wb = new XSSFWorkbook(ExcelFileToRead);
		XSSFSheet sheet = wb.getSheetAt(1);
		XSSFRow row; 
		XSSFCell cell;
		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
		Iterator rows = sheet.rowIterator();
		rows.next();
		while (rows.hasNext())
		{
			row=(XSSFRow) rows.next();
			Iterator cells = row.cellIterator();
			cell=(XSSFCell) cells.next();
			PartLimitsVO repairDetail = new PartLimitsVO();
		  	repairDetail.setEquipId(new BigDecimal(cell.getNumericCellValue())+"");
		  	System.out.println(repairDetail.getEquipId());
		  	cell=(XSSFCell) cells.next();
		  	repairDetail.setPartKitId(new BigDecimal(cell.getNumericCellValue())+"");
			System.out.println(repairDetail.getPartKitId());
			cell=(XSSFCell) cells.next();
			repairDetail.setSectionId((int)cell.getNumericCellValue()+"");
			System.out.println(repairDetail.getSectionId());
			cell=(XSSFCell) cells.next();
			repairDetail.setFalloutThreshold((int)cell.getNumericCellValue()+"");
			System.out.println(repairDetail.getFalloutThreshold());
			cell=(XSSFCell) cells.next();
			repairDetail.setRepairCost(cell.getNumericCellValue()+"");
			System.out.println(repairDetail.getRepairCost());
			cell=(XSSFCell) cells.next();
			repairDetail.setRepairPrice(cell.getNumericCellValue()+"");
			System.out.println(repairDetail.getRepairPrice());
			cell=(XSSFCell) cells.next();
			repairDetail.setReplaceCost(partVO.getReplaceCost1());
			System.out.println(repairDetail.getReplaceCost());
			cell=(XSSFCell) cells.next();  
			repairDetail.setReplacePrice(partVO.getReplacePrice1());
			System.out.println(repairDetail.getReplacePrice());
			cell=(XSSFCell) cells.next();
			repairDetail.setStartDate(formatter.format(cell.getDateCellValue())+"");
			System.out.println(repairDetail.getStartDate());
			cell=(XSSFCell) cells.next();
			repairDetail.setEndDate(formatter.format(cell.getDateCellValue())+"");
			System.out.println(repairDetail.getEndDate());
			lstPartLimitsVo.add(repairDetail);		
    }
		return lstPartLimitsVo;
}
}