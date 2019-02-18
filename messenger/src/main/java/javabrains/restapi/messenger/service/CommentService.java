package javabrains.restapi.messenger.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javabrains.restapi.messenger.database.DatabaseClass;
import javabrains.restapi.messenger.model.Comment;
import javabrains.restapi.messenger.model.Message;

public class CommentService {
	private Map<Long,Message> messages=DatabaseClass.getMessages();
	
	public Comment addComment(Long messageId,Comment comment)
	{
		Map<Long, Comment> comments=messages.get(messageId).getComments();
		comment.setId(comments.size()+1);
		comments.put(comment.getId(),comment);
		return comment;
	}
	
	public Comment updateComment(Long messageId, Comment comment) {
		Map<Long,Comment> comments=messages.get(messageId).getComments();
		if(comment.getId()<=0)
		{return null;}
		comments.put(comment.getId(),comment);
		return comment;
	}
	
	public List<Comment> getAllComments(Long messageId)
	{
		Map<Long,Comment> comments=messages.get(messageId).getComments();
		return new ArrayList<Comment>(comments.values());
	}
	
	public Comment getComment(Long messageId, Long commentId)
	{
		Map<Long,Comment> comments=messages.get(messageId).getComments();
		return comments.get(commentId);
	}
	
	public Comment removeComment(Long messageId,Long commentId)
	{
		Map<Long,Comment> comments=messages.get(messageId).getComments();
		return comments.remove(commentId);
	}
}
