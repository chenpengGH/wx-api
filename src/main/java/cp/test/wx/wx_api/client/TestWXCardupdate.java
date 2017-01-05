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
 * 修改卡券信息
 * @author jhc
 *
 */
public class TestWXCardupdate {

	public static void main(String[] args) throws Exception {
		updateCardInfo();
	}
	
	public static void updateCardInfo() throws UnsupportedEncodingException {
		String token = ACCESS_TOKEN.access_token;
		
		String url = "https://api.weixin.qq.com/card/update?access_token=ACCESS_TOKEN";
		url = url.replace("ACCESS_TOKEN", token);
		
		Map<String, Object> body = new HashMap<String, Object>();
		body.put("card_id", "pUZWKszrtMDEM-axuB3PkphbpdPs");
		
		Map<String, Object> member_card = new HashMap<String, Object>();
		Map<String, Object> mainBody = new HashMap<String, Object>();
		mainBody.put("center_sub_title", "移动70M/联通100M/电信100M");
//		mainBody.put("get_limit", 50);
//		mainBody.put("logo_url", "http://hdcs.orientalwisdom.com/udp/logo/tbgx20160216.jpg");
		
		member_card.put("base_info", mainBody);
		body.put("gift", member_card);
		
		String sbody = JsonUtil.getInstance().toJson(body);
		System.out.println(sbody);
		
		String resultCode = HttpUtil.httpsRequest(url, "POST", sbody);
		resultCode = URLDecoder.decode(resultCode, "UTF-8");
		System.out.println(resultCode);
	}
}
