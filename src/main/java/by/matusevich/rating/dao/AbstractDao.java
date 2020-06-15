package by.matusevich.rating.dao;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public interface AbstractDao {
    //Logger LOGGER = LogManager.getLogger();

    void close();

    default void closeStatement(Statement statement){
        try{
            if(statement != null){
                statement.close();
            }
        } catch (SQLException e){
            //LOGGER.error("Can't close statement", e);
        }
    }

    default void closeConnection(Connection connection) {
        try{
            if(connection != null){
                connection.close();
            }
        } catch (SQLException e){
           // LOGGER.error("Can't close connection", e);
        }
    }

    default void closeResultSet(ResultSet resultSet){
        try{
            if(resultSet != null){
                resultSet.close();
            }
        }catch(SQLException e){
           // LOGGER.error("Can't close ResultSet",e);
        }
    }
}