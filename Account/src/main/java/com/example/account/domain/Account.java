package com.example.account.domain;

import com.example.account.exception.AccountException;
import com.example.account.type.AccountStatus;
import com.example.account.type.ErrorCode;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@EntityListeners(AuditingEntityListener.class) //CreatedDate / LastModifiedDate
public class Account {
    @Id
    @GeneratedValue
    Long id;

    @ManyToOne
    private AccountUser accountUser; //그냥 유저라고 하면 db에 있는 User Table이랑 충돌이 날 수 있음
    private String accountNumber;

    @Enumerated(EnumType.STRING) //enum값을 1,2,3으로 저장이 아닌 실제 저장한대로 저장
    private AccountStatus accountStatus;
    private Long balance;

    private LocalDateTime registeredAt;
    private LocalDateTime unRegisteredAt;

    @CreatedDate
    private LocalDateTime createdAt; //생성일시
    @LastModifiedDate
    private LocalDateTime updatedAt; //수정일시

    public void useBalance(Long amount){
        if(amount > balance){
            throw new AccountException(ErrorCode.AMOUNT_EXCEED_BALANCE);
        }
        balance -= amount;
    }
}
