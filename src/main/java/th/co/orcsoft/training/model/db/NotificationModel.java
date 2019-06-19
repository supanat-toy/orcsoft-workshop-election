package th.co.orcsoft.training.model.db;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class NotificationModel {

	private int notfID;
	private String msg;
	private String respPosn;
	private String respBy;
	private Timestamp creDTM;
	private int distID;
	private String msgTh;
	
}
