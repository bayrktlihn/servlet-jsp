package io.bayrktlihn.bookstorewebsite.service.impl;

import io.bayrktlihn.bookstorewebsite.enums.Language;
import io.bayrktlihn.bookstorewebsite.service.TranslateService;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class TranslateServiceImpl implements TranslateService {

    private Language useLanguage;
    private Set<Language> useLanguages = new HashSet<>();
    private Map<Language, Map<String, String>> languageTranslations = new HashMap<>();


    {
        HashMap<String, String> usEnTranslations = new HashMap<>();
        usEnTranslations.put("user.create.succesfully", "The user was created successfully.");
        usEnTranslations.put("category.created.successfully", "The category was created successfully.");
        usEnTranslations.put("user.email.already.exists", "%s is already exists.");
        usEnTranslations.put("user.not.found", "User %s id is not found");
        usEnTranslations.put("user.delete.successfully", "User %s id is deleted.");
        usEnTranslations.put("category.delete.successfully", "Category %s id is deleted.");
        usEnTranslations.put("category.name.already.exists", "Category %s is already exists");
        usEnTranslations.put("login.invalid", "Email or password is not valid.");
        usEnTranslations.put("successfully.login", "Logout successfully");

        languageTranslations.put(Language.US_EN, usEnTranslations);
    }


    @Override
    public String instant(Language language, String code) {
        return instant(language, code, new Object[0]);
    }

    @Override
    public String instant(Language language, String code, Object[] args) {
        return instant(language, code, args, "");
    }

    @Override
    public String instant(Language language, String code, Object[] args, String defaultMessage) {

        if (useLanguages.stream().noneMatch(lang -> lang.equals(language))) {
            throw new RuntimeException();
        }

        Map<String, String> translations = languageTranslations.get(language);

        if (translations == null) {
            throw new RuntimeException("This language not supported");
        }

        String translation = translations.getOrDefault(code, defaultMessage);

        if (args != null && args.length > 0) {
            translation = String.format(translation, args);
        }

        return translation;
    }

    @Override
    public String instant(String code, Object[] args) {
        return instant(useLanguage, code, args);
    }

    @Override
    public String instant(String code, Object[] args, String defaultMessage) {
        return instant(useLanguage, code, args, defaultMessage);

    }

    @Override
    public String instant(String code) {
        return instant(useLanguage, code);
    }

    @Override
    public void useLanguages(List<Language> languages) {
        useLanguages = new HashSet<>(languages);
    }

    @Override
    public void useLanguage(Language language) {
        this.useLanguages.add(language);

        this.useLanguage = language;
    }
}
