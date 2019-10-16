package business;


import javax.ejb.EJB
;
import javax.ejb.Local;
import javax.ejb.Stateless;

import javax.enterprise.inject.Default;
import javax.inject.Inject;

import beans.User;
import data.DaoInterface;
import data.UserDao;

@Stateless
@Local
@Default
public class UserBusiness implements BusinessInterface {
	@Inject
	DaoInterface Dao;
	public UserBusiness() {
	}
	@Override
	public boolean Authenticate(User user)
	{
		UserDao UserDao = new UserDao();
		return UserDao.findBy(user);
	}
	@Override
	public boolean create(User user) {
		return Dao.create(user);
	}
	@Override
	public boolean findUser(String username) {
		return Dao.findBy(username);
	}


}
