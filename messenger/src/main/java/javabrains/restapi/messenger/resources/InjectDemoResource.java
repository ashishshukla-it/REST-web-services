package javabrains.restapi.messenger.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.CookieParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

@Path("/injectDemo")
// For text plain, ensure that content type in postman is empty.
@Consumes(MediaType.TEXT_PLAIN)
@Produces(MediaType.TEXT_PLAIN)
public class InjectDemoResource 
{
	@GET
	@Path("annotations")
	public String getParamUsingAnnotations(@MatrixParam("param") String matrixParam,
			                               @HeaderParam("header") String header,
			                               @CookieParam("cookieName") String cookie)
	{
		return "MatrixParam " + matrixParam + " HeaderParam " + header + " CookieParam " + cookie;
	}
	
	@GET
	@Path("context")
	public String getParamsUsingContext(@Context UriInfo uriinfo,
			                            @Context HttpHeaders headers)
	{
		String path =uriinfo.getAbsolutePath().toString();
		String cookies=headers.getCookies().toString();
		return "Absolute path is: "+ path+ " and Cookie is: "+cookies;
	}
	
}
