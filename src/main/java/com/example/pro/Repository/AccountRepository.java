package com.example.pro.Repository;

import com.example.pro.model.user;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<user,Long> {

    user findByUsername(String username);

}
