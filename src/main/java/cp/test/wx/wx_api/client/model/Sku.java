package cp.test.wx.wx_api.client.model;

import java.io.Serializable;

public class Sku implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1239754971305954806L;
	
	private int quantity;//�ϼܵ�����������֧����д 0 �����޴�

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	

}
