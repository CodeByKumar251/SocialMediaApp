package com.app.service;

import java.util.List;

import com.app.exceptions.UserException;
import com.app.models.User;

public interface UserService {
	
	public User registerUser(User user);
	
	public User findByUserId(Integer userId) throws UserException;
	
	public User findUserByEmail(String email);
	
	public User followUser(Integer userId1, Integer userId2) throws UserException;
	
	public User updateUser(User user,Integer userId) throws UserException;
	
	public List<User> searchUser(String query);
	
	public User findUserByJwt(String jwt);
}
