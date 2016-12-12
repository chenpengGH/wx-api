package cp.test.wx.wx_api.util;

import java.io.StringWriter;
import java.util.List;
import java.util.Map;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.JavaType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 用于Json处理的工具类
 * 
 * 
 */
public class JsonUtil {
	private static JsonUtil instance = null;
	private static final Logger log = LoggerFactory.getLogger(JsonUtil.class);

	private JsonUtil() {
	}

	public static synchronized JsonUtil getInstance() {
		if (instance == null)
			instance = new JsonUtil();
		return instance;
	}

	/**
	 * 将对象转换成json字符串
	 * 
	 * @param obj
	 * @return
	 */
	public String toJson(Object obj) {
		ObjectMapper mapper = new ObjectMapper();
		StringWriter writer = new StringWriter();
		try {
			mapper.writeValue(writer, obj);
		} catch (Exception e) {
			if (log.isDebugEnabled()) {
				e.printStackTrace();
			}
			log.info(e.toString());
		}

		return writer.toString();
	}

	/**
	 * 将json字符串转换成对象
	 * 
	 * @param str
	 * @param c
	 * @return
	 */
	public <T> T toBean(String str, Class<T> c) {
		ObjectMapper mapper = new ObjectMapper();
		T t = null;
		try {
			t = mapper.readValue(str, c);
		} catch (Exception e) {
			if (log.isDebugEnabled()) {
				e.printStackTrace();
			}
			log.info(e.toString());
		}
		return t;
	}

	/**
	 * 将json字符串转换成Map对象
	 * 
	 * @param data
	 * @return
	 */
	public static Map<?, ?> toMap(String data) {
		Map<?, ?> map = null;
		if (data == null) {
			return map;
		}
		ObjectMapper mapper = new ObjectMapper();
		try {
			map = mapper.readValue(data, Map.class);
		} catch (Exception e) {
			if (log.isDebugEnabled()) {
				e.printStackTrace();
			}
			log.info(e.toString());
		}
		return map;
	}

	/**
	 *  返回List
	 *  @param str
	 *  @param beanClass
	 *  @return
	 *  @author langkai
	 *  @version 1.0
	 *  </pre>
	 *  Created on :2015年5月6日 下午3:17:57
	 *  LastModified:
	 *  History:
	 *  </pre>
	 */
	public <T> List<T> toList(String str, Class<T> beanClass) {
		ObjectMapper mapper = new ObjectMapper();
		List<T> t = null;
		try {
			JavaType javaType = mapper.getTypeFactory().constructParametricType(List.class, beanClass);
			t = mapper.readValue(str, javaType);
		} catch (Exception e) {
			if (log.isDebugEnabled()) {
				e.printStackTrace();
			}
			log.info(e.toString());
		}
		return t;
	}

 

//	public static void main(String[] args) throws Exception {
////		JavaType javaType = getCollectionType(ArrayList.class, YourBean.class);
////		List<YourBean> lst = (List<YourBean>) mapper.readValue(jsonString,
////				javaType);
//	}
//
//	/**
//	 * 获取泛型的Collection Type
//	 * 
//	 * @param collectionClass
//	 *            泛型的Collection
//	 * @param elementClasses
//	 *            元素类
//	 * @return JavaType Java类型
//	 * @since 1.0
//	 */
//	public static JavaType getCollectionType(Class<?> collectionClass,
//			Class<?>... elementClasses) {
//		ObjectMapper mapper = new ObjectMapper();
//		return mapper.getTypeFactory().constructParametricType(collectionClass,
//				elementClasses);
//	}

}
