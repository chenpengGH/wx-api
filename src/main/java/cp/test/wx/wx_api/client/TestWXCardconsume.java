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
		cunsume();
	}
	
	public static void cunsume() throws UnsupportedEncodingException {
		String token = ACCESS_TOKEN.access_token;
		
		String url = "https://api.weixin.qq.com/card/consume?access_token=ACCESS_TOKEN";
		url = url.replace("ACCESS_TOKEN", token);
		
		Map<String, String> body = new HashMap<String, String>();
		body.put("card_id", "");
		body.put("code ", "");
		
		String sbody = JsonUtil.getInstance().toJson(body);
		System.out.println(sbody);
		
		String resultCode = HttpUtil.httpsRequest(url, "POST", sbody);
		resultCode = URLDecoder.decode(resultCode, "UTF-8");
//		resultCode = resultCode.replace("\\/", "\\");
		System.out.println(resultCode);
	}
}
