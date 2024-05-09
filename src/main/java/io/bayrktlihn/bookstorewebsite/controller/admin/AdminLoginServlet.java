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

@WebServlet("/admin/login")
public class AdminLoginServlet extends HttpServlet {

    private final UserService userService = ApplicationContext.getBean(UserService.class);
    private final TranslateService translateService = ApplicationContext.getBean(TranslateService.class);

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String email = req.getParameter("email");
        String password = req.getParameter("password");

        boolean valid = userService.checkPassword(email, password);


        HttpSession session = req.getSession(true);

        if (!valid) {
            session.setAttribute("username", email);
            session.setAttribute("loginInvalid", translateService.instant("login.invalid"));
            resp.sendRedirect("/admin/login.jsp");
        } else {
            session.setAttribute("username", email);
            resp.sendRedirect("/admin/");
        }
    }
}
