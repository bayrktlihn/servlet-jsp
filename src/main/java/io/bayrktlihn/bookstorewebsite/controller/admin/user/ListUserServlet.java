package io.bayrktlihn.bookstorewebsite.controller.admin.user;

import io.bayrktlihn.bookstorewebsite.context.ApplicationContext;
import io.bayrktlihn.bookstorewebsite.entity.User;
import io.bayrktlihn.bookstorewebsite.service.UserService;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/admin/list-user")
public class ListUserServlet extends HttpServlet {

    private UserService userServiceImpl = ApplicationContext.getBean(UserService.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = "/admin/user-list.jsp";
        List<User> users = userServiceImpl.findAll();
        req.setAttribute("users", users);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher(path);
        requestDispatcher.forward(req, resp);
    }
}
