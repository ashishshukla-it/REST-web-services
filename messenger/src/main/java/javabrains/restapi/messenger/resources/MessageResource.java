package javabrains.restapi.messenger.resources;

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
import javax.ws.rs.core.MediaType;

import javabrains.restapi.messenger.model.Message;
import javabrains.restapi.messenger.resources.beans.MessageFilterBean;
import javabrains.restapi.messenger.service.MessageService;

@Path("/messages")
public class MessageResource {
	MessageService messageService= new MessageService();
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	/* We don't want to use so many annotations. So for that, we have BeanParam.
       We create a new bean. In that we describe all the annotations to be used and then we call BeanParam in our resources.
    */
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
	public Message addMessage(Message message)
	{
		return messageService.addMessage(message);
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
	public Message test(@PathParam("messageId") long id)
	{
		return messageService.getMessage(id);
	}

}
