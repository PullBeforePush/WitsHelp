package com.WitsHelp.WitsHelp.Repositories;

import com.WitsHelp.WitsHelp.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
