package maow.ncycloapi.exception;

public class ReceiverException {
    public static class AlreadyRegistered extends BaseException {
        public AlreadyRegistered(String message) {
            super(message);
        }
    }
}
