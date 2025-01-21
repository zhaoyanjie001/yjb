package org.yjb.business.login.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import redis.clients.jedis.Jedis;

@Service
public class JedisConnectionFactory {
	
	@Value("${spring.redis.host}")
	private  String host;

	@Value("${spring.redis.port}")
	private  int port;

	@Value("${spring.redis.password}")
	private  String password;

	private static Jedis jedis;

	public JedisConnectionFactory() {
	}
	@Bean
	public void getConnection() {

		jedis = new Jedis(host, port);
		jedis.auth(password);
		System.out.println("jedis");
	}
	public static Jedis getJedisConnection() {
		return jedis;
	}

	public static void set(int db, String key, String value) {
		jedis.select(db);
		String result = jedis.set(key, value);
		System.out.println("result = " + result);
		if (jedis != null) {
			jedis.close();
		}
	}
	public static String get(int db, String key) {
		jedis.select(db);
		String result = jedis.get(key);
		System.out.println("result = " + result);
		if (jedis != null) {
			jedis.close();
		}
		return result;
	}
//	public static void main(String argss[]) {
//		// 建立连接
//		jedis = new Jedis(host, port);
//		// 设置密码
//		jedis.auth(password);
//		System.out.println("Connected to Redis");
//		// 选择库（不写默认是0号库）
//		jedis.select(0);
//		// 存储String类型的数据
//		jedis.select(0);
//
//		// 插入键值对，例如插入键"key"和值"value"
//		jedis.set("key", "value");
//		String result = jedis.set("name", "张三");
//		System.out.println("result = " + result);
//		// 取数据
//		String name = jedis.get("name");
//		System.out.println("name = " + name);
//		if (jedis != null) {
//			jedis.close();
//		}
//	}
//  private static JedisPool jedisPool;
//  static {
//      // 配置连接池
//      JedisPoolConfig poolConfig = new JedisPoolConfig();
//      poolConfig.setMaxTotal(8);
//      poolConfig.setMaxIdle(8);
//      poolConfig.setMinIdle(0);
//      poolConfig.setMaxWaitMillis(1000);
//      // 创建连接池对象，参数：连接池配置、服务端ip、服务端端口、超时时间、密码
//      jedisPool = new JedisPool(poolConfig, "192.168.9.11", 6379, 1000, "123456");
//  }
//  public static Jedis getJedis(){
//      return jedisPool.getResource();
//  }
}
