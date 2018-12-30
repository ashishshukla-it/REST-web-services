package javabrains.restapi.messenger.resources;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import javabrains.restapi.messenger.model.Message;
import javabrains.restapi.messenger.service.MessageService;

@Path("/messages")
// This is class level annotation
public class MessageResource {
	MessageService messageService= new MessageService();
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public List<Message> getMessages()
	{
		return messageService.getAllMessages();
	}
	
	@GET
	@Path("/test")
	// This is method level annotation. /test is to be followed by messages.
	@Produces(MediaType.TEXT_PLAIN)
	public String test()
	{
		return "test";
	}

}
