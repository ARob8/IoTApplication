package business;

import javax.ejb.Local;

import beans.User;

@Local
public interface BusinessInterface {
	public boolean Authenticate(User user);
	public boolean create(User user);
	public boolean findUser(String username);
}
