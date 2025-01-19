package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.models.Reels;
import com.app.models.User;
import com.app.repository.ReelsRepository;

@Service
public class ReelsServiceImplementation implements ReelsService {
	
	@Autowired
	private ReelsRepository reelsRepository;
	
	@Autowired
	private UserService userService;

	@Override
	public Reels createReel(Reels reel, User user) {
		
		Reels createReel=new Reels();
		createReel.setTitle(reel.getTitle());
		createReel.setUser(user);
		createReel.setVideo(reel.getVideo());
		
		
		return reelsRepository.save(createReel);
	}

	@Override
	public List<Reels> findAllReels() {
		
		return reelsRepository.findAll();
	}

	@Override
	public List<Reels> findUsersReel(Integer userId) throws Exception {
		
		User user=userService.findByUserId(userId);
		
		return reelsRepository.findByUserId(userId);
	}

}
