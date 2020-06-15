package by.matusevich.rating.service.impl;

import by.matusevich.rating.dao.UserDao;
import by.matusevich.rating.dao.factory.DaoFactory;
import by.matusevich.rating.entity.User;
import by.matusevich.rating.exception.DaoException;
import by.matusevich.rating.exception.ServiceException;
import by.matusevich.rating.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class UserServiceImpl implements UserService {

    private final UserDao userDao;
   // private static final Logger LOGGER = LogManager.getLogger();

    public UserServiceImpl(){
        userDao = DaoFactory.getInstance().getUserDAO();
    }

   /* @Override
    public User signUp(User user) throws ServiceException {
        if(!userValidator.userIsCorrectForSignUp(user)) {
            throw new ServiceException("Data for registration is not correct");
        }
            try {
                User signedUpUser = null;
                if(userDao.add(user)){
                    signedUpUser = findUserByEmail(user.getEmail());
                }
                return signedUpUser;
            } catch (DaoException e) {
                throw new ServiceException("Signing up user error",e);
            }finally {
                userDao.closeConnection();
            }
    }*/

    @Override
    public boolean signIn(String login, String password) throws ServiceException {
        //validation email and password TODO
        User user;
        boolean result = false;
        try {
            user =userDao.findByEmailAndPassword(login,password);
            if(user != null){
                result = true;
            }
        } catch (DaoException e) {
            throw new ServiceException("Signing user in error",e);
        }
        finally {
            userDao.close();
        }
        return result;
    }


}