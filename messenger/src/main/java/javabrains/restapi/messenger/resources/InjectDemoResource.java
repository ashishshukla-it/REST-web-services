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
	/*
	 * Just like QueryParam, there is MatrixParam. 
	 * In this, after url, in place of ? we use ;
	 */
	public String getParamUsingAnnotations(@MatrixParam("param") String matrixParam,
			                               @HeaderParam("header") String header,
			                               @CookieParam("cookieName") String cookie)
	{
		return "MatrixParam " + matrixParam + " HeaderParam " + header + " CookieParam " + cookie;
	}
	
	/*
	 * But there is problem. It can be a trouble to remember the name of all the params.
	 * For this we have context annotation.
	 * This annotation gets applied with only certain classes only.
	 */
	
	@GET
	@Path("context")
	public String getParamsUsingContext(@Context UriInfo uriinfo,
			                            @Context HttpHeaders headers)
	{
//		String path=uriinfo.getPath();
//		return "Path is: "+ path;
//		Output will be 'Path is: injectDemo/context'
		String path =uriinfo.getAbsolutePath().toString();
		String cookies=headers.getCookies().toString();
		return "Absolute path is: "+ path+ " and Cookie is: "+cookies;
		// Absolute path is: http://localhost:8080/messenger/webapi/injectDemo/context and header is: {hello cookies=$Version=0;hello cookies=}
	}

}
