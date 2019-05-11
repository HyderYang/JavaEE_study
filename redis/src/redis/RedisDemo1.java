package redis;

import org.junit.Test;
import redis.clients.jedis.Jedis;

import java.util.Timer;

/**
 * @author: 杨欢
 * @created: 2019-05-11 01:40
 * @description:
 */
public class RedisDemo1 {
	private Jedis jedis = new Jedis();
	@Test
	public void test1(){
		this.jedis.set("username", "zhangsan");
		this.jedis.setex("name", 5, "hehe");
		this.jedis.close();
	}

	@Test
	public void test2(){
		this.jedis.hset("user", "name", "lisi");
		this.jedis.hset("user", "age", "23");
		this.jedis.hset("user", "gender", "男");

		String hget = this.jedis.hget("user", "name");
		System.out.println(hget);
	}
}
