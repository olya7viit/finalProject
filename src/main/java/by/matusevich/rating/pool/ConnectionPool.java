package by.matusevich.rating.pool;

import by.matusevich.rating.exception.ConnectionPoolException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.ResourceBundle;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConnectionPool {
    private static ConnectionPool INSTANCE;
    private static final int DEFAULT_POOL_SIZE = 32;
    private BlockingQueue<Connection> freeConnections;
    private ResourceBundle resource = ResourceBundle.getBundle("data/database");
    private static Lock lock = new ReentrantLock();
   // private static final Logger LOGGER = LogManager.getLogger();


    private ConnectionPool(){ //TODO
        String url = resource.getString("db.url");
        String user = resource.getString("db.user");
        String pass = resource.getString("db.password");
        freeConnections = new LinkedBlockingQueue<>(DEFAULT_POOL_SIZE);
        for(int i = 0; i < DEFAULT_POOL_SIZE; i++){
            try {
                freeConnections.add(DriverManager.getConnection(url, user, pass));
            } catch (SQLException e) {
               // LOGGER.error("Can't add connection",e);
            }
        }
    }

    public static ConnectionPool getInstance(){
        if(INSTANCE == null){
            lock.lock();
            try {
                if (INSTANCE == null) {
                    INSTANCE = new ConnectionPool();
                }
            } finally {
                lock.unlock();
            }
            return INSTANCE;
        }
        return INSTANCE;
    }

    public Connection getConnection()  {
        Connection connection = null;
        if (!freeConnections.isEmpty()) {
            try {
                connection = freeConnections.take();
            } catch (InterruptedException e) {
               // LOGGER.error("Can't get connection",e);
                Thread.currentThread().interrupt();
            }
        }
        return connection;
    }

    public void releaseConnection(Connection connection) throws ConnectionPoolException {
        if(connection.getClass() != ProxyConnection.class){
            throw new ConnectionPoolException("Invalid connection");
        }
        freeConnections.offer(connection);
    }

    public void destroyPool(){
        for (int i = 0; i < DEFAULT_POOL_SIZE; i++){
            try {
                freeConnections.take().close();
            } catch (SQLException | InterruptedException e) {
               // LOGGER.error(e);
            }
        }
        deregisterDrivers();
    }

    private void deregisterDrivers(){
        Enumeration<Driver> drivers;
        drivers = DriverManager.getDrivers();
        while(drivers.hasMoreElements()){
            Driver driver = drivers.nextElement();
            try {
                DriverManager.deregisterDriver(driver);
            } catch (SQLException e) {
              //  LOGGER.error("Deregister driver error",e);
            }
        }
    }


}