package cp.test.wx.wx_api.util;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Shape;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;


import com.alibaba.fastjson.JSONObject;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.Binarizer;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.DecodeHintType;
import com.google.zxing.EncodeHintType;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

public class QRCodeUtil
{
	// LOGO宽度  
    private static final int WIDTH = 60;  
    // LOGO高度  
    private static final int HEIGHT = 60; 
	// 二维码颜色
//	private static final int BLACK = 0xFF0000;// 0xFFFF0000，红色
//	private static final int BLACK = 0xF94B4A;// 0xFFFF0000，红色
	private static final int BLACK = 0xF14A50;// 0xFFFF0000，红色
	// 二维码背景色
	private static final int WHITE = 0xFFFFFF;// 0xFF0000FF，蓝色
    
    private static final EnumMap<EncodeHintType, Object> hints = new EnumMap<EncodeHintType, Object>(EncodeHintType.class);
	static
	{
		/*
		 * 二维码的纠错级别(排错率),4个级别： L (7%)、 M (15%)、 Q (25%)、 H (30%)(最高H)
		 * 纠错信息同样存储在二维码中，纠错级别越高，纠错信息占用的空间越多，那么能存储的有用讯息就越少；共有四级； 选择M，扫描速度快。
		 */
		hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);
		// 二维码边界空白大小 1,2,3,4 (4为默认,最大)
		hints.put(EncodeHintType.MARGIN, 1);
		hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
		hints.put(EncodeHintType.MAX_SIZE, 350);
		hints.put(EncodeHintType.MIN_SIZE, 150);
	}
	
	public static void main(String[] args) throws Exception
	{
		byte[] content = createQRCode("http://www.baidu.com");
		
		FileOutputStream fo = new FileOutputStream("d:/a.png");
		fo.write(content);
		fo.flush();
		fo.close();
	}
    
	public static byte[] createQRCord(String content, int width, int height) throws WriterException, IOException
	{
		ByteArrayOutputStream bo = new ByteArrayOutputStream();
		String format = "png";// 图像类型
		Map<EncodeHintType, Object> hints = new HashMap<EncodeHintType, Object>();
		hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
		BitMatrix bitMatrix = new MultiFormatWriter().encode(content, BarcodeFormat.QR_CODE, width, height, hints);// 生成矩阵
		MatrixToImageWriter.writeToStream(bitMatrix, format, bo);
		
		BufferedImage QRImage = ImageIO.read(new ByteArrayInputStream(bo.toByteArray()));
		
		
//		BufferedImage logoImage = ImageIO.read(QRCodeUtil.class.getResourceAsStream("/logo.png"));
		BufferedImage logoImage = ImageIO.read(new URL("http://udp-oss.oss-cn-beijing.aliyuncs.com/qrcode_subscribe/logo.png"));
		
		BufferedImage QRResultImage = encodeImgLogo(QRImage, logoImage);
		bo = new ByteArrayOutputStream();
		ImageIO.write(QRResultImage, "jpeg", bo);
		return bo.toByteArray();
	}
	
	public static byte[] createQRCode(String content) throws WriterException, IOException
	{
		BitMatrix matrix = new MultiFormatWriter().encode(content, BarcodeFormat.QR_CODE, 1000, 1000, hints);
		BufferedImage image = new BufferedImage(1000, 1000, BufferedImage.TYPE_INT_RGB);
//		BitMatrix matrix = new MultiFormatWriter().encode(content, BarcodeFormat.QR_CODE, 300, 300, hints);
//		BufferedImage image = new BufferedImage(300, 300, BufferedImage.TYPE_INT_RGB);
		int width = matrix.getWidth();
		int height = matrix.getHeight();
		for (int x = 0; x < width; x++)
		{
			for (int y = 0; y < height; y++)
			{
				image.setRGB(x, y, matrix.get(x, y) ? BLACK : WHITE);
			}
		}
		
//		BufferedImage logoImage = ImageIO.read(QRCodeUtil.class.getResourceAsStream("/logo.png"));
		BufferedImage logoImage = ImageIO.read(new URL("http://hdcs.orientalwisdom.com/qrcode_subscribe/logo.png"));
		
		BufferedImage QRResultImage = encodeImgLogo(image, logoImage);
		ByteArrayOutputStream bo = new ByteArrayOutputStream();
		ImageIO.write(QRResultImage, "png", bo);
		return bo.toByteArray();
	}
	
	public static BufferedImage encodeImgLogo(BufferedImage QRImage, BufferedImage logo) throws IOException
	{
		// 获取画笔
		Graphics2D g = QRImage.createGraphics();
		int logoWidth = logo.getWidth(null) > QRImage.getWidth() * 2 / 10 ? (QRImage.getWidth() * 2 / 8) : logo.getWidth(null);
		int logoHeight = logo.getHeight(null) > QRImage.getHeight() * 2 / 10 ? (QRImage.getHeight() * 2 / 8) : logo.getHeight(null);
		// 设置logo图片放置位置
		// 中心
		int x = (QRImage.getWidth() - logoWidth) / 2;
		int y = (QRImage.getHeight() - logoHeight) / 2;
		// 右下角，15为调整值
		// int x = twodimensioncode.getWidth() - logoWidth-15;
		// int y = twodimensioncode.getHeight() - logoHeight-15;
		// 开始合并绘制图片
		g.drawImage(logo, x, y, logoWidth, logoHeight, null);
		g.drawRoundRect(x, y, logoWidth, logoHeight, 15, 15);
		// logo边框大小
		g.setStroke(new BasicStroke(2));
		// logo边框颜色
		g.setColor(Color.WHITE);
		g.drawRect(x, y, logoWidth, logoHeight);
		g.dispose();
		logo.flush();
		QRImage.flush();
		return QRImage;
	}
	
	private static void insertImage(BufferedImage source, int QRWidth, int QRHeight, String imgPath, boolean needCompress) throws IOException
	{
		if (null == imgPath || imgPath.length()==0)
		{
			return;
		}
		
		File file = new File(imgPath);
		if (!file.exists())
		{
			return;
		}
		Image src = ImageIO.read(new File(imgPath));
		int width = src.getWidth(null);
		int height = src.getHeight(null);
		if (needCompress)
		{ // 压缩LOGO
			if (width > WIDTH)
			{
				width = WIDTH;
			}
			if (height > HEIGHT)
			{
				height = HEIGHT;
			}
			Image image = src.getScaledInstance(width, height, Image.SCALE_SMOOTH);
			BufferedImage tag = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
			Graphics g = tag.getGraphics();
			g.drawImage(image, 0, 0, null); // 绘制缩小后的图
			g.dispose();
			src = image;
		}
		// 插入LOGO
		Graphics2D graph = source.createGraphics();
		int x = (QRWidth - width) / 2;
		int y = (QRHeight - height) / 2;
		graph.drawImage(src, x, y, width, height, null);
		Shape shape = new RoundRectangle2D.Float(x, y, width, width, 6, 6);
		graph.setStroke(new BasicStroke(3f));
		graph.draw(shape);
		graph.dispose();
	}
	
	public static void testEncode() throws WriterException, IOException
	{
//		String filePath = "D://";
		String fileName = "zxing.png";
		JSONObject json = new JSONObject();
		json
				.put(
						"zxing",
						"https://github.com/zxing/zxing/tree/zxing-3.0.0/javase/src/main/java/com/google/zxing");
		json.put("author", "shihy");
		String content = json.toJSONString();// 内容
		int width = 200; // 图像宽度
		int height = 200; // 图像高度
		String format = "png";// 图像类型
		Map<EncodeHintType, Object> hints = new HashMap<EncodeHintType, Object>();
		hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
		BitMatrix bitMatrix = new MultiFormatWriter().encode(content,
				BarcodeFormat.QR_CODE, width, height, hints);// 生成矩阵
		MatrixToImageWriter.writeToFile(bitMatrix, format, new File("g:/" + fileName));
		System.out.println("输出成功.");
	}

	/**
	 * 解析图像
	 */
	public void testDecode()
	{
		String filePath = "D://zxing.png";
		BufferedImage image;
		try
		{
			image = ImageIO.read(new File(filePath));
			LuminanceSource source = new BufferedImageLuminanceSource(image);
			Binarizer binarizer = new HybridBinarizer(source);
			BinaryBitmap binaryBitmap = new BinaryBitmap(binarizer);
			Map<DecodeHintType, Object> hints = new HashMap<DecodeHintType, Object>();
			hints.put(DecodeHintType.CHARACTER_SET, "UTF-8");
			Result result = new MultiFormatReader().decode(binaryBitmap, hints);// 对图像进行解码
			JSONObject content = JSONObject.parseObject(result.getText());
			System.out.println("图片中内容：  ");
			System.out.println("author： " + content.getString("author"));
			System.out.println("zxing：  " + content.getString("zxing"));
			System.out.println("图片中格式：  ");
			System.out.println("encode： " + result.getBarcodeFormat());
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		catch (NotFoundException e)
		{
			e.printStackTrace();
		}
	}
}
