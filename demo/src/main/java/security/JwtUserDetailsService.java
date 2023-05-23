package security;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class JwtUserDetailsService implements UserDetailsService {
    private String password;
    // Implement the required methods based on your user authentication logic
    // ...

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Load user details based on username
        // ...
        return new User(username, password, new ArrayList<>());
    }
}

