package me.raylleremery.springdatajpatraining.repository;

import jakarta.transaction.Transactional;
import me.raylleremery.springdatajpatraining.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    List<Student> findByFirstName(String firstName);

    List<Student> findByFirstNameContaining(String name);

    List<Student> findByLastNameNotNull();

    List<Student> findByGuardianName(String name);

    Student findFirstByFirstNameAndLastName(String firstName, String lastName);

    //JPQL
    @Query("select s from Student s where s.emailId = ?1")
    Student getStudentByEmailAddress(String emailId);

    @Query("select s.firstName from Student s where s.emailId = ?1")
    String getStudentFirstNameByEmailAddress(String emailId);

    //NativeQuery
    @Query(
            value = "SELECT * FROM tbl_student s WHERE s.email_address=?1",
            nativeQuery = true
    )
    Student getStudentByEmailAddressNative(String emailId);

    @Query(
            value = "SELECT * FROM tbl_student s WHERE s.email_address=:emailId",
            nativeQuery = true
    )
    Student getStudentByEmailAddressNativeNameParam(@Param("emailId") String emailId);

    @Modifying
    @Transactional
    @Query(
            value = "UPDATE tbl_student SET first_name = ?1 WHERE email_address=?2",
            nativeQuery = true
    )
    int updateStudentNameByEmailId(String firstName, String lastName);
}
