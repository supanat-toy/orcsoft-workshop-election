package th.co.orcsoft.training.model.db;

import java.sql.Timestamp;
import java.util.Calendar;

public class VoteModel {
	private int distID;
	private int prvID;
	private int distNum;
	private int pty1_ID;
	private int pty1Vote;
	private int pty2_ID;
	private int pty2Vote;
	private int pty3_ID;
	private int pty3Vote;
	private float badVote;
	private float voteNo;
	private Boolean aprvFlag;
	private String aprvBy;
	private Timestamp aprvDTM;
	private Boolean updFlag;
	private String updBy;
	private Timestamp updDTM;
	private Boolean updAprvFlag;
	private String updAprvBy;
	private Timestamp updAprvDTM;
	private int totalVote;
	private int totalValidVote;

	public int getDistID() {
		return distID;
	}

	public void setDistID(int distID) {
		this.distID = distID;
	}

	public int getPrvID() {
		return prvID;
	}

	public void setPrvID(int prvID) {
		this.prvID = prvID;
	}

	public int getDistNum() {
		return distNum;
	}

	public void setDistNum(int distNum) {
		this.distNum = distNum;
	}

	public int getPty1_ID() {
		return pty1_ID;
	}

	public void setPty1_ID(int pty1_ID) {
		this.pty1_ID = pty1_ID;
	}

	public int getPty1Vote() {
		return pty1Vote;
	}

	public void setPty1Vote(int pty1Vote) {
		this.pty1Vote = pty1Vote;
	}

	public int getPty2_ID() {
		return pty2_ID;
	}

	public void setPty2_ID(int pty2_ID) {
		this.pty2_ID = pty2_ID;
	}

	public int getPty2Vote() {
		return pty2Vote;
	}

	public void setPty2Vote(int pty2Vote) {
		this.pty2Vote = pty2Vote;
	}

	public int getPty3_ID() {
		return pty3_ID;
	}

	public void setPty3_ID(int pty3_ID) {
		this.pty3_ID = pty3_ID;
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

	public Boolean isAprvFlag() {
		return aprvFlag;
	}

	public void setAprvFlag(Boolean aprvFlag) {
		this.aprvFlag = aprvFlag;
	}

	public String getAprvBy() {
		return aprvBy;
	}

	public void setAprvBy(String aprvBy) {
		this.aprvBy = aprvBy;
	}

	public Timestamp getAprvDTM() {
		return aprvDTM;
	}

	public void setAprvDTM(Timestamp aprvDTM) {
		this.aprvDTM = aprvDTM;
	}

	public Boolean isUpdFlag() {
		return updFlag;
	}

	public void setUpdFlag(Boolean updFlag) {
		this.updFlag = updFlag;
	}

	public String getUpdBy() {
		return updBy;
	}

	public void setUpdBy(String updBy) {
		this.updBy = updBy;
	}

	public Timestamp getUpdDTM() {
		return updDTM;
	}

	public void setUpdDTM(Timestamp updDTM) {
		this.updDTM = updDTM;
	}

	public Boolean isUpdAprvFlag() {
		return updAprvFlag;
	}

	public void setUpdAprvFlag(Boolean updAprvFlag) {
		this.updAprvFlag = updAprvFlag;
	}

	public String getUpdAprvBy() {
		return updAprvBy;
	}

	public void setUpdAprvBy(String updAprvBy) {
		this.updAprvBy = updAprvBy;
	}

	public Timestamp getUpdAprvDTM() {
		return updAprvDTM;
	}

	public void setUpdAprvDTM(Timestamp updAprvDTM) {
		this.updAprvDTM = updAprvDTM;
	}

	public int getTotalVote() {
		return totalVote;
	}

	public void setTotalVote(int totalVote) {
		this.totalVote = totalVote;
	}

	public int getTotalValidVote() {
		return totalValidVote;
	}

	public void setTotalValidVote(int totalValidVote) {
		this.totalValidVote = totalValidVote;
	}

}
