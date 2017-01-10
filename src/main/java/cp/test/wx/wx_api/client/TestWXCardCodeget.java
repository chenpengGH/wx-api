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
		codeget("pUZWKs3bF3xMJ0xsfezKH-2voXxQ","7DD8E57E7AB9CB80");
		codeget("pUZWKs3bF3xMJ0xsfezKH-2voXxQ","E567101EA148FA63");
		codeget("pUZWKs5gUFhujxp0GiV9w7LN8ocQ","DF21D9832BF9B8BC");
	}
	
	public static void codeget(String cardId, String code) throws UnsupportedEncodingException {
		String token = ACCESS_TOKEN.access_token;
		
		String url = "https://api.weixin.qq.com/card/code/get?access_token=ACCESS_TOKEN";
		url = url.replace("ACCESS_TOKEN", token);
		
		Map<String, Object> body = new HashMap<String, Object>();
		body.put("card_id", cardId);
		body.put("code", code);
		body.put("check_consume", false);

		String sbody = JsonUtil.getInstance().toJson(body);
		System.out.println(sbody);

		String resultCode = HttpUtil.httpsRequest(url, "POST", sbody);
		resultCode = URLDecoder.decode(resultCode, "UTF-8");
//		resultCode = resultCode.replace("\\/", "\\");
		System.out.println(resultCode);
	}
}
