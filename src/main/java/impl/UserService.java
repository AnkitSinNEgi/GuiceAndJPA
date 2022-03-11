package impl;

import impl.GuiceServiceImpl;
import com.google.inject.ImplementedBy;

import model.User;

@ImplementedBy(UserServiceImpl.class)
public interface UserService{
	String authenticate(String userName, String password);
	
	String save(User user);
	
	String list();
	}