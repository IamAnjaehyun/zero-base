package com.example.account.service;

import com.example.account.domain.Account;
import com.example.account.domain.AccountStatus;
import com.example.account.repository.AccountRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class AccountServiceTest {
    @Mock //가짜로 만들어서 사용 (의존성 주입이랑 비슷)
    private AccountRepository accountRepository;
    @InjectMocks //가짜로 만든 accountRepository를 accountService에 inject
    private AccountService accountService;

    @Test
    @DisplayName("계좌 조회 성공")
    void testXXX() {
        //given
        given(accountRepository.findById(anyLong()))
                .willReturn(Optional.of(Account.builder()
                        .accountStatus(AccountStatus.UNREGISTERED)
                        .accountNumber("65789")
                        .build()));
        //when
        Account account = accountService.getAccount(4555L);

        //then
        assertEquals("65789",account.getAccountNumber());
        assertEquals(AccountStatus.UNREGISTERED,account.getAccountStatus());

    }

//    @Test
//    @DisplayName("Test 이름 변경 -> @DisplayName(\"바꾸고싶은 이름\")")
//    void testGetAccount() {
//        Account account = accountService.getAccount(1L);
//
//        //예상 (assertEquals("값", 메서드)
//        assertEquals("40001", account.getAccountNumber());
//        assertEquals(AccountStatus.IN_USE, account.getAccountStatus());
//    }
//
//    @Test
//    void testGetAccount2() {
//        Account account = accountService.getAccount(2L);
//
//        //예상 (assertEquals("값", 메서드)
//        assertEquals("40000", account.getAccountNumber());
//        assertEquals(AccountStatus.IN_USE, account.getAccountStatus());
//    }
}