package cafe.management.cafe.management.core.utilities.results;

import org.springframework.http.HttpStatus;

public class ErrorResult extends Result {
    public ErrorResult() {
        super(false);
    }

    public ErrorResult(String message) {
        super(false, message);
    }
}
