package th.co.orcsoft.training.model.db;

public class ProvinceModel {
	
	private int prvID;
	private int rgnID;
	private String prvName;
	private int nameDist;
	private String prvNameTh;
	
	public int getPrvID() {
		return prvID;
	}
	public void setPrvID(int prvID) {
		this.prvID = prvID;
	}
	public int getRgnID() {
		return rgnID;
	}
	public void setRgnID(int rgnID) {
		this.rgnID = rgnID;
	}
	public String getPrvName() {
		return prvName;
	}
	public void setPrvName(String prvName) {
		this.prvName = prvName;
	}
	public int getNameDist() {
		return nameDist;
	}
	public void setNameDist(int nameDist) {
		this.nameDist = nameDist;
	}
	public String getPrvNameTh() {
		return prvNameTh;
	}
	public void setPrvNameTh(String prvNameTh) {
		this.prvNameTh = prvNameTh;
	}
	
}
