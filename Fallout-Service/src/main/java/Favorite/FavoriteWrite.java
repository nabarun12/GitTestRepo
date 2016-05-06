package Favorite;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import data.FalloutPart;
import data.FinFalloutData;
import data.PartFalloutVO;

public class FavoriteWrite {

	public void processOutputFallOutData(PartFalloutVO partVO) throws IOException{
		fillOutCSVWithInputData(partVO);
		
		
	}

	
	public void fillOutCSVWithInputData(PartFalloutVO objFalloutData) throws IOException{
		
		FileWriter  pw = new FileWriter("src/main/resources/Favorites.csv",true);
		pw.append(objFalloutData.getFhSinceRepair1());
	    pw.append(',');
	    pw.append(objFalloutData.getFsSinceRepair1());
	    pw.append(',');
	    pw.append(objFalloutData.getFhSinceRepair2());
	    pw.append(',');
	    pw.append(objFalloutData.getFsSinceRepair2());
	    pw.append(',');
	    pw.append(objFalloutData.getReplaceCost1());
	    pw.append(',');
	    pw.append(objFalloutData.getReplacePrice1());
	    pw.append(',');
	    pw.append(objFalloutData.getReplaceCost2());
	    pw.append(',');
	    pw.append(objFalloutData.getReplacePrice2());
	    pw.append(',');
	    pw.append(objFalloutData.getFallOutPercentage());
	    pw.append(',');
	    pw.append(objFalloutData.getFallOutCost());
	    pw.append(',');
	    pw.append("\n");
	    pw.close(); 
	}
}
