package model;

public class User {
	private String userId;
	private String passwd;
	private String name;
	private String email;
	private String phone;

	public User() { }
	
	public User(String userId, String passwd, String name, String email, String phone) {
		this.userId = userId;
		this.passwd = passwd;
		this.name = name;
		this.email = email;
		this.phone = phone;
	}

	public void update(User updateUser) {
        this.passwd = updateUser.passwd;
        this.name = updateUser.name;
        this.email = updateUser.email;
        this.phone = updateUser.phone;
    }
	
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return passwd;
	}

	public void setPassword(String passwd) {
		this.passwd = passwd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	/* ?ç†?èô?òôÊ©òÂç†?ã´Ôø? ?ç†?ãØ?Çº?òô */
	public boolean matchPassword(String passwd) {
		if (passwd == null){
			return false;
		}
		return this.passwd.equals(passwd);
	}
	
	public boolean isSameUser(String userid) {
        return this.userId.equals(userid);
    }

	@Override
	public String toString() {
		return "User [userId=" + userId + ", passwd=" + passwd + ", name=" + name + ", email=" + email + ", phone="
				+ phone + "]";
	}	
}
