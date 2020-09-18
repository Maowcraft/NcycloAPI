package maow.ncycloapi.exception;

public abstract class BaseException extends Exception {
    private final String message;

    public BaseException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
