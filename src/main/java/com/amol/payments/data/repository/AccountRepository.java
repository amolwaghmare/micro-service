package com.amol.payments.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.amol.payments.data.entity.Account;

/**
 * @author Amol Waghmare
 *
 */
public interface AccountRepository extends JpaRepository<Account, Integer> {

}
