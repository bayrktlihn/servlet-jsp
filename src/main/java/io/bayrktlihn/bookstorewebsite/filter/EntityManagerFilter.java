package io.bayrktlihn.bookstorewebsite.filter;


import io.bayrktlihn.bookstorewebsite.config.JpaConfig;
import io.bayrktlihn.bookstorewebsite.context.EntityManagerContextHolder;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;

import java.io.IOException;

@WebFilter(urlPatterns = "/*", filterName = "filter1")
public class EntityManagerFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        try {
            EntityManagerContextHolder.setEntityManager(JpaConfig.getNewEntityManager());

            chain.doFilter(request, response);

        } finally {
            EntityManagerContextHolder.clearContext();
        }

    }
}
