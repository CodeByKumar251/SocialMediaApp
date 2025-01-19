package com.app.service;

import java.util.List;

import com.app.models.Chat;
import com.app.models.User;

public interface ChatService {
	
	public Chat createChat(User reqUser, User user2 );
	
	public Chat findChatById(Integer chatId) throws Exception;
	
	public List<Chat> findUsersChat(Integer userId);

}
