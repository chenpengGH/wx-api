package cp.test.wx.wx_api.client.model;

import java.io.Serializable;

public class GiftCardInput implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2434789983629510953L;

	private GiftCardObject card;

	public GiftCardObject getCard() {
		return card;
	}

	public void setCard(GiftCardObject card) {
		this.card = card;
	}

}
