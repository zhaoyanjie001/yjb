package org.yjb.business.edi.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;

@Configuration
public class RedisConfig {
 
    //服务器地址
    @Value("${spring.redis.host}")
    private String host;
    
    //端口
    @Value("${spring.redis.port}")
    private int port;
    
    //密码
    @Value("${spring.redis.password}")
    private String password;
    
    //超时时间
    @Value("${spring.redis.timeout}")
    private String timeout;
    
    //最大连接数
    @Value("${spring.redis.jedis.pool.max-active}")
    private int maxTotal;
    
    //最大连接阻塞等待时间
    @Value("${spring.redis.jedis.pool.max-wait}")
    private String maxWaitMillis;
    
    //最大空闲连接
    @Value("${spring.redis.jedis.pool.max-idle}")
    private int maxIdle;
    
    //最小空闲连接
    @Value("${spring.redis.jedis.pool.min-idle}")
    private int minIdle;
    
    @Bean
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory connectionFactory){
        // 创建RedisTemplate对象
        RedisTemplate<String, Object> template = new RedisTemplate<>();
        // 设置连接工厂
        template.setConnectionFactory(connectionFactory);
        // 创建JSON序列化工具
        GenericJackson2JsonRedisSerializer jsonRedisSerializer = 
            							new GenericJackson2JsonRedisSerializer();
        // 设置Key的序列化（String）
        template.setKeySerializer(RedisSerializer.string());
        template.setHashKeySerializer(RedisSerializer.string());
        // 设置Value的序列化 （Json）
        template.setValueSerializer(jsonRedisSerializer);
        template.setHashValueSerializer(jsonRedisSerializer);
        // 返回
        return template;
    }
}