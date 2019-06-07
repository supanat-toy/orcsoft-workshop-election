package th.co.orcsoft.training.model.db;

import java.util.Calendar;

public class NotificationModel {

	private int notfID;
	private String msg;
	private String respPosn;
	private String respBy;
	private Calendar creDTM;
	private int distID;
	private String msgTh;
	
	public int getNotfID() {
		return notfID;
	}
	public void setNotfID(int notfID) {
		this.notfID = notfID;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String getRespPosn() {
		return respPosn;
	}
	public void setRespPosn(String respPosn) {
		this.respPosn = respPosn;
	}
	public String getRespBy() {
		return respBy;
	}
	public void setRespBy(String respBy) {
		this.respBy = respBy;
	}
	public Calendar getCreDTM() {
		return creDTM;
	}
	public void setCreDTM(Calendar creDTM) {
		this.creDTM = creDTM;
	}
	public int getDistID() {
		return distID;
	}
	public void setDistID(int distID) {
		this.distID = distID;
	}
	public String getMsgTh() {
		return msgTh;
	}
	public void setMsgTh(String msgTh) {
		this.msgTh = msgTh;
	}
	
}
