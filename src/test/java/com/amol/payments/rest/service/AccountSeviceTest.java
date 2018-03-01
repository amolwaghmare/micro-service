package com.amol.payments.rest.service;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.amol.payments.data.entity.Account;
import com.amol.payments.data.repository.AccountRepository;
import com.amol.payments.rest.service.helper.AccountServiceHelper;
import com.amol.payments.rest.vo.AccountVO;

/**
 * @author Amol Waghmare
 * Test class for AccountSevice.
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class AccountSeviceTest {
	
	@Mock
	public AccountRepository accountRepository; 
	

	@InjectMocks
	public AccountServiceHelper accountServiceHelper; 
	
	@Mock
	Account account;
	

	@Test
	public void testAddAccount() {
		Account account = new Account();
		account.setAccountnumber(1);
		account.setBalance(5000);
		account.setName("Account1");
		Mockito.when(accountRepository.save(account)).thenReturn(account);
		AccountVO accountVO1 = accountServiceHelper.addAccount(new AccountVO());
		assertTrue(accountVO1.getAccountNumber() >0);
	}

}
