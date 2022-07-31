package com.Dekanenko.commands;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SendToUserDeleteCommand implements Command{

    private static final Logger log = LogManager.getLogger(SendToUserDeleteCommand.class);

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) {
        req.setAttribute("mark", 1);
        req.setAttribute("delId", req.getParameter("delUserId"));
        req.setAttribute("delPassportId", req.getParameter("delUserPassportId"));
        try {
            req.getRequestDispatcher("/deleteUser.jsp").forward(req, resp);
        } catch (ServletException | IOException ex) {
            log.error(ex.getMessage());
        }
    }
}