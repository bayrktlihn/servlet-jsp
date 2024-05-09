package io.bayrktlihn.bookstorewebsite.exception;

public class UserNotFoundException extends I18nSupportedException {

    public UserNotFoundException(Long id) {
        super("user.not.found", new Object[]{id});
    }


}
