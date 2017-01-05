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
 * 查询卡券状态借口
 * @author jhc
 *
 */
public class TestWXCardCodeget {

	public static void main(String[] args) throws Exception {
		codeget("pUZWKs9EHeIZP4Y8aBVS0EyaG-vo","E92F5CFDAC4C77F0");
		codeget("pUZWKs9EHeIZP4Y8aBVS0EyaG-vo","7590A0CAECD69E33");
	}
	
	public static void codeget(String cardId, String code) throws UnsupportedEncodingException {
		String token = ACCESS_TOKEN.access_token;
		
		String url = "https://api.weixin.qq.com/card/code/get?access_token=ACCESS_TOKEN";
		url = url.replace("ACCESS_TOKEN", token);
		
		Map<String, Object> body = new HashMap<String, Object>();
		body.put("card_id", cardId);
		body.put("code", code);
		body.put("check_consume", true);

		String sbody = JsonUtil.getInstance().toJson(body);
		System.out.println(sbody);

		String resultCode = HttpUtil.httpsRequest(url, "POST", sbody);
		resultCode = URLDecoder.decode(resultCode, "UTF-8");
//		resultCode = resultCode.replace("\\/", "\\");
		System.out.println(resultCode);
	}
}
