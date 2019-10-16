package beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@ManagedBean
@ViewScoped
public class User {
	@NotNull(message = "Please Enter the first name. This is required field.")
	@Size(min = 2, max = 30, message = "First name must be between 2 and 30 characters.")
	private String firstName = "";
	@NotNull(message = "Please Enter the last name. This is required field.")
	@Size(min = 2, max = 30, message = "First name must be between 2 and 30 characters.")
	private String lastName = "";
	@NotNull(message = "Please Enter the user name. This is required field.")
	@Size(min = 2, max = 30, message = "User name must be between 2 and 30 characters.")
	private String userName = "";
	@NotNull(message = "Please Enter the password. This is required field.")
	@Size(min = 2, max = 30, message = "Password must be between 2 and 30 characters.")
	private String password = "";
	@NotNull(message = "Please Enter the Email. This is required field.")
	@Size(min = 2, max = 30, message = "Email must be between 2 and 30 characters.")
	private String email = "";

	public User() {
	}

	public User(String userName, String Password) {
		this.userName = userName;
		this.password = Password;
	}

	public User(String firstName, String lastName, String userName, String Password, String Email, int gender) {

		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.password = Password;
		this.email = Email;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
