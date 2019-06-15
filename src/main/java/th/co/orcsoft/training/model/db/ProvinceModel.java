package th.co.orcsoft.training.model.db;

public class ProvinceModel {

	private int prvID;
	private int rgnID;
	private String prvName;
	private int numDist;
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

	public int getNumDist() {
		return numDist;
	}

	public void setNumDist(int numDist) {
		this.numDist = numDist;
	}

	public String getPrvNameTh() {
		return prvNameTh;
	}

	public void setPrvNameTh(String prvNameTh) {
		this.prvNameTh = prvNameTh;
	}

}
