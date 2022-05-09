package pl.goread.payload;

import pl.goread.model.Role;

public record AuthenticationResponse(String token, Long id, String email, Role role) {}
