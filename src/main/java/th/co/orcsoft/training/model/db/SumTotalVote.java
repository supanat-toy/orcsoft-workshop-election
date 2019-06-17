package th.co.orcsoft.training.model.db;

public class SumTotalVote {

	private int ptyID;
	private String ptyName;
	private int totalVote;

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

	public int getTotalVote() {
		return totalVote;
	}

	public void setTotalVote(int totalVote) {
		this.totalVote = totalVote;
	}

}
