package com.amol.payments.rest.service;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

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
	public AccountServiceHelper accountServiceHelper; 
	
	@Mock
	AccountVO accountVO;
	
	@InjectMocks
	private AccountService accountService;
	
	@Test
	public void testAddAccount() {
		AccountVO accountVO = new AccountVO();
		accountVO.setAccountNumber(1);
		accountVO.setBalance("5000");
		accountVO.setName("Account1");
		Mockito.when(accountServiceHelper.addAccount(Mockito.any())).thenReturn(accountVO);
		AccountVO accountVO1 = accountService.addAccount(new AccountVO());
		assertTrue(accountVO1.getAccountNumber() >0);
	}

}
