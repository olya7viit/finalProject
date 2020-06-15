package by.matusevich.rating.controller;

import by.matusevich.rating.controller.command.Command;
import by.matusevich.rating.controller.command.CommandProvider;
import by.matusevich.rating.pool.ConnectionPool;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.MessageDigest;
import java.util.GregorianCalendar;
import java.util.Optional;

@WebServlet( "/controller")
public class FrontController extends HttpServlet {
    //private static final Logger LOGGER = LogManager.getLogger();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public void destroy() {
       // LOGGER.error("Controller destroying");
        ConnectionPool.getInstance().destroyPool();
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Optional<Command> commandOptional = CommandProvider.defineCommand(request.getParameter("command"));
        Command command = commandOptional.orElseThrow(IllegalArgumentException::new);

        String page = command.execute(request);

        RequestDispatcher dispatcher = request.getRequestDispatcher(page);
        dispatcher.forward(request, response);
    }
}
