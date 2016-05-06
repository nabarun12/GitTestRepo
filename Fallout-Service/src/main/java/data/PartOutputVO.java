package data;

import java.io.Serializable;

public class PartOutputVO  implements Serializable {

	
	private static final long serialVersionUID = 2204997041076994679L;
	
	
	private String fallOutPercentage;
	private String fallOutCost;
	public String getFallOutCost() {
		return fallOutCost;
	}
	public void setFallOutCost(String fallOutCost) {
		this.fallOutCost = fallOutCost;
	}
	public String getFallOutPercentage() {
		return fallOutPercentage;
	}
	public void setFallOutPercentage(String fallOutPercentage) {
		this.fallOutPercentage = fallOutPercentage;
	}
	
}
