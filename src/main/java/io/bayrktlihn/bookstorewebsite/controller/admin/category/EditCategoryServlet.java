package io.bayrktlihn.bookstorewebsite.controller.admin.category;

import io.bayrktlihn.bookstorewebsite.context.ApplicationContext;
import io.bayrktlihn.bookstorewebsite.dto.CategoryDto;
import io.bayrktlihn.bookstorewebsite.exception.UserNotFoundException;
import io.bayrktlihn.bookstorewebsite.service.CategoryService;
import io.bayrktlihn.bookstorewebsite.service.TranslateService;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/admin/edit-category")
public class EditCategoryServlet extends HttpServlet {

    private final CategoryService categoryService = ApplicationContext.getBean(CategoryService.class);
    private final TranslateService translateService = ApplicationContext.getBean(TranslateService.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long id = Long.parseLong(req.getParameter("id"));

        CategoryDto category = null;
        try {
            category = categoryService.findById(id);
            req.setAttribute("category", category);
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/admin/edit-category.jsp");
            requestDispatcher.forward(req, resp);
        } catch (UserNotFoundException e) {
            resp.sendRedirect("/admin/list-category");
        }


    }
}
