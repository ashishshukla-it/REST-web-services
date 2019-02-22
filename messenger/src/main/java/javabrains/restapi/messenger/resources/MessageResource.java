package javabrains.restapi.messenger.resources;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriInfo;

import javabrains.restapi.messenger.model.Message;
import javabrains.restapi.messenger.resources.beans.MessageFilterBean;
import javabrains.restapi.messenger.service.MessageService;

@Path("/messages")
public class MessageResource {
	MessageService messageService= new MessageService();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Message> getMessages(@BeanParam MessageFilterBean filterBean)
	{
		if(filterBean.getYear()>0)
		{
			return messageService.getMessageForYear(filterBean.getYear());
		}
		// Because of this =0, getAllMessages() will never be called so it should not be used.
		if(filterBean.getStart() >=0 && filterBean.getSize() >=0)
		{
			return messageService.getAllMessagesPaginated(filterBean.getStart(), filterBean.getSize());
		}
		else
			return messageService.getAllMessages();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addMessage(Message message, @Context UriInfo uriInfo) throws URISyntaxException
	{
		Message newMessage= messageService.addMessage(message);
		String newId=String.valueOf(message.getId()); 
		URI uri=uriInfo.getAbsolutePathBuilder().path(newId).build();
		// We use created when we want path back in response where new add has successfully taken place.
		  return Response.created(uri)
				       .entity(newMessage)
				       .build();
	}
	
	@PUT
	@Path("/{messageId}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Message updateMessage(@PathParam("messageId") long id, Message message)
	{
		message.setId(id);
		return messageService.updateMessage(message);
	}
	
	@DELETE
	@Path("/{messageId}")
	@Produces(MediaType.APPLICATION_JSON)
	public void removeMessage(@PathParam("messageId") long id)
	{
		messageService.removeMessage(id);
	}
	
	@GET
	@Path("/{messageId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Message getMessage(@PathParam("messageId") long id, @Context UriInfo uriInfo) {
		Message message= messageService.getMessage(id);
		message.addLink(getUriForSelf(uriInfo, message), "self");
		message.addLink(getUriForProfile(uriInfo,message), "profile");
		return messageService.getMessage(id);
	}

	private String getUriForProfile(UriInfo uriInfo, Message message) {
		String uri=uriInfo.getBaseUriBuilder()                         // https:localhost:8080/messenger/webapi 
				          .path(ProfileResource.class)                 // profiles
				          .path(message.getAuthor())                   // {authorName}
				          .build()
		                  .toString();
		return uri;
	}
	
	private String getUriForSelf(UriInfo uriInfo, Message message) {
		String uri=uriInfo.getBaseUriBuilder()                         // https:localhost:8080/messenger/webapi
						  .path(MessageResource.class)                 // /messages
						  .path(Long.toString(message.getId()))        // /{messageId}                            
						  .build()
						  .toString();
		return uri;
		
				
	}
	
	// We don't have to mention http method name here
	@Path("/{messageId}/comments")
	public CommentResource getCommentResource()
	{
		return new CommentResource();
	}

}
