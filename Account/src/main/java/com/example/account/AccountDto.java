package com.example.account;


import lombok.*;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;

//@Getter @Setter @ToString
//@NoArgsConstructor
@AllArgsConstructor
@Data //위에꺼 다들어있음
@Slf4j
public class AccountDto {
    private String accountNumber;
    private String nickName;
    private LocalDateTime registeredAt;

    //slf4j
    public void log(){
        log.error("error is occurred");
    }

}