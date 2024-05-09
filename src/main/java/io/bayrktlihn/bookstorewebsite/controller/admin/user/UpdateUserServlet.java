package io.bayrktlihn.bookstorewebsite.controller.admin.user;

import io.bayrktlihn.bookstorewebsite.context.ApplicationContext;
import io.bayrktlihn.bookstorewebsite.dto.UpdateUserDto;
import io.bayrktlihn.bookstorewebsite.exception.I18nSupportedException;
import io.bayrktlihn.bookstorewebsite.service.TranslateService;
import io.bayrktlihn.bookstorewebsite.service.UserService;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/admin/update-user")
public class UpdateUserServlet extends HttpServlet {

    private final UserService userService = ApplicationContext.getBean(UserService.class);
    private final TranslateService translateService = ApplicationContext.getBean(TranslateService.class);

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        long id = Long.parseLong(req.getParameter("id"));
        String email = req.getParameter("email");
        String fullName = req.getParameter("fullName");
        String password = req.getParameter("password");

        UpdateUserDto updateUserDto = UpdateUserDto.create(id, fullName, password, email);

        try {
            userService.update(updateUserDto);
            resp.sendRedirect("/admin/list-user");
        } catch (I18nSupportedException e) {
            HttpSession session = req.getSession(false);
            session.setAttribute("updateUserFailMessage", translateService.instant(e.getKey(), e.getArgs()));
            resp.sendRedirect("/admin/edit-user?id=" + id);
        }
    }
}
