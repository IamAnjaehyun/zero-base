package com.example.account.domain;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Account {
    @Id
    @GeneratedValue
    Long id;

    private String accountNumber;

    @Enumerated(EnumType.STRING) //enum값을 1,2,3으로 저장이 아닌 실제 저장한대로 저장
    private AccountStatus accountStatus;
}
