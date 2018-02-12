package com.amol.payments.rest.service.helper;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.amol.payments.data.entity.Account;
import com.amol.payments.data.repository.AccountRepository;
import com.amol.payments.rest.service.AccountService;
import com.amol.payments.rest.vo.AccountVO;

/**
 * @author Amol Waghmare 
 *
 */
@Component
public class AccountServiceHelper {
	
	final static Logger logger = LogManager.getLogger(AccountServiceHelper.class);
	
	
	@Autowired
	AccountRepository accountRepository;
	
	
	@Transactional
	public AccountVO addAccount(AccountVO accountVO) {
		logger.debug("addAccount: "+accountVO.getName());
		Account account = new Account();
		account.setName(accountVO.getName());
		account.setBalance(new Double(accountVO.getBalance()));
		account = accountRepository.save(account);
		logger.debug(" Account Number: "+account.getAccountnumber());
		
		accountVO.setAccountNumber(account.getAccountnumber());
		return accountVO;
	}

}
