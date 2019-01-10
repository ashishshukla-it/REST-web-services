package javabrains.restapi.messenger.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.CookieParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/injectDemo")
// For text plain, ensure that content type in postman is empty.
@Consumes(MediaType.TEXT_PLAIN)
@Produces(MediaType.TEXT_PLAIN)
public class InjectDemoResource 
{
	@GET
	@Path("annotations")
	/*
	 * Just like QueryParam, there is MatrixParam. 
	 * In this, after url, in place of ? we use ;
	 */
	public String getParamUsingAnnotations(@MatrixParam("param") String matrixParam,
			                               @HeaderParam("header") String header,
			                               @CookieParam("cookieName") String cookie)
	{
		// header param can be used to get metadata such as authentication token etc.
		// @FormParam is also there which can be used to capture data entered through html forms
		return "MatrixParam " + matrixParam + " HeaderParam " + header + " CookieParam " + cookie;
	}

}
