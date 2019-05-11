package redis;

import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @author: 杨欢
 * @created: 2019-05-11 02:07
 * @description:
 */
public class JedisPoolDemo {

	@Test
	public void test1(){

		JedisPoolConfig config = new JedisPoolConfig();

		config.setMaxTotal(5);
		config.setMaxIdle(10);

		JedisPool jedisPool = new JedisPool(config, "localhost", 6379);
		Jedis resource = jedisPool.getResource();

		resource.set("name", "haha");

		resource.close();
	}
}
