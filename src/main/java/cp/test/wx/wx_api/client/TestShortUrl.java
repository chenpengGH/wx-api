package cp.test.wx.wx_api.client;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

import cp.test.wx.wx_api.ACCESS_TOKEN;
import cp.test.wx.wx_api.util.HttpUtil;
import cp.test.wx.wx_api.util.JsonUtil;


public class TestShortUrl {

	public static String shortUrl(String long_url) throws UnsupportedEncodingException {
		String url = "https://api.weixin.qq.com/cgi-bin/shorturl?access_token=ACCESS_TOKEN";
		
		Map<String, String> body = new HashMap<String, String>();
		body.put("action", "long2short");
		body.put("long_url", long_url);
		
		String sbody = JsonUtil.getInstance().toJson(body);
		System.out.println(sbody);
		
		url = url.replace("ACCESS_TOKEN", ACCESS_TOKEN.access_token);
		String resultCode = HttpUtil.httpsRequest(url, "POST", sbody);
		resultCode = URLDecoder.decode(resultCode, "UTF-8");
		resultCode = resultCode.replace("\\/", "\\");
		System.out.println(resultCode);
		
		return resultCode;
	}
	
	public static void main(String[] args) throws Exception {
		shortUrl("http://hdcs.orientalwisdom.com/udp/bjyh_captcha_160831/judge.html");
	}
}
