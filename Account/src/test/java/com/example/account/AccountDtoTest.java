package com.example.account;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class AccountDtoTest {

    @Test
    void accountDto() {
        //given

        //when

        //then

        //AllArgsConstructor test
        AccountDto accountDto = new AccountDto(
                "accountNumber",
                "summer",
                LocalDateTime.now()
        );
//        @AllArgsConstructor있어서 이거 안해도 됨
//        accountDto.setAccountNumber("accountNumber");
//        accountDto.setNickName("summer");
        accountDto.setRegisteredAt(LocalDateTime.now());

        accountDto.getAccountNumber();

        System.out.println(accountDto.getAccountNumber());
        System.out.println(accountDto.toString());
    }
}