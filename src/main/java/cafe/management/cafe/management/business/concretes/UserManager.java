package cafe.management.cafe.management.business.concretes;

import cafe.management.cafe.management.business.abstracts.UserService;
import cafe.management.cafe.management.constants.CafeConstants;
import cafe.management.cafe.management.core.utilities.mappers.ModelMapperService;
import cafe.management.cafe.management.core.utilities.results.ErrorResult;
import cafe.management.cafe.management.core.utilities.results.Result;
import cafe.management.cafe.management.core.utilities.results.SuccessResult;
import cafe.management.cafe.management.dataAccess.abstracts.UserRepository;
import cafe.management.cafe.management.entities.concretes.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Objects;

@Slf4j
@Service
public class UserManager implements UserService {
    private final UserRepository userRepository;
    private final ModelMapperService modelMapperService;

    public UserManager(UserRepository userRepository, ModelMapperService modelMapperService) {
        this.userRepository = userRepository;
        this.modelMapperService = modelMapperService;
    }

    @Override
    public ResponseEntity<Result> signUp(Map<String, String> requestMap) {
        log.info("Inside signup {}", requestMap);

        try {
            if (validateSignUpMap(requestMap)) {
                User user = userRepository.findByEmailId(requestMap.get("email"));
                if(Objects.isNull(user)){
                    User userMapper = modelMapperService.forResponse().map(requestMap, User.class);
                    userRepository.save(userMapper);
                    return ResponseEntity.ok(new SuccessResult("Successfully Registered."));
                } else {
                    return ResponseEntity.badRequest().body(new ErrorResult("Email already exists."));
                }
            } else {
                return ResponseEntity.badRequest().body(new ErrorResult(CafeConstants.INVALID_DATA));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new ErrorResult(CafeConstants.SOMETHING_WENT_WRONG));
    }

    private boolean validateSignUpMap(Map<String, String> requestMap) {
        return requestMap.containsKey("name") && requestMap.containsKey("contactNumber")
                && requestMap.containsKey("email") && requestMap.containsKey("password");
    }
}
