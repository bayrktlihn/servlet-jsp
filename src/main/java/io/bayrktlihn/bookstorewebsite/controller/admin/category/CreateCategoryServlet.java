package io.bayrktlihn.bookstorewebsite.controller.admin.category;

import io.bayrktlihn.bookstorewebsite.context.ApplicationContext;
import io.bayrktlihn.bookstorewebsite.dto.CreateCategoryDto;
import io.bayrktlihn.bookstorewebsite.exception.CategoryNameAlreadyExistsException;
import io.bayrktlihn.bookstorewebsite.service.CategoryService;
import io.bayrktlihn.bookstorewebsite.service.TranslateService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/admin/create-category")
public class CreateCategoryServlet extends HttpServlet {

    private final CategoryService categoryService = ApplicationContext.getBean(CategoryService.class);
    private final TranslateService translateService = ApplicationContext.getBean(TranslateService.class);

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");

        CreateCategoryDto createCategory = CreateCategoryDto.create(name);

        try {
            categoryService.create(createCategory);
            HttpSession session = req.getSession(false);
            String translation = translateService.instant("category.created.successfully");
            session.setAttribute("categoryCreatedSuccessfully", translation);
            resp.sendRedirect("/admin/list-category");
        } catch (CategoryNameAlreadyExistsException e) {
            HttpSession session = req.getSession(false);
            String translation = translateService.instant(e.getKey(), e.getArgs());
            session.setAttribute("categoryNameAlreadyExists", translation);
            resp.sendRedirect("/admin/category-form.jsp");
        }



    }
}
