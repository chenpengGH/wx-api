package cp.test.wx.wx_api.client.model;

import java.io.Serializable;

public class QRCardObject implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6107685439695469451L;

	private String action_name;
	private int expire_seconds;
	public int getExpire_seconds() {
		return expire_seconds;
	}
	public void setExpire_seconds(int expire_seconds) {
		this.expire_seconds = expire_seconds;
	}
	private ActionInfo action_info;
	public String getAction_name() {
		return action_name;
	}
	public void setAction_name(String action_name) {
		this.action_name = action_name;
	}
	public ActionInfo getAction_info() {
		return action_info;
	}
	public void setAction_info(ActionInfo action_info) {
		this.action_info = action_info;
	}
	
}

 