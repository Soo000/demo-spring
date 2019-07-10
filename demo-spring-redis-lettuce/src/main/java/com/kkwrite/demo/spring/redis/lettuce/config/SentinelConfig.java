package com.kkwrite.demo.spring.redis.lettuce.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.redis.connection.RedisSentinelConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;

@PropertySource("classpath:redis.properties")
@Configuration
public class SentinelConfig {
	
	@Value("${redis.sentinel.master}")
	private String sentinelMaster;
	
	@Value("${redis.sentinel.master.host}")
	private String sentinelMasterHost;
	@Value("${redis.sentinel.master.port}")
	private int sentinelMasterPort;
	
	@Value("${redis.sentinel.slave01.host}")
	private String sentinelSlave01Host;
	@Value("${redis.sentinel.slave01.port}")
	private int sentinelSlave01Port;
	
	@Value("${redis.sentinel.slave02.host}")
	private String sentinelSlave02Host;
	@Value("${redis.sentinel.slave02.port}")
	private int sentinelSlave02Port;
	
	@Bean
	public LettuceConnectionFactory redisConnectionFactory() {
		RedisSentinelConfiguration sentinelConfig = new RedisSentinelConfiguration()
				.master(sentinelMaster)
				.sentinel(sentinelMasterHost, sentinelMasterPort)
				.sentinel(sentinelSlave01Host, sentinelSlave01Port)
				.sentinel(sentinelSlave02Host, sentinelSlave02Port);
		
		return new LettuceConnectionFactory(sentinelConfig);
	}
	
	@Bean
	public StringRedisTemplate stringRedisTemplate(LettuceConnectionFactory redisConnectionFactory) {
		return new StringRedisTemplate(redisConnectionFactory);
	}

}
