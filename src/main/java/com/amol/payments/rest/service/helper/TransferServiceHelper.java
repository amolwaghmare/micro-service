package com.amol.payments.rest.service.helper;

import java.util.Date;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.amol.payments.data.entity.Account;
import com.amol.payments.data.entity.Transfer;
import com.amol.payments.data.repository.AccountRepository;
import com.amol.payments.data.repository.TransferRepository;
import com.amol.payments.rest.exception.PaymentsException;
import com.amol.payments.rest.vo.TransferVO;

/**
 * @author Amol Waghmare 
 *
 */
@Component
public class TransferServiceHelper {
	
	final static Logger logger = LogManager.getLogger(TransferServiceHelper.class);
	
	@Autowired
	TransferRepository trasferRepository;
	
	@Autowired
	AccountRepository accountRepository;
	
	@Transactional
	public TransferVO transfer(TransferVO transferVO) throws PaymentsException {
		logger.debug("From account: "+transferVO.getFromAccountnumber());
		
		//Check the balance of from account.
		Account account = accountRepository.findOne(transferVO.getFromAccountnumber());
		Double fromBalance = account.getBalance();
		validateBalance(fromBalance, transferVO.getTransferAmount() );
		
		Transfer transfer = new Transfer();
		transfer.setFromAccountnumber(transferVO.getFromAccountnumber());
		transfer.setToAccountnumber(transferVO.getToAccountnumber());
		transfer.setTransferAmount(transferVO.getTransferAmount());
		transfer.setTransferDate(new java.sql.Date(new Date().getTime()));
		transfer = trasferRepository.save(transfer);
		logger.debug(" TransactionNumber: "+transfer.getId());
		
		transferVO.setTransferNumber(transfer.getId());
		return transferVO;
	}

	/** - Validates the transferAmount against the balance in the account.
	 * @param fromBalance
	 * @param transferAmount
	 * @throws PaymentsException
	 */
	private void validateBalance(Double fromBalance, Double transferAmount) throws PaymentsException {
		if ((fromBalance - transferAmount) <= 0) {
			logger.error("Not enough balance.");
			throw new PaymentsException(" Not enough funds. ");
			
		}
	}

}
