package dev.java10x.cadastroninjas.config;

import lombok.Builder;

import java.util.List;

@Builder
public record JwtUserData(Long id, String name, String email, String role) {
}
