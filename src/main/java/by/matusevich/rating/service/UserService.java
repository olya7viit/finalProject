package by.matusevich.rating.service;

import by.matusevich.rating.exception.ServiceException;

public interface UserService {
   /* User signUp(User user) throws ServiceException;*/
    boolean signIn(String login, String password) throws ServiceException;
}