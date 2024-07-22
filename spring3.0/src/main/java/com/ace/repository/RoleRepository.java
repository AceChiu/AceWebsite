package com.ace.repository;

import com.ace.entity.Role;

import java.util.Optional;

public interface RoleRepository extends BasicJpaRepository<Role> {
    Optional<Role> findByName(String name);
}
