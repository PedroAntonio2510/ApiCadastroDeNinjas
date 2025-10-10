package dev.java10x.cadastroninjas.User;

import lombok.Builder;

@Builder
public record UserResponse(Long id,
                           String name,
                           String email) {
}
