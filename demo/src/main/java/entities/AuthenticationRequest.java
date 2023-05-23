package entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor @AllArgsConstructor // Constructors, getters, and setters
public class AuthenticationRequest {
    private String username;
    private String password;


}



