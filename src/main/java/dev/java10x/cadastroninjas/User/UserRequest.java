package dev.java10x.cadastroninjas.User;

import lombok.Builder;

import java.util.List;

@Builder
public record UserRequest(String name,
                          String email,
                          String password,
                          String role) {
}
