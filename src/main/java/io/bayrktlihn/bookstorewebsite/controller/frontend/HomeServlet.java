package io.bayrktlihn.bookstorewebsite.controller.frontend;

import io.bayrktlihn.bookstorewebsite.context.ApplicationContext;
import io.bayrktlihn.bookstorewebsite.dto.CategoryDto;
import io.bayrktlihn.bookstorewebsite.entity.Category;
import io.bayrktlihn.bookstorewebsite.service.CategoryService;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("")
public class HomeServlet extends HttpServlet {

    private final CategoryService categoryService = ApplicationContext.getBean(CategoryService.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String homepage = "frontend/index.jsp";

        throw new RuntimeException();

//        List<CategoryDto> categories = categoryService.findAll();
//
//
//        req.setAttribute("categories", categories);
//
//        RequestDispatcher requestDispatcher = req.getRequestDispatcher(homepage);
//        requestDispatcher.forward(req, resp);

    }
}
