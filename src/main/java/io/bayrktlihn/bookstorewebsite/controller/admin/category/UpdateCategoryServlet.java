package io.bayrktlihn.bookstorewebsite.controller.admin.category;

import io.bayrktlihn.bookstorewebsite.context.ApplicationContext;
import io.bayrktlihn.bookstorewebsite.dto.UpdateCategoryDto;
import io.bayrktlihn.bookstorewebsite.exception.I18nSupportedException;
import io.bayrktlihn.bookstorewebsite.service.CategoryService;
import io.bayrktlihn.bookstorewebsite.service.TranslateService;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/admin/update-category")
public class UpdateCategoryServlet extends HttpServlet {

    private final CategoryService categoryService = ApplicationContext.getBean(CategoryService.class);
    private final TranslateService translateService = ApplicationContext.getBean(TranslateService.class);

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        long id = Long.parseLong(req.getParameter("id"));
        String name = req.getParameter("name");

        UpdateCategoryDto updateUserDto = UpdateCategoryDto.create(id, name);

        try {
            categoryService.update(updateUserDto);
            resp.sendRedirect("/admin/list-category");
        } catch (I18nSupportedException e) {
            HttpSession session = req.getSession(false);
            String translation = translateService.instant(e.getKey(), e.getArgs());
            session.setAttribute("categoryNameAlreadyExists", translation);
            resp.sendRedirect("/admin/edit-category?id=" + id);
        }
    }
}
