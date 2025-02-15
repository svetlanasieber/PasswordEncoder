import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class UserService {

    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository repository, PasswordEncoder passwordEncoder) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
    }

    public void registerUser(String username, String password, String email) {
        User user = User.builder()
                .username(username)
                .password(passwordEncoder.encode(password)) 
                .email(email)
                .build();

        repository.save(user);
    }
}
