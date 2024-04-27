package cafe.management.cafe.management.core.utilities.results;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class Result {
    private final boolean success;
    private String message;
}
