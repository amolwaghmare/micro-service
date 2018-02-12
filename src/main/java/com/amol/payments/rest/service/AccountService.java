package com.amol.payments.rest.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amol.payments.rest.service.helper.AccountServiceHelper;
import com.amol.payments.rest.vo.AccountVO;

/**
 * @author Amol Waghmare
 *
 */

@Path("/account")
@Service
public class AccountService {
	
	final static Logger logger = LogManager.getLogger(AccountService.class);
	

	
	@Autowired
	public AccountServiceHelper accountServiceHelper; 
	
	@GET
	@Produces("application/json")
	public AccountVO getAccount(@QueryParam("name") String name) {
		logger.debug("Name:"+ name);
		AccountVO account = new AccountVO();
		account.setName(name);
		return account;
		
	}

	@POST 
	@Consumes("application/json")
	@Produces("application/json")
	public AccountVO addAccount(AccountVO accountVO) {
		logger.debug("POST->Name:"+ accountVO.getName());
		logger.debug("POST->Balance:"+ accountVO.getBalance());
		return accountServiceHelper.addAccount(accountVO);
		
	}
}
