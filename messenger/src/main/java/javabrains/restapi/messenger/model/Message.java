package javabrains.restapi.messenger.model;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

// This gives idea to jax b that this is the root element. Then jax b creates xml tags out of these variables. 
@XmlRootElement
public class Message {
private long id;
private String message;
private Date created;
private String author;

/* This no argument constructor is must to be created.
 * When we are dealing with xml or json conversion, we need this constructor to enable frameworks to create new instances  
 */
public Message()
{}

public Message(long id,String message, String author)
{
	this.id=id;
	this.message=message;
	this.author=author;
	this.created=new Date();
}

public long getId() {
	return id;
}
public void setId(long id) {
	this.id = id;
}
public String getMessage() {
	return message;
}
public void setMessage(String message) {
	this.message = message;
}
public Date getCreated() {
	return created;
}
public void setCreated(Date created) {
	this.created = created;
}
public String getAuthor() {
	return author;
}
public void setAuthor(String author) {
	this.author = author;
}


}
