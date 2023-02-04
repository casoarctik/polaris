package io.back.polaris.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import io.back.polaris.models.database.tables.User;

public interface UserRepository extends JpaRepository<User, Long> {}
