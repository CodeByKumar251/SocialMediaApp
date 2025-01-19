package com.app.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.models.Story;
import com.app.models.User;
import com.app.repository.StoryRepository;

@Service
public class StoryServiceImplementation implements StoryService{
	
	@Autowired
	private StoryRepository storyRepository;
	
	@Autowired
	private UserService userService;

	@Override
	public Story creatStory(Story story, User user) {
		
		Story createdStory=new Story();
		
		createdStory.setCaption(story.getCaption());
		createdStory.setImage(story.getImage());
		createdStory.setTimeStamp(LocalDateTime.now());
		createdStory.setUser(user);
		
		return storyRepository.save(createdStory);
	}

	@Override
	public List<Story> findStoryByUserId(Integer userId) throws Exception {
		
		User user=userService.findByUserId(userId);
		
		return storyRepository.findByUserId(userId);
	}

}
