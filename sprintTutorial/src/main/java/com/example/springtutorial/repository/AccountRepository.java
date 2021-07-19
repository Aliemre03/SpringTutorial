package com.example.springtutorial.repository;

import com.example.springtutorial.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account,String> {
}
