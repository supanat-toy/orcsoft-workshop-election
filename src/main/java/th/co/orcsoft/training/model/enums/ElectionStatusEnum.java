package th.co.orcsoft.training.model.enums;

// --> centerPoint
//		- confirm -->  createdNew, modified
//		- modify  -->  requestedModification, 
// --> district
//		- status -->  createdNew, modified, requestedModification
//		- modify  --> approvingRequestedModification, rejectingCreatedNew

public enum ElectionStatusEnum { // AprvBy/Flag, Updby/Flag, UpdAprvBy/Flag 
	createdNew(0),  					// null,  true, null -1-
	approvingCreatedNew(1), 			// true,  null, null -2-  no
	rejectingCreatedNew(2),				// false, null, null -3-
	requestedModification(3),			// true,  true, null -4-
	approvingRequestedModification(4), 	// false, null, null -3-
	rejectingRequestedModification(5),	// true,  null, null -2-  no
	modified(6);						// null,  true, null -1-
	
	private int value;
			
	private ElectionStatusEnum(int value) {
		this.value = value;
	}
	
	public int getValue() {
		return this.value;
	}
}
