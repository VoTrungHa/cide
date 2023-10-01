package com.vtha.infrastruture;

import com.vtha.domain.Identify;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IdentityDao extends JpaRepository<Identify, Long> {

    public Identify findByLoginName(String loginName);
}
