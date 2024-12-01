package exception;

public class DuplicateUserException extends RuntimeException {
    // 기본 생성자
    public DuplicateUserException() {
        super();
    }

    // 메시지를 전달할 수 있는 생성자
    public DuplicateUserException(String message) {
        super(message);
    }

    // 메시지와 원인(또는 예외)을 전달할 수 있는 생성자
    public DuplicateUserException(String message, Throwable cause) {
        super(message, cause);
    }

    // 원인(예외)을 전달할 수 있는 생성자
    public DuplicateUserException(Throwable cause) {
        super(cause);
    }
}
