package com.example.account.service;

import com.example.account.domain.Account;
import com.example.account.domain.AccountStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest //실제와 동일하게 빈과 컨텍스트를 생성해서 테스트를 하게 해줌
class AccountServiceTest {
    @Autowired //필요한 의존 객체의 “타입"에 해당하는 빈을 찾아 주입한다.
    private AccountService accountService;

    @BeforeEach //테스트 전에 무조건 한번 실행
    void init(){
        accountService.createAccount();
    }

    @Test
    @DisplayName("Test 이름 변경 -> @DisplayName(\"바꾸고싶은 이름\")")
    void testGetAccount(){
        Account account = accountService.getAccount(1L);

        //예상 (assertEquals("값", 메서드)
        assertEquals("40001", account.getAccountNumber());
        assertEquals(AccountStatus.IN_USE, account.getAccountStatus());
    }

    @Test
    void testGetAccount2(){
        Account account = accountService.getAccount(2L);

        //예상 (assertEquals("값", 메서드)
        assertEquals("40000", account.getAccountNumber());
        assertEquals(AccountStatus.IN_USE, account.getAccountStatus());
    }
}