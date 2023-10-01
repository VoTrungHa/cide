package com.vtha.infrastruture;

import com.vtha.domain.UserRole;
import com.vtha.enums.UserRoleEnum;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRoleDao extends JpaRepository<UserRole, Long> {

    public UserRole findByRole(UserRoleEnum userRoleEnum);
}