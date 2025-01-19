package com.app.service;

import java.util.List;

import com.app.models.Story;
import com.app.models.User;

public interface StoryService {
	
	public Story creatStory(Story story, User user);
	
	public List<Story> findStoryByUserId(Integer userId) throws Exception;

}
