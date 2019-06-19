package th.co.orcsoft.training.model.db;

import lombok.Data;

@Data
public class GetElectionPartyDistrictsModel extends VoteModel {
	private String pty1_Name;
	private String pty2_Name;
	private String pty3_Name;
	
}
