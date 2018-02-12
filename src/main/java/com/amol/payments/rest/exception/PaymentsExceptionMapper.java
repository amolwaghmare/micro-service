package com.amol.payments.rest.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.amol.payments.rest.service.AccountService;

/**
 * @author Amol Waghmare
 *  Exception mapper class to convert java Exceptions into a JSON error object.
 *
 */
@Provider
public class PaymentsExceptionMapper implements ExceptionMapper<PaymentsException> {

	final static Logger logger = LogManager.getLogger(PaymentsExceptionMapper.class);

	public Response toResponse(PaymentsException ex) {
		logger.debug("ExceptionMapper-" + ex.getMessage());
		Error error = new Error();
		error.setCode("ERR_101");
		error.setMessage(ex.getMessage());
		error.setSeverity(2);
		return Response.status(Response.Status.BAD_REQUEST).entity(error).build();
	}

}