package com.ngt.repository;

import com.ngt.entity.Account;
import com.ngt.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AccountRepository extends JpaRepository<Account, UUID> {

    public Account findByUltimateAccountNameAndAccountName(String ultimateAccountName,String accountName);

}
