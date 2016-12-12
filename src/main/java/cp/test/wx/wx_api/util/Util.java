package cp.test.wx.wx_api.util;

public class Util {

	public static String generateOrderId() {
		// 0 代表前面补充0
		// 4 代表长度为4
		// d 代表参数为正数型 
		return MD5.Md5(String.format("%018d", System.nanoTime())).toUpperCase();
	}
}
