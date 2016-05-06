package Favorite;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import data.PartFalloutVO;

public class FavoriteRead {



	public  PartFalloutVO readFromCSV() throws IOException{
		
		String csvFile = "src/main/resources/Favorites.csv";
		BufferedReader br = null;
		String line = "";
		String cvsSplitBy = ",";	
		PartFalloutVO partFalloutData=new PartFalloutVO();
		
		
            br = new BufferedReader(new FileReader(csvFile));
			while ((line = br.readLine()) != null) {
                String[] fall_out = line.split(cvsSplitBy);
                partFalloutData=new PartFalloutVO();
                partFalloutData.setFhSinceRepair1(fall_out[0]);
				partFalloutData.setFsSinceRepair1(fall_out[1]);
				partFalloutData.setFhSinceRepair2(fall_out[2]);
				partFalloutData.setFsSinceRepair2(fall_out[3]);
				partFalloutData.setReplaceCost1(fall_out[4]);
				partFalloutData.setReplacePrice1(fall_out[5]);
				partFalloutData.setReplaceCost2(fall_out[6]);
				partFalloutData.setReplacePrice2(fall_out[7]);
				partFalloutData.setFallOutPercentage(fall_out[8]);
				partFalloutData.setFallOutCost(fall_out[9]);
		
	   
	}
	br.close();
	return partFalloutData;
  }	

}
