package com.example.account.repository;

import com.example.account.domain.Account;
import com.example.account.domain.AccountUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {//<활용할 엔티티, pk 데이터 타입>
    Optional<Account> findFirstByOrderByIdDesc(); //id로 정렬한 뒤 역순으로 값을 가져옴

    //count만 하기때문에 list로 안해도 됨
    Integer countByAccountUser(AccountUser accountUser);

    Optional<Account> findByAccountNumber(String AccountNumber);
}
