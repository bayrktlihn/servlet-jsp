package io.bayrktlihn.bookstorewebsite.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class I18nSupportedException extends RuntimeException {

    private String key;
    private Object[] args;
    private String defaultMessage;


    public static I18nSupportedException create(String key) {
        return new I18nSupportedException(key) {
        };
    }

    public static I18nSupportedException create(String key, String defaultMessage) {
        return new I18nSupportedException(key, defaultMessage) {
        };
    }

    public static I18nSupportedException create(String key, Object[] args) {
        return new I18nSupportedException(key, args) {
        };
    }


    public static I18nSupportedException create(String key, Object[] args, String defaultMessage) {
        return new I18nSupportedException(key, args, defaultMessage) {
        };
    }

    protected I18nSupportedException(String key) {
        this.key = key;
    }

    protected I18nSupportedException(String key, String defaultMessage) {
        this.key = key;
        this.defaultMessage = defaultMessage;
    }

    protected I18nSupportedException(String key, Object[] args) {
        this.key = key;
        this.args = args;
    }

    protected I18nSupportedException(String key, Object[] args, String defaultMessage) {
        this.key = key;
        this.args = args;
        this.defaultMessage = defaultMessage;
    }
}
