package com.UST.EmployeeExample.repository;

import com.UST.EmployeeExample.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Long> {
}
