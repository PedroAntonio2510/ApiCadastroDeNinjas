package dev.java10x.cadastroninjas.User;

import lombok.Builder;

@Builder
public record UserRequest(String name,
                          String email,
                          String password) {
}
