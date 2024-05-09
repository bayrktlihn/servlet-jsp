package io.bayrktlihn.bookstorewebsite.controller.admin.category;

import io.bayrktlihn.bookstorewebsite.context.ApplicationContext;
import io.bayrktlihn.bookstorewebsite.exception.UserNotFoundException;
import io.bayrktlihn.bookstorewebsite.service.CategoryService;
import io.bayrktlihn.bookstorewebsite.service.TranslateService;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/admin/delete-category")
public class DeleteCategoryServlet extends HttpServlet {

    private final CategoryService categoryService = ApplicationContext.getBean(CategoryService.class);
    private final TranslateService translateService = ApplicationContext.getBean(TranslateService.class);


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        long id = Long.parseLong(req.getParameter("id"));
        try {
            categoryService.deleteById(id);
            HttpSession session = req.getSession(false);
            String translation = translateService.instant("category.delete.successfully", new Object[]{id});
            session.setAttribute("deletedCategoryMessage", translation);
            resp.sendRedirect("/admin/list-category");
        } catch (UserNotFoundException e) {
            resp.sendRedirect("/admin/list-category");

        }
    }
}
