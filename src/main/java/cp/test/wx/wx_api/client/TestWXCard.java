package cp.test.wx.wx_api.client;

import cp.test.wx.wx_api.ACCESS_TOKEN;
import cp.test.wx.wx_api.client.model.*;
import cp.test.wx.wx_api.util.HttpUtil;
import cp.test.wx.wx_api.util.JsonUtil;
import cp.test.wx.wx_api.util.MD5;

import java.io.UnsupportedEncodingException;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

public class TestWXCard {
	
	interface createGiftCard {
		String logo_url = "logo_url";
		String code_type = "code_type";
		String brand_name = "brand_name";
		String title = "title";
		String Color = "Color";
		String Notice = "Notice";
		String Service_phone = "Service_phone";
		String Source = "Source";
		String Center_title = "Center_title";
		String Center_url = "Center_url";
		String Center_sub_title = "Center_sub_title";
		String Get_limit = "Get_limit";
		String Promotion_url_name = "Promotion_url_name";
		String Promotion_url = "Promotion_url";
		String Promotion_url_sub_title = "Promotion_url_sub_title";
		String Use_custom_code = "Use_custom_code";
		String Bind_openid = "Bind_openid";
		String Can_share = "Can_share";
		String Can_give_friend = "Can_give_friend";
		String Type = "Type";
		String Fixed_term = "Fixed_term";
		String Quantity = "Quantity";
		String Description = "Description";
		String ACCESS_TOKEN = "ACCESS_TOKEN";
	}
	
	public static void main(String[] args) throws Exception {
		createGiftCard();
//		getMilliseconds("2016-08-01 00:00:00");
//		getMilliseconds("2016-12-20 23:59:59");
//		System.out.println(JedisUtil.getToken());
//		getCardInfo("pUZWKswti2feqPGxSs9RrGLu3AdE");
//		System.out.println(JedisUtil.getToken());
//		createQRCode("pUZWKs7GIQjJ8wyPz3PzZtfEVtug");
	 
	}
	 

	public static String createGiftCard()throws Exception{
		
		GiftCardInput input = new GiftCardInput();
		GiftCardObject card = new GiftCardObject();
		
		Gift gift= new Gift();
		card.setCard_type("GIFT");
		
		Map<String, String> params = new HashMap<String, String>();
		params.put(createGiftCard.logo_url, "http://hdcs.orientalwisdom.com/udp/logo/bjyh20151217.jpg");
		params.put(createGiftCard.code_type, "CODE_TYPE_TEXT");
		params.put(createGiftCard.brand_name, "北京银行");
		params.put(createGiftCard.title, "北京银行流量卡");
		params.put(createGiftCard.Color, "Color100");
		params.put(createGiftCard.Notice, "");
		params.put(createGiftCard.Service_phone, "4001076866");
		params.put(createGiftCard.Source, "");
		params.put(createGiftCard.Center_title, "立即充值");
		params.put(createGiftCard.Center_url, "http://card.orientalwisdom.com/udp-auth/cards/exchange");
		params.put(createGiftCard.Center_sub_title, "移动30M/联通50M/电信50M");
//		params.put(createGiftCard.Promotion_url_name, "");
//		params.put(createGiftCard.Promotion_url, "http://card.orientalwisdom.com/udp/cards/CAS");
//		params.put(createGiftCard.Promotion_url_sub_title, "");
		params.put(createGiftCard.Get_limit, "10");
		params.put(createGiftCard.Can_give_friend, "false");
		params.put(createGiftCard.Type, "2");
		params.put(createGiftCard.Fixed_term, "7");
		params.put(createGiftCard.Quantity, "20000");
		params.put(createGiftCard.ACCESS_TOKEN, ACCESS_TOKEN.access_token);
		
		BaseInfo info = new BaseInfo();
		info.setLogo_url(params.get(createGiftCard.logo_url));//need-change
//		info.setLogo_url("http://hdcs.orientalwisdom.com/udp/logo/bjjyxxw20161009.jpg");//need-change 阿里云上上传的logo
		info.setCode_type("CODE_TYPE_TEXT");
		info.setBrand_name(params.get(createGiftCard.brand_name));// 商户名12个字  need-change
		info.setTitle(params.get(createGiftCard.title));// 流量卡名称9个字  need-change
		//info.setSub_title("移动150M/联通200M/电信200M");// 18字
		info.setColor(params.get(createGiftCard.Color));//need-change
		info.setNotice(params.get(createGiftCard.Notice));
		info.setService_phone(params.get(createGiftCard.Service_phone));
		info.setSource(params.get(createGiftCard.Source));
		// info.setUrl_name_type("URL_NAME_TYPE_USE_IMMEDIATELY");
		
		info.setCenter_title(params.get(createGiftCard.Center_title));
		
		System.out.println("http://card.orientalwisdom.com/udp-auth/cards/exchange");
//		info.setCenter_url("http://card.orientalwisdom.com/udp/cards/exchange");// 立即使用对应的url
		info.setCenter_url(params.get(createGiftCard.Center_url));// 新立即使用对应的urll
//		info.setCenter_sub_title("流量币：15枚");// 立即使用边上的提示信息
//		info.setCenter_sub_title("移动10M/联通20M/电信10M");//need-change
		info.setCenter_sub_title(params.get(createGiftCard.Center_sub_title));
//		info.setCenter_sub_title("移动30M/联通50M/电信30M");
//		info.setCenter_sub_title("移动30M/联通50M/电信50M");
//		info.setCenter_sub_title("移动70M/联通50M/电信50M");
//		info.setCenter_sub_title("移动70M/联通100M/电信100M");
//		info.setCenter_sub_title("移动100M/联通100M/电信100M");
//		info.setCenter_sub_title("移动150M/联通200M/电信200M");
//		info.setCenter_sub_title("移动500M/联通500M/电信500M");
//		info.setCenter_sub_title("移动1G/联通1G/电信1G");
//		info.setCenter_sub_title("移动3G/联通1.5G/电信2G");
//		
//		info.setPromotion_url_name(params.get(createGiftCard.Promotion_url_name));// 第二个按钮
//		info.setPromotion_url(params.get(createGiftCard.Promotion_url));// 第二个按钮对应的ulr
//		info.setPromotion_url_sub_title(params.get(createGiftCard.Promotion_url_sub_title));// 第二个按钮的提示信息  need-change
		
		info.setGet_limit(Integer.parseInt(params.get(createGiftCard.Get_limit)));//need-change
		info.setUse_custom_code(true);
		info.setBind_openid(true);
		info.setCan_share(true);
		info.setCan_give_friend(Boolean.parseBoolean(params.get(createGiftCard.Can_give_friend)));// 是否可以转赠  need-change
		DateInfo di = new DateInfo();
//		di.setType(1);// type=1是按固定日期,2是按天算有效期  need-change
//		di.setBegin_timestamp(getMilliseconds("2016-10-10 00:00:00"));//type=1时专用
//		di.setEnd_timestamp(getMilliseconds("2016-12-31 23:59:59"));//type=1时专用
		di.setType(Integer.parseInt(params.get(createGiftCard.Type)));// type=2是按天算有效期,1是按固定日期
		di.setFixed_begin_term(0);//type=2时专用
		di.setFixed_term(Integer.parseInt(params.get(createGiftCard.Fixed_term)));//type=2时专用
		info.setDate_info(di);
		Sku sku = new Sku();
		sku.setQuantity(Integer.parseInt(params.get(createGiftCard.Quantity)));//need-change
		info.setSku(sku);
		System.out.println("=============== 数量= "+sku.getQuantity());
//		info.setDescription("点击卡券上方按钮即可充值，关注流量公社微信公众号进行查询与兑换。\n");
				
		info.setDescription("【转赠】：点击卡券“赠送给朋友”可将卡券转发给微信好友使用。每个用户仅限接收转赠五张本活动流量卡券，超出卡券自动失效。流量充值后卡券转赠无效。\n"
				+ "【充值】：在卡券上方点击“立即充值”后可进入充流量页面，输入手机号码、选择生效时间后点击按钮即充流量。如发现充值失败，请及时联系售后客服。\n"
				+ "【生效时间】：当月生效即实时充值，流量包在本月有效，下月生效会在下个月1日自动为您充值，流量包在下月有效。");
		
		
//		String giftStr = 
//				"1.流量币可以永久存储。\n"
//				+ "2.流量币可随时兑换成流量。\n"
//				+ "3.通过流量币叠加可兑换更多流量。\n";
		
		String giftStr = 
				//"【活动主办】：上融所\n"
				"【使用范围】：全国全网通用\n【使用次数】：本卡券只限充值一次\n【温馨提示】：\n "
				+ "1.全国范围都能订购，在全国范围可以使用，在国际漫游情况下不能使用。\n"
				+ "2.充值成功后会收到短信提醒，目前支持北京移动、中国联通、中国电信的手机用户，非北京移动的用户可登录10086官网查询。\n"
				+ "3.中国联通用户如下可能充值失败：用户状态异常（如号码欠费、业务互斥等）、用户资料不全、被中国联通加入黑名单、用户手机号码没有实名制等情况。\n"
				+ "4.中国电信用户如下可能充值失败：用户状态异常（如号码欠费、业务互斥等）、被中国电信加入黑名单等情况。\n "
				+ "5.中国移动月末2天无法进行充值，中国电信月末3天无法进行充值，中国联通每月每档流量包至多可以充5次。\n"
				+ "6.充值失败后流量卡包仍会返还至您的微信卡包中，建议您选用其他手机号码充值。\n "
				+ "7.虚拟运营商、港澳台地区手机号码暂时无法充值。\n"
				+ "8.如遇其他问题导致充值失败可咨询流量公社微信公众号或流量公社客服电话4001076866。\n";
		
		
		System.out.println("----------"+info.getCenter_sub_title());
		System.out.println("----------"+info.getCenter_sub_title());
		gift.setBase_info(info);
		gift.setGift(giftStr);
		
		card.setGift(gift);
		input.setCard(card);
		 
		String url = "https://api.weixin.qq.com/card/create?access_token=ACCESS_TOKEN";
		url = url.replace("ACCESS_TOKEN", params.get(createGiftCard.ACCESS_TOKEN));
		String resultCode = HttpUtil.httpRequest(url, "POST",
				JsonUtil.getInstance().toJson(input));
		CreateCardResult cardObject = JsonUtil.getInstance().toBean(resultCode, CreateCardResult.class);

		if (cardObject != null && cardObject.getErrcode() == 0) {
			Thread.sleep(3000);
			System.out.println("----card_id========" + cardObject.getCard_id());
//			createQRCode(cardObject.getCard_id());
		}
		return null;
	}


	/**
	 * 
	 * 获取卡券的二维码-码值
	 * 
	 * @author linyaoyao
	 * @version 1.0 </pre> Created on :2015年1月12日 下午3:52:54 LastModified:
	 *          History: </pre>
	 * @throws UnsupportedEncodingException
	 */
	public static String createQRCode(String cardId)
			throws UnsupportedEncodingException {

		String url = "https://api.weixin.qq.com/cgi-bin/qrcode/create?access_token=TOKEN";

		// String cardId = "pUZWKs86RPnBulnn4vPvSTOcqeYg";
		QRCardObject object = new QRCardObject();
		QRCard card = new QRCard();
		ActionInfo ai = new ActionInfo();

		card.setCard_id(cardId);
		card.setCode(MD5.Md5(String.format("%020d", System.nanoTime()))
				.toUpperCase());
		card.setIs_unique_code(false);

		ai.setCard(card);
		object.setAction_name("QR_CARD");
		object.setAction_info(ai);

		url = url.replace("TOKEN", "");
		String resultCode = HttpUtil.httpRequest(url, "POST",
				JsonUtil.getInstance().toJson(object));

		System.out.println(resultCode);

		TicketResult rs = JsonUtil.getInstance().toBean(resultCode, TicketResult.class);
		String result = "https://mp.weixin.qq.com/cgi-bin/showqrcode?ticket="
				+ java.net.URLEncoder.encode(rs.getTicket(), "UTF-8");
		System.out.println(result);
		return result;
	}

	 

	
	/**
	 * 
	 * 获取二维码卡券
	 * 
	 * @param ticket
	 * @return
	 * @author linyaoyao
	 * @version 1.0 </pre> Created on :2015年1月12日 下午3:44:52 LastModified:
	 *          History: </pre>
	 */
	public static String getQR(String ticket) {

		String url = "https://mp.weixin.qq.com/cgi-bin/showqrcode?ticket=TICKET";
		url = url.replace("TICKET", ticket);
		return url;
	}
	
	public static long getMilliseconds(String timeStr){
		Timestamp ts = new Timestamp(System.currentTimeMillis());
//		String timeStr = "2011-05-09 11:49:45";
		try {
			ts = Timestamp.valueOf(timeStr);
			System.out.println("Timestamp------"+ts);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Timestamp--long----"+ts.getTime());
		System.out.println("Timestamp--long/1000----"+ts.getTime()/1000);
		//毫秒转秒
		return ts.getTime()/1000;
	}  

}
