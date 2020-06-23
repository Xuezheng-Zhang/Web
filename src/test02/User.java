package test02;

public class User {
	private String Name;
	private String Email;
	private String Password;
	
	public User() {}
	
    User(String Name,String Email, String Password) {
        this.Name = Name;
        this.Email = Email;
        this.Password = Password;
    }
    
	public String getName() {
		return Name;
	}


	public void setName(String name) {
		this.Name = name;
	}


	public String getEmail() {
		return Email;
	}


	public void setEmail(String email) {
		this.Email = email;
	}


	public String getPassword() {
		return Password;
	}


	public void setPassword(String password) {
		this.Password = password;
	}
}
