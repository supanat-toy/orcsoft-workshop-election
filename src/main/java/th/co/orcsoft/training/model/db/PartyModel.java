package th.co.orcsoft.training.model.db;

public class PartyModel {

	private int ptyId;
	private String ptyName;
	private String ptyAbbr;
	private String logo;
	private String ptyNameTh;
	private String ptyAbbrTh;

	public int getPtyId() {
		return ptyId;
	}

	public void setPtyId(int ptyId) {
		this.ptyId = ptyId;
	}

	public String getPtyName() {
		return ptyName;
	}

	public void setPtyName(String ptyName) {
		this.ptyName = ptyName;
	}

	public String getPtyAbbr() {
		return ptyAbbr;
	}

	public void setPtyAbbr(String ptyAbbr) {
		this.ptyAbbr = ptyAbbr;
	}

	public String getPtyNameTh() {
		return ptyNameTh;
	}

	public void setPtyNameTh(String ptyNameTh) {
		this.ptyNameTh = ptyNameTh;
	}

	public String getPtyAbbrTh() {
		return ptyAbbrTh;
	}

	public void setPtyAbbrTh(String ptyAbbrTh) {
		this.ptyAbbrTh = ptyAbbrTh;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}
}
