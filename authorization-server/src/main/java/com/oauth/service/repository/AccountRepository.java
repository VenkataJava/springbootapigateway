package com.oauth.service.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.oauth.service.entity.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {

	Optional<Account> findByUsername(String userName);
}
