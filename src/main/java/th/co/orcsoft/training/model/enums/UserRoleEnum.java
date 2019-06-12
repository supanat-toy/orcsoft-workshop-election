package th.co.orcsoft.training.model.enums;

public enum UserRoleEnum {
	officer("Officer"),
	center("Center");
	
	private String value;
			
	private UserRoleEnum(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return this.value;
	}
}
