package com.example.account.repository;

import com.example.account.domain.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {//<활용할 엔티티, pk 데이터 타입>
    Optional<Account> findFirstByOrderByIdDesc(); //id로 정렬한 뒤 역순으로 값을 가져옴
}
