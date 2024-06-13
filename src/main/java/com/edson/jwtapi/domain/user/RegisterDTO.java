package com.edson.jwtapi.domain.user;

public record RegisterDTO(String login, String password, UserRole role,String name) {
}
