package group.rxcloud.capa.bff.exception;

/**
 * @author wangjun
 * @date 2021/10/25
 */
public class IllegalInvocationRequestException extends RuntimeException {

    public IllegalInvocationRequestException() {
    }

    public IllegalInvocationRequestException(String message) {
        super(message);
    }

    public IllegalInvocationRequestException(String message, Throwable cause) {
        super(message, cause);
    }
}
