package th.co.orcsoft.training.model.db;

import lombok.Data;

@Data
public class GetElectionPartyRegionModel {
	private int rgnID;
	private int ptyID;
	private int mHR;
	private String ptyName;
	private String ptyAbbr;
	
}
