package com.app.service;

import java.util.List;

import com.app.models.Reels;
import com.app.models.User;

public interface ReelsService {
	
	public Reels createReel(Reels reel, User user);
	
	public List<Reels> findAllReels();
	
	public List<Reels> findUsersReel(Integer userId) throws Exception;

}
