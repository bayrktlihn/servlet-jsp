package io.bayrktlihn.bookstorewebsite.controller.admin;

import io.bayrktlihn.bookstorewebsite.context.ApplicationContext;
import io.bayrktlihn.bookstorewebsite.service.TranslateService;
import io.bayrktlihn.bookstorewebsite.service.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/admin/logout")
public class AdminLogoutServlet extends HttpServlet {

    private final UserService userService = ApplicationContext.getBean(UserService.class);
    private final TranslateService translateService = ApplicationContext.getBean(TranslateService.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession(false);

        if(session != null){
            session.invalidate();
            session = req.getSession(true);
            session.setAttribute("successfullyLogin", translateService.instant("successfully.login"));
            resp.sendRedirect("/admin/login.jsp");
        } else {
            session = req.getSession(true);
            resp.sendRedirect("/admin/login.jsp");
        }

    }
}
