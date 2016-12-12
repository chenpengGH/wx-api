package cp.test.wx.wx_api.client.model;

import java.io.Serializable;

public class TicketResult implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7774248291823013119L;

	private String errcode;
	private String errmsg;
	private String ticket;
	private String url;
	private String show_qrcode_url;
	private long expire_seconds;

	public String getTicket() {
		return ticket;
	}

	public void setTicket(String ticket) {
		this.ticket = ticket;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public long getExpire_seconds() {
		return expire_seconds;
	}

	public void setExpire_seconds(long expire_seconds) {
		this.expire_seconds = expire_seconds;
	}

	public String getErrcode() {
		return errcode;
	}

	public void setErrcode(String errcode) {
		this.errcode = errcode;
	}

	public String getErrmsg() {
		return errmsg;
	}

	public void setErrmsg(String errmsg) {
		this.errmsg = errmsg;
	}

	public String getShow_qrcode_url() {
		return show_qrcode_url;
	}

	public void setShow_qrcode_url(String show_qrcode_url) {
		this.show_qrcode_url = show_qrcode_url;
	}

}
