package th.co.orcsoft.training.model.db;
import lombok.Data;

// select Province.PrvID as provinceId, Province.numDist as numberAllDistricts, Vote.DistNum as voteDistrictNumber
@Data
public class ProvinceDistrictVote {
	private int provinceId;
	private int numberAllDistricts;
	private Integer voteDistrictNumber;

}
