package th.co.orcsoft.training.model.db;

public class GetElectionPartyRegionModel {
	private int rgnID;
	private int ptyID;
	private int mHR;
	private String ptyName;
	private String logo;

	public int getRgnID() {
		return rgnID;
	}

	public void setRgnID(int rgnID) {
		this.rgnID = rgnID;
	}

	public int getPtyID() {
		return ptyID;
	}

	public void setPtyID(int ptyID) {
		this.ptyID = ptyID;
	}

	public int getmHR() {
		return mHR;
	}

	public void setmHR(int mHR) {
		this.mHR = mHR;
	}

	public String getPtyName() {
		return ptyName;
	}

	public void setPtyName(String ptyName) {
		this.ptyName = ptyName;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

}
