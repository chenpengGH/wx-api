package cp.test.wx.wx_api.client.model;

import java.io.Serializable;

public class Gift implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 54073686709734680L;

	private String gift;

	private BaseInfo base_info;

	public String getGift() {
		return gift;
	}

	public void setGift(String gift) {
		this.gift = gift;
	}

	public BaseInfo getBase_info() {
		return base_info;
	}

	public void setBase_info(BaseInfo base_info) {
		this.base_info = base_info;
	}

}
