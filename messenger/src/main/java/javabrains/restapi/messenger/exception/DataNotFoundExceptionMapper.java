package javabrains.restapi.messenger.exception;

import javax.ws.rs.ext.Provider;

import javabrains.restapi.messenger.model.ErrorMessage;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;

@Provider
/*
 *  To do certain activities such as Filtering-Request/Response, Exception Handling, the JAX-RS has its own default implementation logic.
 *  However, it allows users to provider their own implementation as well.
 *  To provide our own implementation we need to implement the appropriate classes by specifying them with @Provider annotation.
 * 	JAX-RS will do a round of scanning to find the existence of any such user-defined implementation by searching for @Provider annotation.
 *  In simple words, it lets jax rs know that this class is there and exception can be mapped to it.
 */
public class DataNotFoundExceptionMapper implements ExceptionMapper<DataNotFoundException> {

	@Override
	public Response toResponse(DataNotFoundException ex) {
		// TODO Auto-generated method stub
		ErrorMessage errorMessage=new ErrorMessage(ex.getMessage(), 404, "https://www.javabrains.kaushik.org");
		return Response.status(Status.NOT_FOUND)
				.entity(errorMessage)
				.build();
	}

}
 