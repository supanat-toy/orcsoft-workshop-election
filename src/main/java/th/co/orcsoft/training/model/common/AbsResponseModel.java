package th.co.orcsoft.training.model.common;

import lombok.Data;

@Data
public abstract class AbsResponseModel {

	private String descriptionEn;
	private String descriptionTh;

	public AbsResponseModel() {
		this.descriptionEn = "";
		this.descriptionTh = "";
	}

	public AbsResponseModel(String descriptionEn, String descriptionTh) {
		super();
		this.descriptionEn = descriptionEn;
		this.descriptionTh = descriptionTh;
	}
}