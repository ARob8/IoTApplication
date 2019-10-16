package data;

import beans.User;

public interface DaoInterface {
	public boolean findBy(User user);
	public boolean findBy(String username);
	public boolean create(User user);

}
