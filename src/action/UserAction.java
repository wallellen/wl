package action;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import service.UserManager;
import util.MD5;
import util.SessionContants;
import bean.User;

public class UserAction extends BaseAction {
	private UserManager userManager;

	public UserManager getUserManager() {
		return userManager;
	}
	public String getUsername() {
		return username;
	}
	public String getPassword() {
		return password;
	}
	public void setUserManager(UserManager userManager) {
		this.userManager = userManager;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	private String username;
	private String password;
	private String permition;
	private String acess;
	private List<String> acessList;
	public String getPermition() {
		return permition;
	}
	public void setPermition(String permition) {
		this.permition = permition;
	}
	public static final String EXIST_USER="exist";
	
	
	
	
	public String login(){
		
		if(this.isExistSession(SessionContants.USER)){
			return this.EXIST_USER;
		}
		else{
			if(!username.equals("") && !password.equals("")){
				User user = new User();
				user.setUsername(username);
				//if(!password.equals(""))
				user.setPassword(MD5.MD5Encode(password));
				//System.out.println(MD5.MD5Encode(password));
				if(this.userManager.isValid(user))
				{
					user=userManager.findUser(user);
					this.setSession(SessionContants.USER, user);
					String[] acesses = user.getAcess().split(",");
					for(int i = 0;i < acesses.length;i ++){
						acesses[i] = acesses[i].trim();
					}
					List<String> acessesList = Arrays.asList(acesses);
					this.setSession(SessionContants.ACESSES, acessesList);
				 
					return "sucess";
				}
			}
			return "fail";
		}
	}
	
	
	public String addUser(){		
		User user = new User();
		user.setUsername(username);
		user.setPassword(MD5.MD5Encode(password));
		user.setPermition(this.permition);
		user.setAcess(acess);
		if(userManager.addUser(user)=="ok"){
			return "sucess";
		}
		return "exist";
	}
	
	public String findUser(){
		User user = new User();
		user.setUsername(username);
		user=userManager.findUser(user);
		if(user!=null){
			this.password=user.getPassword();
			this.username=user.getUsername();
			this.permition=user.getPermition();
			this.acess = user.getAcess();
			
			String[] acesses = user.getAcess().split(",");
			for(int i = 0;i < acesses.length;i ++){
				acesses[i] = acesses[i].trim();
			}
			this.acessList = Arrays.asList(acesses);
			return "findsucess";
		}
		else{
				this.username="";
				this.password="";
				this.permition="";
				this.acess="";
			
		}
		return"notfind";
	}

	private String newPassword;

	private String newPermition;
	
	private String newAcesses;
	
	public String modifyUser(){
		User user= new User();
		user.setUsername(username);
		user=this.userManager.findUser(user);
		if(user!=null){
		if(!newPassword.equals("")){
			this.password=newPassword;
			user.setPassword(MD5.MD5Encode(newPassword));
		}
		if(!newPermition.equals("")){
			this.permition=this.newPermition;
			user.setPermition(newPermition);
		}
		if(newAcesses != null){
			this.acess = newAcesses;
			user.setAcess(acess);
		}
		userManager.updateUser(user);
		}

		return"modifysucess";
	}
	public String deleteUser(){
		User user = new User();
		user.setUsername(username);
		userManager.deleteUser(user);
		this.username="";
		this.permition="";
		return "deletesucess";
	}
	
	public String logOut(){		
		if(this.getSession(SessionContants.USER)!=null){
			//this.setSession(SessionContants.USER, null);
			this.removeSession(SessionContants.USER);
			return "logout";
		}
		return null;
	}
	
	
	
	
	
	
	
	
	
	

	public String getNewPassword() {
		return newPassword;
	}
	public String getNewPermition() {
		return newPermition;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}
	public void setNewPermition(String newPermition) {
		this.newPermition = newPermition;
	}
	public String getAcess() {
		return acess;
	}
	public void setAcess(String acess) {
		this.acess = acess;
	}
	
	public void setNewAcess(String newAcess){
		this.acess = newAcess;
	}
	public String getNewAcesses() {
		return newAcesses;
	}
	public void setNewAcesses(String newAcesses) {
		this.newAcesses = newAcesses;
	}
	public List<String> getAcessList() {
		return acessList;
	}
	public void setAcessList(List<String> acessList) {
		this.acessList = acessList;
	}
}
