package th.co.orcsoft.training.model.db;

import java.sql.Timestamp;
import lombok.Data;

@Data
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
}
