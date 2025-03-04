package com.softuni.repository;

import com.softuni.model.entity.Role;
import com.softuni.model.entity.RoleNameEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role,Long> {
    Optional<Role> findByName(RoleNameEnum roleNameEnum);
}
