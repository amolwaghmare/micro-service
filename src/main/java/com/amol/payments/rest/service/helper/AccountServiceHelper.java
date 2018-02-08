package com.amol.payments.rest.service.helper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.amol.payments.data.entity.Account;
import com.amol.payments.data.repository.AccountRepository;
import com.amol.payments.rest.vo.AccountVO;

/**
 * @author Amol Waghmare 
 *
 */
@Component
public class AccountServiceHelper {
	
	@Autowired
	AccountRepository accountRepository;
	
	
	@Transactional
	public AccountVO addAccount(AccountVO accountVO) {
		System.out.println("addAccount: "+accountVO.getName());
		Account account = new Account();
		account.setName(accountVO.getName());
		account.setBalance(new Double(accountVO.getBalance()));
		account = accountRepository.save(account);
		System.out.println(" Account Number: "+account.getAccountnumber());
		
		accountVO.setAccountNumber(account.getAccountnumber());
		return accountVO;
	}

}
