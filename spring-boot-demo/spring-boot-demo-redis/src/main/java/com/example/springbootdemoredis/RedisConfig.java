package com.example.springbootdemoredis;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * @ProjectName: MyGitHub-OctoberZDi-MyJavaDemo
 * @ClassName: RedisConfig
 * @Description: Redis自定义配置
 * @Author: zhangdi
 * @Date: 2020年05月12日 15:01
 **/
@Configuration
public class RedisConfig {

    @Bean
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory factory) {
        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<String, Object>();
        // 配置连额吉工厂
        redisTemplate.setConnectionFactory(factory);
        StringRedisSerializer stringRedisSerializer = new StringRedisSerializer();
        Jackson2JsonRedisSerializer<?> jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer<>(Object.class);
        // key采用string的序列化方式
        redisTemplate.setKeySerializer(stringRedisSerializer);
        // hash  key采用string的序列化方式
        redisTemplate.setHashKeySerializer(stringRedisSerializer);

        // value采用string的序列化方式
        redisTemplate.setValueSerializer(stringRedisSerializer);
        // hash value采用string的序列化方式
        redisTemplate.setHashValueSerializer(jackson2JsonRedisSerializer);

        return redisTemplate;
    }
}
