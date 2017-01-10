package cp.test.wx.wx_api;

import cp.test.sinowel.util.JedisUtil;

public interface ACCESS_TOKEN {
	String access_token = JedisUtil.getToken();
}
 