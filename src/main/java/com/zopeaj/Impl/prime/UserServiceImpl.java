package com.zopeaj.Impl.prime;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.zopeaj.model.prime.User;
import com.zopeaj.service.prime.IUserService;

@Service
public class UserServiceImpl implements IUserService{

	@Override
	public User createUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeUser(UUID userId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public User findById(UUID userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> findAllUser() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User findUserEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User findUserId(UUID userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateUser(UUID userId, User user) {
		// TODO Auto-generated method stub
		
	}

}
