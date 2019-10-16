package data;

import beans.User;

public interface DaoInterface <T>{
	public boolean findBy(T t );
	public boolean findBy(String username);
	public boolean create(T t);
	public User findByUser(String username);

}
