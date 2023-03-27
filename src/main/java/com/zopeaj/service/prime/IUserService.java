package com.zopeaj.service.prime;

import java.util.UUID;
import java.util.List;

import org.springframework.stereotype.Component;
import com.zopeaj.model.prime.*;

@Component
public interface IUserService {
	public User createUser(User user);
	public void removeUser(UUID userId);
	public User findById(UUID userId);
	public List<User> findAllUser();
	public User findUserEmail(String email);
	public User findUserId(UUID userId);
	public void updateUser(UUID userId, User user);
}
