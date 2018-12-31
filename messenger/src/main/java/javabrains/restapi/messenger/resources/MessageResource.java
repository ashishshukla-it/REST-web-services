package javabrains.restapi.messenger.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import javabrains.restapi.messenger.model.Message;
import javabrains.restapi.messenger.service.MessageService;

@Path("/messages")
public class MessageResource {
	MessageService messageService= new MessageService();
	@GET
	/*
	 * Directly we cannot convert to json. In pom.xml, one dependency has been commented out by name "jersey-media-moxy".
	 * Uncomment it to get json response.
	 */
	@Produces(MediaType.APPLICATION_JSON)
	public List<Message> getMessages()
	{
		return messageService.getAllMessages();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Message addMessage(Message message)
	{
		return messageService.addMessage(message);
	}
	
	@GET
	@Path("/{messageId}")
	@Produces(MediaType.APPLICATION_JSON)
	/*
	 * 
	 */
	public Message test(@PathParam("messageId") long id)
	{
		return messageService.getMessage(id);
	}

}
