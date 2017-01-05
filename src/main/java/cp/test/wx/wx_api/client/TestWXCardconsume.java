package cp.test.wx.wx_api.client;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

import cp.test.wx.wx_api.ACCESS_TOKEN;
import cp.test.wx.wx_api.client.TestWXCard.createGiftCard;
import cp.test.wx.wx_api.util.HttpUtil;
import cp.test.wx.wx_api.util.JsonUtil;

/**
 * 微信卡券接口
 * 核销卡券接口
 * @author jhc
 *
 */
public class TestWXCardconsume {

	public static void main(String[] args) throws Exception {
//		cunsume("pUZWKs5W1oM5WHqWTzVkLEvxcRvk","BC21C8D48EBADF49");
		cunsume("pUZWKs9EHeIZP4Y8aBVS0EyaG-vo","E92F5CFDAC4C77F0");
	}
	
	public static void cunsume(String cardId, String code) throws UnsupportedEncodingException {
		String token = ACCESS_TOKEN.access_token;
		
		String url = "https://api.weixin.qq.com/card/code/consume?access_token=ACCESS_TOKEN";
		url = url.replace("ACCESS_TOKEN", token);
		
		Map<String, String> body = new HashMap<String, String>();
		body.put("card_id", cardId);
		body.put("code", code);
		
		String sbody = JsonUtil.getInstance().toJson(body);
		System.out.println(sbody);
		
		String resultCode = HttpUtil.httpsRequest(url, "POST", sbody);
		resultCode = URLDecoder.decode(resultCode, "UTF-8");
//		resultCode = resultCode.replace("\\/", "\\");
		System.out.println(resultCode);
	}
}
