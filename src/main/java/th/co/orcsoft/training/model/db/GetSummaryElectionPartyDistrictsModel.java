package th.co.orcsoft.training.model.db;

public class GetSummaryElectionPartyDistrictsModel {
	private String ptyName;
	private int mHR;
	private int ptyID;
	private String ptyAbbr;
	private String logo;
	
	public int getPtyID() {
		return ptyID;
	}
	public void setPtyID(int ptyID) {
		this.ptyID = ptyID;
	}
	public String getPtyName() {
		return ptyName;
	}
	public void setPtyName(String ptyName) {
		this.ptyName = ptyName;
	}
	public int getmHR() {
		return mHR;
	}
	public void setmHR(int mHR) {
		this.mHR = mHR;
	}
	public String getPtyAbbr() {
		return ptyAbbr;
	}
	public void setPtyAbbr(String ptyAbbr) {
		this.ptyAbbr = ptyAbbr;
	}
	public String getLogo() {
		return logo;
	}
	public void setLogo(String logo) {
		this.logo = logo;
	}
	
}
