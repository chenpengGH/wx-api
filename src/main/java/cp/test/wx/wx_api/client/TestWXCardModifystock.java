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
 * 更改卡券库存
 * @author jhc
 *
 */
public class TestWXCardModifystock {

	public static void main(String[] args) throws Exception {
		modifystock();
	}
	
	public static void modifystock() throws UnsupportedEncodingException {
		String token = ACCESS_TOKEN.access_token;
		
		String url = "https://api.weixin.qq.com/card/modifystock?access_token=ACCESS_TOKEN";
		url = url.replace("ACCESS_TOKEN", token);
		
		Map<String, Object> body = new HashMap<String, Object>();
		body.put("card_id", "pUZWKs7tmNOfeOSAwgnyklUzqKmc");
		body.put("increase_stock_value", 1725);  // 增加库存
//		body.put("reduce_stock_value", 100);    // 减少库存
		
		String sbody = JsonUtil.getInstance().toJson(body);
		System.out.println(sbody);
		
		String resultCode = HttpUtil.httpsRequest(url, "POST", sbody);
		resultCode = URLDecoder.decode(resultCode, "UTF-8");
//		resultCode = resultCode.replace("\\/", "\\");
		System.out.println(resultCode);
	}
}
