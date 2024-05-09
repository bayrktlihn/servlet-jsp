package io.bayrktlihn.bookstorewebsite.listener;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

@WebListener
public class AppContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        try {
            Class.forName("io.bayrktlihn.bookstorewebsite.context.ApplicationContext");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
