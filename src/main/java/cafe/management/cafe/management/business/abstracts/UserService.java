package cafe.management.cafe.management.business.abstracts;

import cafe.management.cafe.management.core.utilities.results.Result;
import org.springframework.http.ResponseEntity;

import java.util.Map;

public interface UserService {

    ResponseEntity<Result> signUp(Map<String, String> requestMap);
}
