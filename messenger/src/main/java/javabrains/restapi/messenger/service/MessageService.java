package javabrains.restapi.messenger.service;

import java.util.ArrayList;
import java.util.List;

import javabrains.restapi.messenger.model.Message;

public class MessageService {
	public List<Message> getAllMessages(){
		Message m1=new Message(1l, "Hello world!", "ashish");
		Message m2=new Message(2l, "Hello jersey!", "ashish");
		List<Message> list=new ArrayList<>();
		list.add(m1);
		list.add(m2);
		return list;
	}

}
