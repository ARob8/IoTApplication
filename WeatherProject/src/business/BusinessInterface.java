package business;

import javax.ejb.Local;
import beans.User;

@Local
public interface BusinessInterface {
	public boolean Authenticate(User t);
	public boolean create(User t);
	public boolean findUser(String username);
	public User findByUser (String username);
}
