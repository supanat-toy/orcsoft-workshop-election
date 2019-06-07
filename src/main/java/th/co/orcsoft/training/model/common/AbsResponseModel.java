package th.co.orcsoft.training.model.common;

public abstract class AbsResponseModel {

	private String statusCode;
	private String statusDescEn;
	private String statusDescTh;

	public AbsResponseModel() {
		this.statusCode = "0";
		this.statusDescEn = "Success";
		this.statusDescTh = "สำเร็จ";
	}

	public AbsResponseModel(String statusCode, String statusDescEn, String statusDescTh) {
		super();
		this.statusCode = statusCode;
		this.statusDescEn = statusDescEn;
		this.statusDescTh = statusDescTh;
	}

	public String getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}

	public String getStatusDescEn() {
		return statusDescEn;
	}

	public void setStatusDescEn(String statusDescEn) {
		this.statusDescEn = statusDescEn;
	}

	public String getStatusDescTh() {
		return statusDescTh;
	}

	public void setStatusDescTh(String statusDescTh) {
		this.statusDescTh = statusDescTh;
	}
}