package cp.test.wx.wx_api;

import cp.test.wx.wx_api.util.JedisUtil;

public interface ACCESS_TOKEN {
	String access_token = JedisUtil.getToken();
}
 