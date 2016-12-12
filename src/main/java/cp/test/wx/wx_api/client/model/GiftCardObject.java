package cp.test.wx.wx_api.client.model;

import java.io.Serializable;

public class GiftCardObject implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4957293139426805024L;
	private String card_type;
	private Gift gift;

	public String getCard_type() {
		return card_type;
	}

	public void setCard_type(String card_type) {
		this.card_type = card_type;
	}

	public Gift getGift() {
		return gift;
	}

	public void setGift(Gift gift) {
		this.gift = gift;
	}

}
