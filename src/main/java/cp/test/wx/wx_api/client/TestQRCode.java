package cp.test.wx.wx_api.client;

import java.io.UnsupportedEncodingException;

import cp.test.wx.wx_api.client.model.ActionInfo;
import cp.test.wx.wx_api.client.model.QRCard;
import cp.test.wx.wx_api.client.model.QRCardObject;
import cp.test.wx.wx_api.client.model.TicketResult;
import cp.test.wx.wx_api.util.HttpUtil;
import cp.test.wx.wx_api.util.JsonUtil;

public class TestQRCode {

	public static String createQRCode(String cardId, String code)
			throws UnsupportedEncodingException {

//		String url = "https://api.weixin.qq.com/cgi-bin/qrcode/create?access_token=TOKEN";
		String url = "https://api.weixin.qq.com/card/qrcode/create?access_token=TOKEN";

		QRCardObject object = new QRCardObject();
		QRCard card = new QRCard();
		ActionInfo ai = new ActionInfo();

		card.setCard_id(cardId);
		card.setCode(code);
		card.setIs_unique_code(false);
		card.setOpenid("oUZWKs1rwutJSZmlSe92JdxDssPI");

		ai.setCard(card);
		object.setAction_name("QR_CARD");
		object.setAction_info(ai);

		url = url.replace("TOKEN", "QwJ6i8sNAWw_YGSEqVkSzOYOR8pnDjlPO_OnngWUI1Au1wTG5StPOo7tslpgH_rp51o6xhAw6YKsgcej0fN1GW_mNxdRwRG4FcW8KuUxOG3_juj3zvSj6jedin8QMT5iHFWcADAQOF");
		System.out.println(JsonUtil.getInstance().toJson(object));
		long t1;
		System.out.println(t1 = System.currentTimeMillis());
		String resultCode = HttpUtil.httpsRequest(url, "POST", JsonUtil
				.getInstance().toJson(object));
		System.out.println(System.currentTimeMillis() - t1);

		System.out.println(resultCode);

		TicketResult rs = JsonUtil.getInstance().toBean(resultCode,
				TicketResult.class);

		String result = "https://mp.weixin.qq.com/cgi-bin/showqrcode?ticket="
				+ java.net.URLEncoder.encode(rs.getTicket(), "UTF-8");
		System.out.println(result);
		return result;
	}
	
	public static void main(String[] args) throws UnsupportedEncodingException {
//		String cardId = "pUZWKszRyJMR9LTYjym4Ss_b31sE";
//		String code = "E4DC9F81CCBF0C2E";
		String cardId = "pUZWKs1Z99sOm8ywp-ciXhNNjAcY";
		String code = "D676CDD8280A8D7A";
		String str = createQRCode(cardId, code);
		System.out.println(str);
	}
}
