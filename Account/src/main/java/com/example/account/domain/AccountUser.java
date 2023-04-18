package com.example.account.domain;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@EntityListeners(AuditingEntityListener.class) //CreatedDate / LastModifiedDate
public class AccountUser {
    @Id
    @GeneratedValue// 자동 값 증가(생성)
    private Long id;

    private String name;

    @CreatedDate
    private LocalDateTime createdAt; //생성일시
    @LastModifiedDate
    private LocalDateTime updatedAt; //수정일시

}
