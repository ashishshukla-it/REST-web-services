package javabrains.restapi.messenger.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("/")
// Because class level path annotation is optional for subresource.
public class CommentResource {
	@GET
	@Path("/{commentId}")
	public String test(@PathParam("commentId") long commentId,@PathParam("messageId") long messageId)
	{
		return "Method to return CommentID: "+ commentId + " MessageID: "+ messageId;
	}

}
