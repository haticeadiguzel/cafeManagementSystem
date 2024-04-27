package cafe.management.cafe.management.api.controllers;

import cafe.management.cafe.management.business.abstracts.UserService;
import cafe.management.cafe.management.core.utilities.results.Result;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@AllArgsConstructor
@RequestMapping(path = "/users")
public class UsersController {
    UserService userService;

    @PostMapping(path = "/signup")
    public ResponseEntity<Result> signUp(@RequestBody(required = true) Map<String, String> requestMap) {
        ResponseEntity<Result> result = userService.signUp(requestMap);
        try {
            return result;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return ResponseEntity.status(result.getStatusCode()).body(result.getBody());
    };
}
