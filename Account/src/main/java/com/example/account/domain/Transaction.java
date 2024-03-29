package com.example.account.domain;

import com.example.account.type.TransactionResultType;
import com.example.account.type.TransactionType;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Transaction extends BaseEntity{
    @Enumerated(EnumType.STRING)
    private TransactionType transactionType; //사용 전,후
    @Enumerated(EnumType.STRING)
    private TransactionResultType transactionResultType; //트랜잭션 성공 실패

    @ManyToOne
    private Account account; //1:N
    private Long amount; //거래 금액
    private Long balanceSnapshot; //현재 금액

    private String transactionId; //pk안쓰고 별도의 transactionId
    private LocalDateTime transactedAt;
}
