package com.example.account.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration //자동으로 빈 등록
@EnableJpaAuditing //JPAAuditing 켜진채로 동작, 붙은애들 자동 저장
public class JpaAuditingConfiguration {
}
