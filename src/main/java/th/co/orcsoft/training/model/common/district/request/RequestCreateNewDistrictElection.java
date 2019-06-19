package th.co.orcsoft.training.model.common.district.request;

import lombok.Data;

@Data
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
	
}
