package com.amol.payments.rest.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class PaymentsExceptionMapper implements ExceptionMapper<PaymentsException> {
    public Response toResponse(PaymentsException ex) {
    	System.out.println("ExceptionMapper-" +ex.getMessage());
    		Error error = new Error();
    		error.setCode("ERR_101");
    		error.setMessage(ex.getMessage());
    		error.setSeverity(2);
        return Response.status(Response.Status.BAD_REQUEST).entity(error).build();
    }

	
}