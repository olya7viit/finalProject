package by.matusevich.rating.dao;

import by.matusevich.rating.entity.User;
import by.matusevich.rating.exception.DaoException;

import java.sql.ResultSet;
import java.util.List;

public interface UserDao extends AbstractDao {
    User add(User user) throws DaoException;
    List<User> findAll() throws DaoException;
    User findById(long id);
    User updateById(User user);
    User deleteById(long id);
    User findByEmailAndPassword(String email, String password) throws DaoException;
    User getUserFromResultSet(ResultSet resultSet) throws DaoException;
}