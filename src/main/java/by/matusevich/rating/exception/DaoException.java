package by.matusevich.rating.exception;

public class DaoException extends Exception {

    public DaoException(){}

    public DaoException(String message){super(message);}

    public DaoException(String message, Throwable throwable){super(message,throwable);}

    public DaoException(Throwable throwable){super(throwable);}
}
