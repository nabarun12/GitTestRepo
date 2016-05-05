package data;

import java.io.Serializable;

public class PartFalloutVO  implements Serializable {

	
	private static final long serialVersionUID = 2204997041076994679L;
	
	private String fhSinceRepair1;
	private String fhSinceRepair2;
	private String fsSinceRepair1;
	private String fsSinceRepair2;
	private String replaceCost1;
	private String replaceCost2;
	private String replacePrice1;
	private String replacePrice2;
	public String getFhSinceRepair1() {
		return fhSinceRepair1;
	}
	public void setFhSinceRepair1(String fhSinceRepair1) {
		this.fhSinceRepair1 = fhSinceRepair1;
	}
	public String getFhSinceRepair2() {
		return fhSinceRepair2;
	}
	public void setFhSinceRepair2(String fhSinceRepair2) {
		this.fhSinceRepair2 = fhSinceRepair2;
	}
	public String getFsSinceRepair1() {
		return fsSinceRepair1;
	}
	public void setFsSinceRepair1(String fsSinceRepair1) {
		this.fsSinceRepair1 = fsSinceRepair1;
	}
	public String getFsSinceRepair2() {
		return fsSinceRepair2;
	}
	public void setFsSinceRepair2(String fsSinceRepair2) {
		this.fsSinceRepair2 = fsSinceRepair2;
	}
	public String getReplaceCost1() {
		return replaceCost1;
	}
	public void setReplaceCost1(String replaceCost1) {
		this.replaceCost1 = replaceCost1;
	}
	public String getReplaceCost2() {
		return replaceCost2;
	}
	public void setReplaceCost2(String replaceCost2) {
		this.replaceCost2 = replaceCost2;
	}
	public String getReplacePrice1() {
		return replacePrice1;
	}
	public void setReplacePrice1(String replacePrice1) {
		this.replacePrice1 = replacePrice1;
	}
	public String getReplacePrice2() {
		return replacePrice2;
	}
	public void setReplacePrice2(String replacePrice2) {
		this.replacePrice2 = replacePrice2;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
