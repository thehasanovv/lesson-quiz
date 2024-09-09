package az.atl.lessonquiz.exception;

public class NotFoundException extends RuntimeException {

    private NotFoundException(String message) {
        super(message);
    }
}
