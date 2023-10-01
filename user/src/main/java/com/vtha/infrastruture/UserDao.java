package com.vtha.infrastruture;

import com.vtha.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends JpaRepository<User, Long> {

    @Query(value = "select user from User as user where user.userName=:name")
    public User getByUserName(String name);
}