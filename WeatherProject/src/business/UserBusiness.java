package business;


import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.interceptor.Interceptors;

import beans.User;
import data.DaoInterface;
import util.LoggingInterceptor;

@Interceptors(LoggingInterceptor.class)
@Stateless
@Local
@LocalBean
public class UserBusiness implements BusinessInterface {
	
	Logger logger = LoggerFactory.getLogger(UserBusiness.class);

	@EJB
	DaoInterface<User> Dao;
	public UserBusiness() {
	}
	
	@Override
	public boolean Authenticate(User user)
	{
		logger.info("Entering Authennticate user");
		//UserDao UserDao = new UserDao();
		return Dao.findBy(user);
	}

	@Override
	public boolean create(User user) {
		// TODO Auto-generated method stub
		logger.info("Entering create user");
		return Dao.create(user);
	}

	@Override
	public boolean findUser(String username) {
		// TODO Auto-generated method stub
		logger.info("find user by username");
		return Dao.findBy(username);
	}

	@Override
	public User findByUser(String username) {
		// TODO Auto-generated method stub
		return Dao.findByUser(username);
	}
	

}
