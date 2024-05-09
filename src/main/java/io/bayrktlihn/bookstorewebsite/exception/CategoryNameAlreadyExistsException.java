package io.bayrktlihn.bookstorewebsite.exception;

public class CategoryNameAlreadyExistsException extends I18nSupportedException{
    public CategoryNameAlreadyExistsException(Object[] args) {
        super("category.name.already.exists", args);
    }
}
