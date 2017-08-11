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
	
	}
