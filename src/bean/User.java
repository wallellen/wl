package bean;

/**
 * User entity. @author MyEclipse Persistence Tools
 */

public class User implements java.io.Serializable {

	// Fields
	public final static String MODIFY_PERMITION="ÐÞ¸Ä";
	public final static String QUERY_PERMITION="²éÑ¯";
	public final static String SUPER_PERMITION="³¬¼¶";
	private Integer id;
	private String username;
	private String permition;
	private String password;
	private String acess;
	// Constructors

	/** default constructor */
	public User() {
	}

	/** full constructor */
	public User(String username, String permition, String password) {
		this.username = username;
		this.permition = permition;
		this.password = password;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPermition() {
		return this.permition;
	}

	public void setPermition(String permition) {
		this.permition = permition;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAcess() {
		return acess;
	}

	public void setAcess(String acess) {
		this.acess = acess;
	}

}