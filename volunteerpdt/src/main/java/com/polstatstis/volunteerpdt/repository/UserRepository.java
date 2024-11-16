package com.polstatstis.volunteerpdt.repository;

/*
 * @author blessy
 */

import com.polstatstis.volunteerpdt.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
    User findByNim(String nim);
//    boolean existsByNim(String nim);
}
