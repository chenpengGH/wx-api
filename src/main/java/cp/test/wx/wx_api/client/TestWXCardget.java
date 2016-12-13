package cp.test.wx.wx_api.client;

import cp.test.wx.wx_api.ACCESS_TOKEN;
import cp.test.wx.wx_api.util.HttpUtil;
import cp.test.wx.wx_api.util.JsonUtil;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

/**
 * 微信卡券接口
 * 查询卡券
 * @author jhc
 *
 */
public class TestWXCardget {

	public static void main(String[] args) throws Exception {
		getCardInfo("pUZWKs8QDY8iuYJFpV19NmiMzLnw");
//		getCardInfo("pUZWKs92teC9HZQjDVw7CeVBny2M");
//		getCardInfo("pUZWKs6TYFxhU2IBElqwMVFyvdb0");
	}
	
	public static void getCardInfo(String cardId) throws UnsupportedEncodingException {
		String token = ACCESS_TOKEN.access_token;
		
		String url = "https://api.weixin.qq.com/card/get?access_token=ACCESS_TOKEN";
		url = url.replace("ACCESS_TOKEN", token);
		
		Map<String, String> body = new HashMap<String, String>();
		body.put("card_id", cardId);
		
		String sbody = JsonUtil.getInstance().toJson(body);
		System.out.println(sbody);
		
		String resultCode = HttpUtil.httpsRequest(url, "POST", sbody);
		resultCode = URLDecoder.decode(resultCode, "UTF-8");
//		resultCode = resultCode.replace("\\/", "\\");
		System.out.println(resultCode);
	}
}
