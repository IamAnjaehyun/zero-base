package com.example.account.config;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RedisRepositoryConfig {
    @Value("${spring.redis.host}")
    private String redisHost;
    @Value("${spring.redis.port}")
    private int redisPort;

    @Bean
    public RedissonClient redissonClient() {
        Config config = new Config();
        //임의의 숫자, 문자이기에 변수를 집어넣음, 다른 환경에서는 포트값, 호스트 바뀔 수 있으므로
        config.useSingleServer().setAddress("redis://" + redisHost + ":" + redisPort);

        //다른 서비스나 클라이언트에서 레디슨 클라이언트 호출이나 주입 받으면 여기서 생성된 애가 그곳에 가서 쓰이게 된다.
        return Redisson.create(config);
    }
}