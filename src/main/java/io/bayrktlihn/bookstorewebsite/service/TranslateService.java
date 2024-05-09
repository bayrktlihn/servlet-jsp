package io.bayrktlihn.bookstorewebsite.service;

import io.bayrktlihn.bookstorewebsite.enums.Language;

import java.util.List;

public interface TranslateService {

    String instant(Language language, String code, Object[] args);

    String instant(Language language, String code, Object[] args, String defaultMessage);

    String instant(Language language, String code);

    String instant(String code, Object[] args);

    String instant(String code, Object[] args, String defaultMessage);

    String instant(String code);

    void useLanguages(List<Language> languages);

    void useLanguage(Language language);
}
