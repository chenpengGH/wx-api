package cp.test.sinowel.util;

import java.net.URLEncoder;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;

import com.sun.crypto.provider.SunJCE;

public class AES {

	private Cipher encryptCipher = null;

	private Cipher decryptCipher = null;

	public AES(String password) throws Exception {
		byte[] raw = password.getBytes("UTF-8");
		SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
		encryptCipher = Cipher.getInstance("AES/CBC/PKCS5Padding");// "�㷨/ģʽ/���뷽ʽ"
		decryptCipher = Cipher.getInstance("AES/CBC/PKCS5Padding");// "�㷨/ģʽ/���뷽ʽ"
		IvParameterSpec iv = new IvParameterSpec(raw);// ʹ��CBCģʽ����Ҫһ������iv�������Ӽ����㷨��ǿ��
		encryptCipher.init(Cipher.ENCRYPT_MODE, skeySpec, iv);
		decryptCipher.init(Cipher.DECRYPT_MODE, skeySpec, iv);
	}

	public String encrypt(String content) throws Exception {
		byte[] encrypted = encryptCipher.doFinal(content.getBytes("UTF-8"));
		return Base64.encodeBase64String(encrypted);// �˴�ʹ��BAES64��ת�빦�ܣ�ͬʱ����2�μ��ܵ����á�
	}

	public String decrypt(String content) throws Exception {
		byte[] encrypted1 = Base64.decodeBase64(content);// ����bAES64����
		byte[] original = decryptCipher.doFinal(encrypted1);
		String originalString = new String(original, "UTF-8");
		return originalString;
	}

	public static void main(String[] args) throws Exception {
		AES crypt = new AES("20151217testkey0");//����key
		String ec = crypt.encrypt("openid");//openId
		System.out.println(ec);//���ܺ��openId
		String dc = crypt.decrypt(ec);//���ܺ��openId
		System.out.println(dc);
		ec = URLEncoder.encode(ec, "UTF-8");
		ec = URLEncoder.encode(ec, "UTF-8");
		System.out.println(ec);
		
		SunJCE s = new SunJCE();
	}
 
}