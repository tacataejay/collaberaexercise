package com.erniejohn.app.todolistmaven.Repo;

import com.erniejohn.app.todolistmaven.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {
}