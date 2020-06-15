package by.matusevich.rating.dao.impl;

import by.matusevich.rating.dao.DaoHelper;
import by.matusevich.rating.dao.UserDao;
import by.matusevich.rating.entity.Role;
import by.matusevich.rating.entity.User;
import by.matusevich.rating.exception.DaoException;
import by.matusevich.rating.pool.ConnectionPool;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UserDaoImpl implements UserDao {
    private Connection connection;
    /*public static final String ADD_USER = "INSERT INTO user (name,surname,password,email,phone) " +
            "VALUES (?,?,?,?,?)";*/
    private static final Logger LOGGER = LogManager.getLogger();

    public UserDaoImpl(){
        this.connection = ConnectionPool.getInstance().getConnection();
    }

    @Override
    public User add(User user) throws DaoException {
       /* try(PreparedStatement statement = connection.prepareStatement(SQLQuery.ADD_USER)){
            statement.setString(1,user.getFirstName());
            statement.setString(2,user.getLastName());
            statement.setString(3,user.getEmail());
            statement.setString(4,user.getPassword());
            statement.setString(5,user.getPhone());
            statement.executeUpdate();
        }catch (SQLException e) {
            throw new DaoException("User has not been added",e);
        }*/
        return user;
    }

    @Override
    public List<User> findAll() throws DaoException {
        return null;
    }

    @Override
    public User findById(long id) {
        return null;
    }

    @Override
    public User updateById(User user) {
        return null;
    }

    @Override
    public User deleteById(long id) {
        return null;
    }

    @Override
    public User findByEmailAndPassword(String email, String password) {
        return null;
    }

    @Override
    public User getUserFromResultSet(ResultSet resultSet) throws DaoException {
        try {
            return new User(resultSet.getLong(DaoHelper.ID_USER),
                    resultSet.getString(DaoHelper.NAME),
                    resultSet.getString(DaoHelper.SURNAME),
                    resultSet.getString(DaoHelper.PASSWORD),
                    resultSet.getString(DaoHelper.EMAIL),
                    Role.getUserRoleById
                            (resultSet.getInt(DaoHelper.ID_ROLE)).get());
        } catch (SQLException e) {
            throw new DaoException("Getting user from resultSet error",e);
        }
    }

    @Override
    public void close() {
        closeConnection(connection);
    }
}
