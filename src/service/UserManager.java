package service;

import java.util.List;

import DAO.UserDAO;
import bean.User;

public class UserManager {
	private UserDAO userDAO;
	
	public UserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	public boolean isValid(User user) {
		// TODO Auto-generated method stub
		List<User> users= userDAO.findByExample(user);
		if(users!=null && users.size()>0){
			return true;
		}
		else	
			return false;
	}

	public String addUser(User user) {
		if(this.findUser(user)!=null){
			return "fail";
		}
		this.userDAO.merge(user);
		return "ok";
	}
	
	public void updateUser(User user){
		this.userDAO.merge(user);
	}
	
	public User findUser(User user) {
		// TODO Auto-generated method stub
		//User newUser = new User();
		//newUser.setUsername(user.getUsername());
		//newUser.setPassword(user.getPassword());
		List<User>users=this.userDAO.findByExample(user);
		if(users!=null&&users.size()>0){
			return users.get(0);
		}
		return null;
	}

	public void deleteUser(User user) {
		// TODO Auto-generated method stub
		user=this.findUser(user);
		userDAO.delete(user);
	}

}
