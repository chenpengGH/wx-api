package cp.test.wx.wx_api.util;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;


public class HttpUtil {

	public static void main(String[] args) {
		httpRequest("http://baidu.com", "POST", null);
	}
	
	
	/**
	 * https 请求方法
	 * 
	 * @param httpUrl
	 * @param requestMethod
	 * @param outputStr
	 * @return
	 * @author linyaoyao
	 * @version 1.0 </pre> Created on :2015年1月12日 下午3:12:52 LastModified:
	 *          History: </pre>
	 */
	public static String httpRequest(String httpUrl, String requestMethod,
			String outputStr) {
		StringBuffer buffer = new StringBuffer();
		try {
			URL url = new URL(httpUrl);
			URLConnection rulConnection = url.openConnection();
			HttpURLConnection httpUrlConnection = (HttpURLConnection) rulConnection;
			httpUrlConnection.setDoOutput(true);
			httpUrlConnection.setDoInput(true);
			httpUrlConnection.setUseCaches(false);
			httpUrlConnection.setRequestProperty("Content-Type",
					"application/json");
			httpUrlConnection
					.setRequestProperty("POST", "/violations HTTP/1.1");
			httpUrlConnection.setRequestMethod(requestMethod);
			httpUrlConnection.connect();
			if (null != outputStr) {
				OutputStream outputStream = httpUrlConnection.getOutputStream();
				outputStream.write(outputStr.getBytes("UTF-8"));
				outputStream.close();
			}
			InputStream inputStream = httpUrlConnection.getInputStream();
			InputStreamReader inputStreamReader = new InputStreamReader(
					inputStream, "UTF-8");
			BufferedReader bufferedReader = new BufferedReader(
					inputStreamReader);
			String str = null;
			while ((str = bufferedReader.readLine()) != null) {
				buffer.append(str);
			}
			System.out.println(buffer);
			bufferedReader.close();
			inputStreamReader.close();
			inputStream.close();
			inputStream = null;
			httpUrlConnection.disconnect();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return buffer.toString();
	}

	public static String httpsRequest(String requestUrl, String requestMethod,
			String outputStr) {
		StringBuffer buffer = new StringBuffer();
		try {

			// 创建SSLContext对象，并使用我们指定的信任管理器初始化
			TrustManager[] tm = { new MyX509TrustManager() };
			SSLContext sslContext = SSLContext.getInstance("SSL", "SunJSSE");
			sslContext.init(null, tm, new java.security.SecureRandom());

			// 从上述SSLContext对象中得到SSLSocketFactory对象
			SSLSocketFactory ssf = sslContext.getSocketFactory();

			URL url = new URL(requestUrl);
			HttpsURLConnection httpUrlConn = (HttpsURLConnection) url
					.openConnection();
			httpUrlConn.setSSLSocketFactory(ssf);
			httpUrlConn.setDoOutput(true);
			httpUrlConn.setDoInput(true);
			httpUrlConn.setUseCaches(false);

			// 设置请求方式（GET/POST）
			httpUrlConn.setRequestMethod(requestMethod);

			if ("GET".equalsIgnoreCase(requestMethod))
				httpUrlConn.connect();

			// 当有数据需要提交时
			if (null != outputStr) {
				OutputStream outputStream = httpUrlConn.getOutputStream();
				// 注意编码格式，防止中文乱码
				outputStream.write(outputStr.getBytes("UTF-8"));
				outputStream.close();
			}

			// 将返回的输入流转换成字符串
			InputStream inputStream = httpUrlConn.getInputStream();
			InputStreamReader inputStreamReader = new InputStreamReader(
					inputStream, "utf-8");
			BufferedReader bufferedReader = new BufferedReader(
					inputStreamReader);

			String str = null;
			while ((str = bufferedReader.readLine()) != null) {
				buffer.append(str);
			}

			// 释放资源
			bufferedReader.close();
			inputStreamReader.close();
			inputStream.close();
			inputStream = null;
			httpUrlConn.disconnect();

		} catch (ConnectException ce) {
			ce.printStackTrace(); 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return buffer.toString();
	}

	

//	public static void main(String[] args) throws UnsupportedEncodingException {
//		String url = "https://api.weixin.qq.com/cgi-bin/user/info?access_token=ACCESS_TOKEN&openid=OPENID&lang=zh_CN";
//		url = url.replaceAll("ACCESS_TOKEN", JedisUtil.getToken());
//		url = url.replaceAll("OPENID", "oUZWKs8QMDCIKhVI2K_1oDcnks3o");
//
//		WechatUserInfo user = JsonUtil.getInstance().toBean(
//				httpRequest(url, "GET", null), WechatUserInfo.class);
//		System.out.println(EmojiFilter.filterEmoji(user.getNickname()));
//
//	}

}
