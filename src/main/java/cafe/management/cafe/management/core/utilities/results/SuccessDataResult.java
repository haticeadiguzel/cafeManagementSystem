package cafe.management.cafe.management.core.utilities.results;

import org.springframework.http.HttpStatus;

public class SuccessDataResult<T> extends DataResult<T> {
    public SuccessDataResult(T data, String message) {
        super(data, true, message);
    }

    public SuccessDataResult(T data) {
        super(data, true);
    }

    public SuccessDataResult(String message, HttpStatus httpStatus) {
        super(null, true, message);
    }

    public SuccessDataResult() {
        super(null, true);
    }
}
