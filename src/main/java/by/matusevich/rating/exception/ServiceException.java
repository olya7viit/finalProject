package by.matusevich.rating.exception;

public class ServiceException extends Exception {

    public ServiceException(){}

    public ServiceException(String message){super(message);}

    public ServiceException(String message, Throwable throwable){super(message,throwable);}

    public ServiceException(Throwable throwable){super(throwable);}
}

