package com.luv2code.jpaRepository.dao;

import com.luv2code.jpaRepository.entity.InstructorDetail;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface InstructorDetailRepository extends JpaRepository<InstructorDetail,Integer> {

//    @Modifying
//    @Query("delete from InstructorDetail i where i.id = ?1")
//    void deleteInstructorDetailById(int theId);
}
