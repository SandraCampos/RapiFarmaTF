package com.hampcode.model.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hampcode.model.entity.Account;

@Repository
public interface UserRepository extends JpaRepository<Account, Long> {
	 Account findByUserName(String userName);
}
