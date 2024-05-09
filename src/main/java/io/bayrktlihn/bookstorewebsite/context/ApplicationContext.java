package io.bayrktlihn.bookstorewebsite.context;

import io.bayrktlihn.bookstorewebsite.enums.Language;
import io.bayrktlihn.bookstorewebsite.mapper.CategoryMapper;
import io.bayrktlihn.bookstorewebsite.mapper.UserMapper;
import io.bayrktlihn.bookstorewebsite.repository.CategoryRepository;
import io.bayrktlihn.bookstorewebsite.repository.UserRepository;
import io.bayrktlihn.bookstorewebsite.repository.impl.CategoryRepositoryImpl;
import io.bayrktlihn.bookstorewebsite.repository.impl.UserRepositoryImpl;
import io.bayrktlihn.bookstorewebsite.service.CategoryService;
import io.bayrktlihn.bookstorewebsite.service.TranslateService;
import io.bayrktlihn.bookstorewebsite.service.UserService;
import io.bayrktlihn.bookstorewebsite.service.impl.CategoryServiceImpl;
import io.bayrktlihn.bookstorewebsite.service.impl.TranslateServiceImpl;
import io.bayrktlihn.bookstorewebsite.service.impl.UserServiceImpl;

import java.util.HashMap;
import java.util.Map;

public class ApplicationContext {

    private static final Map<Class<?>, Map<String, ?>> BEANS = new HashMap<>();

    static {
        initialize();
    }

    private static void initialize() {
        UserRepository userRepository = new UserRepositoryImpl();
        CategoryRepository categoryRepository = new CategoryRepositoryImpl();
        UserService userService = new UserServiceImpl(userRepository, UserMapper.INSTANCE);
        CategoryService categoryService = new CategoryServiceImpl(categoryRepository, CategoryMapper.INSTANCE);
        TranslateService translateService = new TranslateServiceImpl();
        translateService.useLanguage(Language.US_EN);


        HashMap<String, Object> translateServiceBeans = new HashMap<>();
        translateServiceBeans.put("default", translateService);
        BEANS.put(TranslateService.class, translateServiceBeans);


        HashMap<String, Object> userRepositoryBeans = new HashMap<>();
        userRepositoryBeans.put("default", userRepository);
        BEANS.put(UserRepository.class, userRepositoryBeans);

        HashMap<String, Object> userServiceBeans = new HashMap<>();
        userServiceBeans.put("default", userService);
        BEANS.put(UserService.class, userServiceBeans);

        HashMap<String, Object> categoryRepositoryBeans = new HashMap<>();
        categoryRepositoryBeans.put("default", categoryRepository);
        BEANS.put(CategoryRepository.class, categoryRepositoryBeans);

        HashMap<String, Object> categoryServiceBeans = new HashMap<>();
        categoryServiceBeans.put("default", categoryService);
        BEANS.put(CategoryService.class, categoryServiceBeans);
    }


    public static <T> T getBean(Class<T> clazz, String name) {

        Map<String, ?> clazzMap = BEANS.get(clazz);

        T o = (T) clazzMap.get(name);
        if (o == null) {
            o = (T) clazzMap.get("default");
        }
        return o;
    }

    public static <T> T getBean(Class<T> clazz) {
        return getBean(clazz, "default");
    }

}
