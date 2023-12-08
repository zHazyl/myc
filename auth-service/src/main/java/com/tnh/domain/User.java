package com.tnh.domain;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public record User (
    @Id String id,
    String username,
    String password,
    String authority
) {
}
