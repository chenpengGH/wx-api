/**
 * ProjectName: udp 
 * Package:  com.sinowel.wechat.activity.qrcode
 * FileName: CreateSceneQRCode.java
 * @version 1.0
 * @author langkai
 * @created on 2016年8月18日
 * Copyright (c) 2016 SINOWEL. All Rights Reserved.
 */
package cp.test.wx.wx_api.client;

import com.aliyun.oss.OSSClient;
import cp.test.wx.wx_api.ACCESS_TOKEN;
import cp.test.wx.wx_api.util.HttpUtil;
import cp.test.wx.wx_api.util.JsonUtil;
import cp.test.wx.wx_api.util.QRCodeUtil;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Map;

/**
 *  创建二维码，并上传到OSS<br>
 *  
 *  二维码文件名格式：<br>
 *  流量充值：[activityCode]_flowRecharge<br>
 *  卡转币：[activityCode]_cardToCoin<br>
 *  客服：[activityCode]_customService<br>
 *  
 *  @author langkai
 *  @version 1.0
 *  </pre>
 *  Created on :上午10:04:51
 *  LastModified:
 *  History:
 *  </pre>
 */
public class TestCreateSceneQRCode {
	
	/**
	 * 阿里云ACCESS_ID
	 */
	private static String ACCESS_ID = "dIypSMnlEIlS9EW1";
	/**
	 * 阿里云ACCESS_KEY
	 */
	private static String ACCESS_KEY = "GqvvCwy30rXItSI9s52fME8vCN9YgT";
	/**
	 * 阿里云OSS_ENDPOINT 北京Url
	 */
	private static String OSS_ENDPOINT = "http://oss-cn-beijing.aliyuncs.com/";

	/**
	 * 阿里云BUCKET_NAME OSS
	 */
	private static String BUCKET_NAME = "udp-oss";
	/**
	 * 阿里云BUCKET 指定目录
	 */
	private static String BUCKET_PATH = "qrcode_subscribe/";

	/**
	 * 流量充值
	 */
	private static String FLOW_RECHARGE = "flowRecharge";
	/**
	 * 卡转币
	 */
	private static String CARD_TO_COIN = "cardToCoin";
	/**
	 * 客服
	 */
	private static String CUSTOM_SERVICE = "customService";
	

	private HttpClientBuilder httpsClientBuilder;

	public static void main(String[] args) {
		TestCreateSceneQRCode create = new TestCreateSceneQRCode();
		
		// ********************* 【必填】 START ***********************
		String activityCode = "BANKOFBJ_161213";
		String token = ACCESS_TOKEN.access_token;
		
		// ********************* 【必填】  END ***********************
		
		// 永久二维码场景，流量充值，卡转币，客服``
		String[] sceneArr = new String[]{FLOW_RECHARGE, CARD_TO_COIN, CUSTOM_SERVICE};
		for (String scene : sceneArr) {
			System.out.println(scene + "============== START ==============");
			// 创建二维码，并上传到OSS
			create.uploadQRCode2OSS4ByteArr(activityCode, scene, token);
			System.out.println(scene + "============== END ==============");
		}
		
//		create.multiActivityCode();
	}
	
	private void multiActivityCode() {
		String[] acArr = new String[]{
				"BOC_BUY",
				"ARJR_150805",
				"ARJR_150918",
				"GTJA_151209",
				"NESC_150814",
				"NESC_151221",
				"SINOWEL-100M",
				"SINOWEL-TEST",
				"BOC-BJ_150825",
				"DCFUND_151207",
				"GTFUND_150630",
				"GTFUND_150909",
				"GTFUND_151210",
				"HSBCJT_151209",
				"PY-AXA_150824",
				"PY-AXA_150914",
				"SINOWEL-JHLLT",
				"SINOWEL-SALES",
				"CINDASC_150713",
				"CPIC-SX_150806",
				"JSHBANK_151208",
				"LCFUNDS_150916",
				"MFCTEDA_150707",
				"MFCTEDA_150721",
				"MFCTEDA_150826",
				"MFCTEDA_150915",
				"MFCTEDA_150916",
				"MFCTEDA_151013",
				"MFCTEDA_151014",
				"MFCTEDA_151023",
				"SINOWEL_151201",
				"BANKOFBJ_150601",
				"BANKOFBJ_150924",
				"BANKOFBJ_151113",
				"CCB-AHZH_150708",
				"CCB-ZHBF-150417",
				"CCB-ZHBF-150630",
				"CJHXFUND_151203",
				"CMFCHINA_150922",
				"GTFUND-1_151113",
				"GTFUND-2_151113",
				"HRXJBANK_150928",
				"ICBC-AXA_150720",
				"ZRB-KKWL_150707",
				"BOC-BJ_0211-0228",
				"CHINALIFE-P_0315",
				"CNTAIPING_150910",
				"ECPIC-HYX_150806",
				"GREATLIFE_150713",
				"SINOWEL-STANDARD",
				"BESTWEALTH_150805",
				"BESTWEALTH_151118",
				"BESTWEALTH_151221",
				"CINDASC_0216-0218",
				"CINDASC_0219-0225",
				"CPIC-CX-SD_150918",
				"CPIC-CX-SD_150921",
				"CPIC-CX-SD_151022",
				"CPIC-CX-SD_151207",
				"HRXJBANK-1_150625",
				"HRXJBANK-2_150625",
				"HRXJBANK-3_150625",
				"HRXJBANK-4_150625",
				"INGBOBLIFE-150615",
				"INGBOBLIFE-150814",
				"INGBOBLIFE-151015",
				"SINOWEL-BJYH-TEST",
				"SINOWEL-GSTJ-TEST",
				"SINOWEL-TEST-ARJR",
				"SINOWEL-TEST-GSCX",
				"SINOWEL-TEST-MIGU",
				"SINOWEL-TEST-NTES",
				"SINOWEL-TEST-TBBX",
				"SINOWEL-TEST-XHBX",
				"SINOWEL-TEST-ZC-1",
				"SINOWEL-TEST-ZC-2",
				"SINOWEL-TEST-ZC-3",
				"SINOWEL-ZHBF-TEST",
				"CHINALIFE-P_151019",
				"GREATLIFE-1-150601",
				"GREATLIFE-2-150601",
				"SINOWEL-SALES-LEAD",
				"CHINALIFE-DS_151120",
				"CNTAIPING-CP_150930",
				"FRANSHION-HZ_150826",
				"GREATLIFE-GX_150812",
				"NEWCHINALIFE_151020",
				"SINOWEL-GTFUND-TEST",
				"SINOWEL-TEST-BOC-BJ",
				"SINOWEL-TEST-HRXJ-1",
				"SINOWEL-TEST-HRXJ-2",
				"SINOWEL-TEST-HRXJ-3",
				"SINOWEL-TEST-HRXJ-4",
				"SINOWEL-TEST-HSBANK",
				"SINOWEL-TEST_151113",
				"SINOWEL_COIN_160407",
				"SINOLWEL_TEST_160107",
				"SINOWEL-TEST-CINDASC",
				"SINOWEL-TEST-TENCENT",
				"CHINALIFE-GSTJ-150526",
				"CNTAIPING_self_150925",
				"CPIC-CX-SD_self_150918",
				"SINOWEL-CCB-AHWJR-TEST",
				"SINOWEL-GREATLIFE-TEST",
				"SINOWEL-MFCTEDA-1-TEST",
				"SINOWEL-TEST-ECPIC-HYX",
				"SINOWEL-TEST-MFCTEDA-2",
				"CPIC-CX-SD_STAFF_151013",
				"SINOWEL-INGBOBLIFE-TEST",
				"SINOWEL-TEST-CHINANATURE",
				"MFCTEDA_150824",
				"CPIC-CX-SD_150901",
				"GTFUND_150906",
				"HFTFUND-1_150907",
				"HFTFUND-2_150907",
				"CMFCHINA-1_150909",
				"CMFCHINA-2_150909",
				"CMFCHINA_151027",
				"MFCTEDA_151027",
				"PFLIFE-151027",
				"GIVEU-151029",
				"CCB-BJFH_151103",
				"51FUND_151103",
				"BANKOFBJ_151109",
				"NEWCHINALIFE_151110",
				"GREATLIFE-SD_151111",
				"BOCIM_151117",
				"51FUND_151120",
				"MFCTEDA_151120",
				"HSBCJT_151123",
				"CMFCHINA_151207",
				"CMFCHINA_151211",
				"BANKOFBJ_151217",
				"SCZQ_151217",
				"CPIC-CX-SD_151221",
				"BANKOFBJ_151222",
				"GJZQ_151222",
				"HRXJBANK_151222",
				"HSBCJT_151222",
				"SINOWEL_151225",
				"CPIC-CX-SD_151228",
				"HTCXFUND_151229",
				"FUNDINS_151230",
				"SCZQ_160107",
				"CNTAIPING_160113",
				"UBSSDIC_160114",
				"HTSC_160119",
				"CPIC-CX-SD_160125",
				"NESC_160126",
				"HRXJBANK-B_160126",
				"GJZQ_160126",
				"CPIC-CX-SD_160126",
				"ICBCCS_160129",
				"51WOFANG_160202",
				"CCB-BJFH_160202",
				"163-CP_160203",
				"CPIC-CX-GX_160216",
				"ZRFUNDS_160216",
				"BESTWEALTH_160302",
				"ICBCCS_160303",
				"CPIC-CX-SD_160308",
				"ZRFUNDS_160308",
				"GUOSEN-BJ_160308",
				"163-CP_160308",
				"SRPAX_160311",
				"BESTWEALTH_160316",
				"ICBCCS_160318",
				"163-CP_160321",
				"BESTWEALTH_160331",
				"ICBCCS_160331",
				"163-CP_160406",
				"HUIYI_160408",
				"CNTAIPING-BGS_160413",
				"GTFUND_160418",
				"CHINALIFE-SZ_160418",
				"ICBCCS_160418",
				"NESC_160418",
				"CNTAIPING-BGS_160419",
				"163-CP_160420",
				"ICBCCS_160420",
				"MFCTEDA_160422",
				"CPIC-CX-SD_160422",
				"XYB100_160427",
				"BANKOFBJ_160427",
				"NESC_160503",
				"ICBCCS_160504",
				"BESTWEALTH_160504",
				"BESTWEALTH-WY_160504",
				"CPIC-CX-GX_160506",
				"GUOSEN-BJ_160509",
				"BESTWEALTH_160509",
				"HSBANK_160511",
				"ICBCCS_160516",
				"BOC-BJFH_160516",
				"ICBCCS_160517"
//				"GREATLIFE_160523",
//				"GUOSEN-BJ_160523",
//				"163-CP_160525",
//				"CNTAIPING_160526",
//				"CPIC-CX-SD_160530",
//				"BANKOFBJ_160531",
//				"CNTAIPING-CP_160531",
//				"CPIC-CX-GX_160603",
//				"CPIC-CX-GX_16060302",
//				"ABC-LIFE_160607",
//				"CHINALIFE-YLBX_160608",
//				"ABC-LIFE_160612",
//				"SOFTEMBED_160612",
//				"GTFUND_160614",
//				"MS-SECURITIES_160615",
//				"ICBCCS_160621",
//				"DH-SECURITIES_160627",
//				"GJZQ_160701",
//				"JINBANK_160707",
//				"GJZQ_160707",
//				"MFCTEDA-B_160718",
//				"GJZQ_160718",
//				"ICBC-AXA_160719",
//				"ICBCCS_160725",
//				"BANKOFBJ_160728",
//				"GJZQZG_160802",
//				"CNTAIPING_160802",
//				"GJZQ_16080501",
//				"GJZQ_16080502",
//				"CPIC-CX-SD_160808",
//				"GTFUND_160809",
//				"ICBCCS_160810",
//				"HAPPYLIFE_160811",
//				"UBSSDIC_160816",
//				"SINOWEL_160819"
				};
		String token = "";
		for (String activityCode : acArr) {
			// 永久二维码场景，流量充值，卡转币，客服
			String[] sceneArr = new String[]{FLOW_RECHARGE, CARD_TO_COIN, CUSTOM_SERVICE};
			for (String scene : sceneArr) {
				System.out.println(scene + "============== START ==============");
				// 创建二维码，并上传到OSS
				this.uploadQRCode2OSS4ByteArr(activityCode, scene, token);
				System.out.println(scene + "============== END ==============");
			}
		}
	}

	private void uploadQRCode2OSS4ByteArr(String activityCode, String scene, String token) {
		String scene_str = activityCode + "_" + scene;
		String fileNameQRCode = BUCKET_PATH + scene_str + ".jpg";
		
		// 创建永久二维码
		String url = "https://api.weixin.qq.com/cgi-bin/qrcode/create?access_token=" + token;
		String jsonData = "{\"action_name\": \"QR_LIMIT_STR_SCENE\", \"action_info\": {\"scene\": {\"scene_str\": \""+ scene_str +"\"}}}";
		String data = HttpUtil.httpsRequest(url, "POST", jsonData);
		System.out.println(data);

		@SuppressWarnings("unchecked")
		Map<String, String> map = (Map<String, String>)JsonUtil.toMap(data);
		
		// 创建OSSClient实例
		OSSClient ossClient = new OSSClient(OSS_ENDPOINT, ACCESS_ID, ACCESS_KEY);
		try {
			byte[] content = QRCodeUtil.createQRCode(map.get("url"));
			ossClient.putObject(BUCKET_NAME, fileNameQRCode, new ByteArrayInputStream(content));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (ossClient != null) {
				// 关闭client
				ossClient.shutdown();
			}
		}
	}

	private void uploadQRCode2OSS4Stream(String activityCode, String scene, String token) {
		String scene_str = activityCode + "_" + scene;
		String fileNameQRCode = BUCKET_PATH + scene_str + ".jpg";
		
		// 创建永久二维码
		String url = "https://api.weixin.qq.com/cgi-bin/qrcode/create?access_token=" + token;
		String jsonData = "{\"action_name\": \"QR_LIMIT_STR_SCENE\", \"action_info\": {\"scene\": {\"scene_str\": \""+ scene_str +"\"}}}";
		String data = HttpUtil.httpsRequest(url, "POST", jsonData);
		System.out.println(data);

		String ticket = null;
		try {
			@SuppressWarnings("unchecked")
			Map<String, String> map = (Map<String, String>)JsonUtil.toMap(data);
			ticket = java.net.URLEncoder.encode(map.get("ticket"), "UTF-8");
			System.out.println(ticket);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return;
		}
		
		// 通过ticket获取二维码
		String showQRUrl = "https://mp.weixin.qq.com/cgi-bin/showqrcode?ticket=" + ticket;
		
		// 创建OSSClient实例
		OSSClient ossClient = new OSSClient(OSS_ENDPOINT, ACCESS_ID, ACCESS_KEY);
		// 上传
		InputStream inputStream;
		try {
			// 生成一个httpclient对象
			CloseableHttpClient httpclient = createSSLClientDefault();
			HttpGet httpget = new HttpGet(showQRUrl);
			HttpResponse response = httpclient.execute(httpget);
			HttpEntity entity = response.getEntity();
			inputStream = entity.getContent();
			if(inputStream == null) {
				System.out.println(1111);
			}
			ossClient.putObject(BUCKET_NAME, fileNameQRCode, inputStream);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (ossClient != null) {
				// 关闭client
				ossClient.shutdown();
			}
		}
	}

	/**
	 * createSSLClientDefault: 创建HTTPS CloseableHttpClient<br/>
	 *
	 *  @return
	 *  @author langkai
	 *  @version 1.0
	 *  </pre>
	 *  Created on :2016年5月10日 上午10:34:14
	 *  LastModified:
	 *  History:
	 *  </pre>
	 */
	private CloseableHttpClient createSSLClientDefault() {
		if (httpsClientBuilder == null) {
			try {
				// SSL
				final SSLContext sslcontext = SSLContext.getInstance(SSLConnectionSocketFactory.SSL);
				// 取消检测SSL
				sslcontext.init(null, new TrustManager[] { truseAllManager }, null);  

				final SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(sslcontext);
				
				// HTTPS
				httpsClientBuilder = HttpClients.custom().setSSLSocketFactory(sslsf);
				
			} catch (Exception e) {
				e.getStackTrace();
				return HttpClients.createDefault();
			}
		}
		
		return httpsClientBuilder.build();
	}
	
	/**
	 * 重写验证方法，取消检测SSL
	 */
	private static TrustManager truseAllManager = new X509TrustManager() {
		public void checkClientTrusted(X509Certificate[] chain, String authType)
				throws CertificateException {
		}

//		@Override
		public void checkServerTrusted(X509Certificate[] chain, String authType)
				throws CertificateException {
		}

//		@Override
		public X509Certificate[] getAcceptedIssuers() {
			return null;
		}
	};

}
