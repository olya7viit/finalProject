package by.matusevich.rating.controller.command;

import by.matusevich.rating.controller.command.impl.SingInCommand;
import by.matusevich.rating.service.impl.UserServiceImpl;

public enum CommandType {
    LOGIN(new SingInCommand(new UserServiceImpl()));

    private Command command;

    CommandType(Command command){
        this.command = command;
    }

    public Command getCommand(){
        return command;
    }
}
