package javabrains.restapi.messenger.resources;

import java.util.List;

import javax.ws.rs.GET;
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
	@Produces(MediaType.APPLICATION_XML)
	public List<Message> getMessages()
	{
		return messageService.getAllMessages();
	}
	
	@GET
	@Path("/{messageId}")
	@Produces(MediaType.TEXT_PLAIN)
	/*
	 * Whatever is in path, we are passing it to display.
	 */
	public String test(@PathParam("messageId") String display)
	{
		return "Got path param " + display;
	}

}
