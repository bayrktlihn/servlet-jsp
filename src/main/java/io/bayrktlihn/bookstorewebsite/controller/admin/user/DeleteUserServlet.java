package io.bayrktlihn.bookstorewebsite.controller.admin.user;

import io.bayrktlihn.bookstorewebsite.context.ApplicationContext;
import io.bayrktlihn.bookstorewebsite.exception.UserNotFoundException;
import io.bayrktlihn.bookstorewebsite.service.TranslateService;
import io.bayrktlihn.bookstorewebsite.service.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/admin/delete-user")
public class DeleteUserServlet extends HttpServlet {

    private final UserService userService = ApplicationContext.getBean(UserService.class);
    private final TranslateService translateService = ApplicationContext.getBean(TranslateService.class);


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long id = Long.parseLong(req.getParameter("id"));
        try {
            userService.deleteById(id);
            HttpSession session = req.getSession(false);
            session.setAttribute("deletedUserMessage", translateService.instant("user.delete.successfully", new Object[]{id}));
            resp.sendRedirect("/admin/list-user");
        } catch (UserNotFoundException e) {
            HttpSession session = req.getSession(false);
            session.setAttribute("userNotFoundMessage", translateService.instant(e.getKey(), e.getArgs()));
            resp.sendRedirect("/admin/list-user");

        }
    }
}
