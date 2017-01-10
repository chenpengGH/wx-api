package cp.test.wx.wx_api.util;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * Description:
 *
 * @author: jhc
 * @create: 2017/1/10
 * @version: 1.0
 */
public class JedisUtil {

    // 主 - 连接池（用于分布式不支持的操作命令）
    private static JedisPool pool = null;

    private static String redis_host = "10.180.50.53";

    private static int redis_port = 6380; // 专门读的redis，读写都有的端口是6379

    private static int redis_timeout = 3000;

    private static String password = "udp!@#$%^";

    private static final String TOKEN_KEY = "release.token";

    static {
        // 连接池配置
        JedisPoolConfig poolConfig = new JedisPoolConfig();
        // 最大连接数
        poolConfig.setMaxActive(10);
        // 最大空闲数量
        poolConfig.setMaxIdle(5);

        pool = new JedisPool(poolConfig, redis_host, redis_port, redis_timeout, password);
    }

    /**
     * 获取redis中的保存的token
     */
    public static String getToken() {

        Jedis jedis = null;
        try {
            jedis = pool.getResource();

            return jedis.get(TOKEN_KEY);
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            pool.returnResource(jedis);
        }
    }

    /**
     * 查看某个TOKEN_KEY的剩余生存时间,单位【秒】.永久生存或者不存在的都返回-1
     * @return
     */
    public static Long getTokenTTL() {
        Jedis jedis = null;
        try {
            jedis = pool.getResource();

            return jedis.ttl(TOKEN_KEY);
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            pool.returnResource(jedis);
        }
    }

    public static void main(String[] args) {
        String token = JedisUtil.getToken();
        System.out.println(token);
        Long ttl = JedisUtil.getTokenTTL();
        System.out.println(ttl);
    }
}
