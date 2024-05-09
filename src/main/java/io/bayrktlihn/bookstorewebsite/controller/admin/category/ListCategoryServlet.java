package io.bayrktlihn.bookstorewebsite.controller.admin.category;

import io.bayrktlihn.bookstorewebsite.context.ApplicationContext;
import io.bayrktlihn.bookstorewebsite.dto.CategoryDto;
import io.bayrktlihn.bookstorewebsite.service.CategoryService;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/admin/list-category")
public class ListCategoryServlet extends HttpServlet {

    private CategoryService categoryService = ApplicationContext.getBean(CategoryService.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = "/admin/category-list.jsp";
        List<CategoryDto> categories = categoryService.findAll();
        req.setAttribute("categories", categories);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher(path);
        requestDispatcher.forward(req, resp);
    }
}
