package io.bayrktlihn.bookstorewebsite.controller.admin.user;

import io.bayrktlihn.bookstorewebsite.context.ApplicationContext;
import io.bayrktlihn.bookstorewebsite.dto.CreateUserDto;
import io.bayrktlihn.bookstorewebsite.exception.I18nSupportedException;
import io.bayrktlihn.bookstorewebsite.service.TranslateService;
import io.bayrktlihn.bookstorewebsite.service.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/admin/create-user")
public class CreateUserServlet extends HttpServlet {

    private final UserService userService = ApplicationContext.getBean(UserService.class);
    private final TranslateService translateService = ApplicationContext.getBean(TranslateService.class);

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String fullname = req.getParameter("fullName");
        String password = req.getParameter("password");

        CreateUserDto createUserDto = CreateUserDto.create(fullname, password, email);

        try {
            userService.create(createUserDto);
            HttpSession session = req.getSession(false);
            session.setAttribute("createUserMessage", translateService.instant("user.create.succesfully"));
            resp.sendRedirect("/admin/list-user");
        } catch (I18nSupportedException e) {
            HttpSession session = req.getSession(false);
            session.setAttribute("createUserFailMessage", translateService.instant(e.getKey(), e.getArgs()));
            resp.sendRedirect("/admin/user-form.jsp");
        }



    }
}
