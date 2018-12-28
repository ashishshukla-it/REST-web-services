package javabrains.restapi.messenger.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/messages")
public class MessageResource {
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	// Produces will tell jersey that at what format this class is going to send data. MediaType is an annotation that contains all possible formats.
	public String getMessages()
	{
		return "hello world";
	}

}
/* 
We need to inform jersey that this class is here to be looked upon. 
For this, in web.xml, in init-param's param-value, we enter the name of the packages which we want that jersey should search in order to look for that resource 
*/