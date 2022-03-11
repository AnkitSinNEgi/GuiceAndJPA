
 import com.google.inject.ImplementedBy;

import model.User;
import service.UserServiceImpl;


@ImplementedBy(UserServiceImpl.class)
public interface UserService{
	String authenticate(String userName, String password);
	
	String save(User user);
	
	String list();
	
}