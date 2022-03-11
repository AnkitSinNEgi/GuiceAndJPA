package impl;


import javax.persistence.EntityManager;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import com.google.inject.Inject;

import model.User;

public class UserServiceImpl implements UserService{
		
	
		@Inject
		private EntityManager entityManager;
	@Override
	public String authenticate(String userName,String password) {
		System.out.println("UserServiceImpl : Authenticate");
		
		String status =null;
		String query = "FROM User WHERE userName= userName and password= password";
		User user = (User)entityManager.createQuery(query).setParameter("userName",userName)
				.setParameter("password",password).getSingleResult();
		System.out.println(user);
		if(user!=null)
		{
			status ="Valid";
		} else {
			status ="Invalid";
		}
		return status;
	}
	
	public String save(User user) {
		System.out.println("UserServiceImpl : save ");
		entityManager.persist(user);
		JSONObject jsonObject = new JSONObject();
		try {
			jsonObject.put("status","User Save successfully");
		}
		catch(JSONException e) {
			e.printStackTrace();
		}
		return jsonObject.toString();
	}
	
	
}
