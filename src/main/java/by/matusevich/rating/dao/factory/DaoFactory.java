package by.matusevich.rating.dao.factory;

import by.matusevich.rating.dao.UserDao;
import by.matusevich.rating.dao.impl.UserDaoImpl;

public final class DaoFactory {
    private static final DaoFactory instance = new DaoFactory();

    private final UserDao userDao = new UserDaoImpl();

    private DaoFactory(){}

    public static DaoFactory getInstance(){
        return instance;
    }

    public UserDao getUserDAO(){
        return userDao;
    }
}
