package com.app.service;

import java.util.List;

import com.app.models.Message;
import com.app.models.User;

public interface MessageService {
	
	public Message createMessage(User user, Integer chatId, Message req) throws Exception;
	
	public List<Message> findChatsMessage(Integer chatId) throws Exception;

}
