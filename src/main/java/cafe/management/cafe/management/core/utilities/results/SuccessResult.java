package cafe.management.cafe.management.core.utilities.results;

import org.springframework.http.HttpStatus;

public class SuccessResult extends Result {
    public SuccessResult() {
        super(true);
    }

    public SuccessResult(String message) {
        super(true, message);
    }
}
