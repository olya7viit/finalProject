package by.matusevich.rating.controller.command.impl;

import by.matusevich.rating.controller.command.Command;
import by.matusevich.rating.exception.ServiceException;
import by.matusevich.rating.service.UserService;
import by.matusevich.rating.service.factory.ServiceFactory;
import by.matusevich.rating.service.impl.UserServiceImpl;

import javax.servlet.http.HttpServletRequest;

public class SingInCommand implements Command {

    private static final String PARAM_LOGIN = "login";
    private static final String PARAM_PASSWORD = "password";

    private UserService userService;

    public SingInCommand(UserServiceImpl userService){
        this.userService = userService;
    }

    @Override
    public String execute(HttpServletRequest request) {
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        UserService userService = serviceFactory.getUserService();

        String page;
        String loginValue = request.getParameter(PARAM_LOGIN);
        String passwordValue = request.getParameter(PARAM_PASSWORD);
        boolean result;

        try {
            if(userService.signIn(loginValue,passwordValue)){
                request.setAttribute();
            }
// TODO

        } catch (ServiceException e) {
           //TODO
        }


    }
}
