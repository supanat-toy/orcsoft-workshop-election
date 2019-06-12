package th.co.orcsoft.training.model.db;

import java.sql.Timestamp;

public class GetElectionPartyDistrictsModel {
	private int DistID;
	private int PrvID;
	private int DistNum;
	private int Pty1_ID;
	private int Pty1Vote;
	private int Pty2_ID;
	private int Pty2Vote;
	private int Pty3_ID;
	private int Pty3Vote;
	private float BadVote;
	private float VoteNo;
	
	//add column for getName and Logo
	private String pty1_Name;
	private String pty1_Logo;
	private String pty2_Name;
	private String pty2_Logo;
	private String pty3_Name;
	private String pty3_Logo;
	
	public int getDistID() {
		return DistID;
	}
	public void setDistID(int distID) {
		DistID = distID;
	}
	public int getPrvID() {
		return PrvID;
	}
	public void setPrvID(int prvID) {
		PrvID = prvID;
	}
	public int getDistNum() {
		return DistNum;
	}
	public void setDistNum(int distNum) {
		DistNum = distNum;
	}
	public int getPty1_ID() {
		return Pty1_ID;
	}
	public void setPty1_ID(int pty1_ID) {
		Pty1_ID = pty1_ID;
	}
	public int getPty1Vote() {
		return Pty1Vote;
	}
	public void setPty1Vote(int pty1Vote) {
		Pty1Vote = pty1Vote;
	}
	public int getPty2_ID() {
		return Pty2_ID;
	}
	public void setPty2_ID(int pty2_ID) {
		Pty2_ID = pty2_ID;
	}
	public int getPty2Vote() {
		return Pty2Vote;
	}
	public void setPty2Vote(int pty2Vote) {
		Pty2Vote = pty2Vote;
	}
	public int getPty3_ID() {
		return Pty3_ID;
	}
	public void setPty3_ID(int pty3_ID) {
		Pty3_ID = pty3_ID;
	}
	public int getPty3Vote() {
		return Pty3Vote;
	}
	public void setPty3Vote(int pty3Vote) {
		Pty3Vote = pty3Vote;
	}
	public float getBadVote() {
		return BadVote;
	}
	public void setBadVote(float badVote) {
		BadVote = badVote;
	}
	public float getVoteNo() {
		return VoteNo;
	}
	public void setVoteNo(float voteNo) {
		VoteNo = voteNo;
	}
	public String getPty1_Name() {
		return pty1_Name;
	}
	public void setPty1_Name(String pty1_Name) {
		this.pty1_Name = pty1_Name;
	}
	public String getPty1_Logo() {
		return pty1_Logo;
	}
	public void setPty1_Logo(String pty1_Logo) {
		this.pty1_Logo = pty1_Logo;
	}
	public String getPty2_Name() {
		return pty2_Name;
	}
	public void setPty2_Name(String pty2_Name) {
		this.pty2_Name = pty2_Name;
	}
	public String getPty2_Logo() {
		return pty2_Logo;
	}
	public void setPty2_Logo(String pty2_Logo) {
		this.pty2_Logo = pty2_Logo;
	}
	public String getPty3_Name() {
		return pty3_Name;
	}
	public void setPty3_Name(String pty3_Name) {
		this.pty3_Name = pty3_Name;
	}
	public String getPty3_Logo() {
		return pty3_Logo;
	}
	public void setPty3_Logo(String pty3_Logo) {
		this.pty3_Logo = pty3_Logo;
	}

	
}
