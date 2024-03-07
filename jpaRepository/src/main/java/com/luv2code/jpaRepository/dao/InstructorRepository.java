package com.luv2code.jpaRepository.dao;

import com.luv2code.jpaRepository.entity.Instructor;
import com.luv2code.jpaRepository.entity.InstructorDetail;
import jakarta.persistence.Id;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface InstructorRepository extends JpaRepository<Instructor,Integer> {

    @Query("select i from Instructor i where i.id = ?1")
    Instructor findInstructorById(int theId);

    @Query("select i from InstructorDetail i where i.id = ?1")
    InstructorDetail findInstructorDetailById(int theId);

//    @Modifying
//    @Query("delete from InstructorDetail i where i.id = ?1")
//    void deleteInstructorDetailById(int theId);
}
