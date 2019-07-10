package com.kkwrite.demo.spring.redis.lettuce.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceClientConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;

import io.lettuce.core.ReadFrom;

@PropertySource("classpath:redis.properties")
@Profile("ReadAndWrite")
@Configuration
public class ReadAndWriteConfig {

	@Value("${redis.master.host}")
	private String masterHost;
	@Value("${redis.sentinel.master.port}")
	private int masterPort;
	
	@Bean
    public LettuceConnectionFactory redisConnectionFactory() {
        LettuceClientConfiguration clientConfig = LettuceClientConfiguration.builder()
                .readFrom(ReadFrom.SLAVE_PREFERRED)
                .build();
        
        // 默认slave只能进行读取，不能写入
        // 如果你的应用程序需要往redis写数据，建议连接master
        RedisStandaloneConfiguration serverConfig = new RedisStandaloneConfiguration(masterHost, masterPort);
        return new LettuceConnectionFactory(serverConfig, clientConfig);
    }
	
	@Bean
	public StringRedisTemplate stringRedisTemplate(LettuceConnectionFactory redisConnectionFactory) {
		return new StringRedisTemplate(redisConnectionFactory);
	}
	
}
