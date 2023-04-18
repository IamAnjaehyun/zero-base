package com.example.account.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import redis.embedded.RedisServer;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Configuration //빈으로 등록한다
public class LocalRedisConfig {
    //yaml에 있는 port 번호 가져옴
    @Value("${spring.redis.port}")
    private int redisPort;

    private RedisServer redisServer;

    @PostConstruct
    public void startRedis() { //이름 아무거나 해도됨
        redisServer = new RedisServer(redisPort);
        redisServer.start();
    }

    @PreDestroy
    public void stopRedis(){ //이름 아무거나 해도됨
        if(redisServer != null){
            redisServer.stop();
        }
    }
}
