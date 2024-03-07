package com.luv2code.jpaRepository.dao;

import com.luv2code.jpaRepository.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query("select u from User u where u.atk = ?1")
    List<User> findAllByAtk(int atk);

    @Query("SELECT u FROM User u where u.agi between ?1 and ?2")
    List<User> findAllUserByAgi(int start,int end);


}
