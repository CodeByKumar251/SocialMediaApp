package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.app.models.Post;
import com.app.models.User;
import com.app.response.ApiResponse;
import com.app.service.PostService;
import com.app.service.UserService;

@RestController
public class PostController {
	
	@Autowired
	PostService postService;
	
	@Autowired
	UserService userService;
	
	@PostMapping("/api/posts")
	public ResponseEntity<Post> createPost(@RequestBody Post post,@RequestHeader("Authorization") String jwt) throws Exception{
		
		User reqUser=userService.findUserByJwt(jwt);
		Post createdPost=postService.createNewPost(post, reqUser.getId());
		
		return new  ResponseEntity<>(createdPost,HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/api/posts/{postId}")
	public ResponseEntity<ApiResponse> deletePost(@PathVariable Integer postId, @RequestHeader("Authorization") String jwt) throws Exception{
		
		User reqUser=userService.findUserByJwt(jwt);
		String message=postService.deletePost(postId, reqUser.getId());
		ApiResponse res=new ApiResponse(message,true);
		return new ResponseEntity<>(res,HttpStatus.OK);
	}
	
	@GetMapping("/api/posts/{postId}")
	public ResponseEntity<Post> findPostByIdHandler(@PathVariable Integer postId) throws Exception {
		
		Post post=postService.findPostById(postId);
		return new ResponseEntity<>(post,HttpStatus.ACCEPTED);
		
	}
	
	@GetMapping("/api/posts/user/{userId}")
	public ResponseEntity<List<Post>> findUsersPost(@PathVariable Integer userId) {
		
		List<Post> allPost=postService.findPostByUserId(userId);
		
		return  new ResponseEntity<>(allPost,HttpStatus.ACCEPTED);
		
	}
	
	@GetMapping("/api/posts")
	public ResponseEntity<List<Post>> findAllPost(){
		
		List<Post> allPost=postService.findAllPost();
		
		return new ResponseEntity<>(allPost,HttpStatus.ACCEPTED);
		
	}
	
	@PutMapping("/api/posts/save/{postId}")
	public ResponseEntity<Post> savePostHandler(@PathVariable Integer postId, @RequestHeader("Authorization") String jwt) throws Exception{
		
		User reqUser=userService.findUserByJwt(jwt);
		Post savedPost=postService.savePost(postId, reqUser.getId());
		
		return new ResponseEntity<>(savedPost, HttpStatus.ACCEPTED);
	}
	
	@PutMapping("/api/posts/like/{postId}")
	public ResponseEntity<Post> likePostHandler(@PathVariable Integer postId, @RequestHeader("Authorization") String jwt) throws Exception{
		
		User reqUser=userService.findUserByJwt(jwt);
		Post post=postService.likePost(postId, reqUser.getId());
		
		return new  ResponseEntity<>(post,HttpStatus.ACCEPTED);
	}
}
