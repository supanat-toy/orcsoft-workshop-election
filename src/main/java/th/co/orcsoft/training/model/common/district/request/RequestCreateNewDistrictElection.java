package th.co.orcsoft.training.model.common.district.request;

import java.sql.Timestamp;

public class RequestCreateNewDistrictElection {
	private int prvId;
	private int distNum;
	private int pty1Id;
	private int pty1Vote;
	private int pty2Id;
	private int pty2Vote;
	private int pty3Id;
	private int pty3Vote;
	private float badVote;
	private float voteNo;
	public int getPrvId() {
		return prvId;
	}
	public void setPrvId(int prvId) {
		this.prvId = prvId;
	}
	public int getDistNum() {
		return distNum;
	}
	public void setDistNum(int distNum) {
		this.distNum = distNum;
	}
	public int getPty1Id() {
		return pty1Id;
	}
	public void setPty1Id(int pty1Id) {
		this.pty1Id = pty1Id;
	}
	public int getPty1Vote() {
		return pty1Vote;
	}
	public void setPty1Vote(int pty1Vote) {
		this.pty1Vote = pty1Vote;
	}
	public int getPty2Id() {
		return pty2Id;
	}
	public void setPty2Id(int pty2Id) {
		this.pty2Id = pty2Id;
	}
	public int getPty2Vote() {
		return pty2Vote;
	}
	public void setPty2Vote(int pty2Vote) {
		this.pty2Vote = pty2Vote;
	}
	public int getPty3Id() {
		return pty3Id;
	}
	public void setPty3Id(int pty3Id) {
		this.pty3Id = pty3Id;
	}
	public int getPty3Vote() {
		return pty3Vote;
	}
	public void setPty3Vote(int pty3Vote) {
		this.pty3Vote = pty3Vote;
	}
	public float getBadVote() {
		return badVote;
	}
	public void setBadVote(float badVote) {
		this.badVote = badVote;
	}
	public float getVoteNo() {
		return voteNo;
	}
	public void setVoteNo(float voteNo) {
		this.voteNo = voteNo;
	}
	
	
}
