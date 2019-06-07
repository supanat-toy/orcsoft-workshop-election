package th.co.orcsoft.training.model.db;

import java.util.Calendar;

public class VoteModel {
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
	private boolean AprvFlag;
	private String AprvBy;
	private Calendar AprvDTM;
	private boolean UpdFlag;
	private String UpdBy;
	private Calendar UpdDTM;
	private boolean UpdAprvFlag;
	private String UpdAprvBy;
	private Calendar UpdAprvDTM;
	private int TotalVote;
	private int TotalValidVote;
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
	public boolean isAprvFlag() {
		return AprvFlag;
	}
	public void setAprvFlag(boolean aprvFlag) {
		AprvFlag = aprvFlag;
	}
	public String getAprvBy() {
		return AprvBy;
	}
	public void setAprvBy(String aprvBy) {
		AprvBy = aprvBy;
	}
	public Calendar getAprvDTM() {
		return AprvDTM;
	}
	public void setAprvDTM(Calendar aprvDTM) {
		AprvDTM = aprvDTM;
	}
	public boolean isUpdFlag() {
		return UpdFlag;
	}
	public void setUpdFlag(boolean updFlag) {
		UpdFlag = updFlag;
	}
	public String getUpdBy() {
		return UpdBy;
	}
	public void setUpdBy(String updBy) {
		UpdBy = updBy;
	}
	public Calendar getUpdDTM() {
		return UpdDTM;
	}
	public void setUpdDTM(Calendar updDTM) {
		UpdDTM = updDTM;
	}
	public boolean isUpdAprvFlag() {
		return UpdAprvFlag;
	}
	public void setUpdAprvFlag(boolean updAprvFlag) {
		UpdAprvFlag = updAprvFlag;
	}
	public String getUpdAprvBy() {
		return UpdAprvBy;
	}
	public void setUpdAprvBy(String updAprvBy) {
		UpdAprvBy = updAprvBy;
	}
	public Calendar getUpdAprvDTM() {
		return UpdAprvDTM;
	}
	public void setUpdAprvDTM(Calendar updAprvDTM) {
		UpdAprvDTM = updAprvDTM;
	}
	public int getTotalVote() {
		return TotalVote;
	}
	public void setTotalVote(int totalVote) {
		TotalVote = totalVote;
	}
	public int getTotalValidVote() {
		return TotalValidVote;
	}
	public void setTotalValidVote(int totalValidVote) {
		TotalValidVote = totalValidVote;
	}
}
