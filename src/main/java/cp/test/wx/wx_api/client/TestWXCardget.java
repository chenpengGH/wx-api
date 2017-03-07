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
		getCardInfo("pUZWKs7p-pj1vsEKaRViz71pL2oU");
//		getCardInfo("pUZWKs-X7HqzKJVhH53v_zfdqm-E");
//		getCardInfo("pUZWKs4QbnUlWmlxN69Nsex1ZR4c");
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
