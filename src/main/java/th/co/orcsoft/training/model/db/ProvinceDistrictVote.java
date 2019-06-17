package th.co.orcsoft.training.model.db;

// select Province.PrvID as provinceId, Province.numDist as numberAllDistricts, Vote.DistNum as voteDistrictNumber
public class ProvinceDistrictVote {
	private int provinceId;
	private int numberAllDistricts;
	private Integer voteDistrictNumber;

	public int getProvinceId() {
		return provinceId;
	}

	public void setProvinceId(int provinceId) {
		this.provinceId = provinceId;
	}

	public int getNumberAllDistricts() {
		return numberAllDistricts;
	}

	public void setNumberAllDistricts(int numberAllDistricts) {
		this.numberAllDistricts = numberAllDistricts;
	}

	public Integer getVoteDistrictNumber() {
		return voteDistrictNumber;
	}

	public void setVoteDistrictNumber(Integer voteDistrictNumber) {
		this.voteDistrictNumber = voteDistrictNumber;
	}

}
