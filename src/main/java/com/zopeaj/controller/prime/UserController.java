package com.zopeaj.controller.prime;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.zopeaj.model.prime.User;
import com.zopeaj.service.prime.IUserService;


@RestController
@RequestMapping("/api/users/")
public class UserController {
	
	@Autowired(required=false)
	private IUserService userService;
	
	@PostMapping
	public ResponseEntity<User> addProduct (@RequestParam("name") String name, @RequestParam("file") MultipartFile file){
		return null;
	}
	
	@GetMapping("all")
	public List<User> getAllProducts() {
		return null; 
	}
}
