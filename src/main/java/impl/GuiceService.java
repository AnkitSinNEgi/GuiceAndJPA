package impl;

import model.User;



//	@ImplementedBy(GuiceServiceImpl.class)
	public interface GuiceService {
		String authenticate(String userName, String password);
		
		String sayHello(User user);
		
		String list();

	}


