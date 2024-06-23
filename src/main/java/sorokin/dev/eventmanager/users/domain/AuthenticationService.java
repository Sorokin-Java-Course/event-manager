package sorokin.dev.eventmanager.users.domain;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import sorokin.dev.eventmanager.security.JwtTokenManager;
import sorokin.dev.eventmanager.users.api.SignInRequest;

@Service
public class AuthenticationService {

    private final JwtTokenManager jwtTokenManager;
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    public AuthenticationService(
            JwtTokenManager jwtTokenManager,
            UserService userService,
            PasswordEncoder passwordEncoder
    ) {
        this.jwtTokenManager = jwtTokenManager;
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    public String authenticateUser(SignInRequest request) {
        if (!userService.isUserExistsByLogin(request.login())) {
            throw new BadCredentialsException("Bad credentials");
        }
        var user = userService.getUserByLogin(request.login());
        if (!passwordEncoder.matches(request.password(), user.passwordHash())) {
            throw new BadCredentialsException("Bad credentials");
        }

        return jwtTokenManager.generateToken(user);
    }
}
