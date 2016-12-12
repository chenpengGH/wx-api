package cp.test.wx.wx_api.client.model;

import java.io.Serializable;

public class DateInfo implements Serializable{
	
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 7117958551954872603L;
	
	private int type ;
	private long begin_timestamp;
	private long end_timestamp;
	private int fixed_begin_term;
	private int fixed_term;
	
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}

	public long getBegin_timestamp() {
		return begin_timestamp;
	}

	public void setBegin_timestamp(long begin_timestamp) {
		this.begin_timestamp = begin_timestamp;
	}

	public long getEnd_timestamp() {
		return end_timestamp;
	}

	public void setEnd_timestamp(long end_timestamp) {
		this.end_timestamp = end_timestamp;
	}
	public int getFixed_begin_term() {
		return fixed_begin_term;
	}
	public void setFixed_begin_term(int fixed_begin_term) {
		this.fixed_begin_term = fixed_begin_term;
	}
	public int getFixed_term() {
		return fixed_term;
	}
	public void setFixed_term(int fixed_term) {
		this.fixed_term = fixed_term;
	}
	
	
	
}
