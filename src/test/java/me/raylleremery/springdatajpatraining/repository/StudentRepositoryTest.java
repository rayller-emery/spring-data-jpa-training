package me.raylleremery.springdatajpatraining.repository;

import me.raylleremery.springdatajpatraining.entity.Guardian;
import me.raylleremery.springdatajpatraining.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudent() {
        var student = Student.builder()
                .emailId("email@email.com.br")
                .firstName("Rayller")
                .lastName("Emery")
                .build();

        studentRepository.save(student);

    }

    @Test
    public void saveStudentWithGuardian() {

        var guardian = Guardian.builder()
                .email("rayller@email.com.br")
                .name("Rayller")
                .mobile("999999999")
                .build();

        var student = Student.builder()
                .firstName("Rayller")
                .emailId("email@email.com.brr")
                .lastName("Emery")
                .guardian(guardian)
                .build();

        studentRepository.save(student);
    }

    @Test
    public void printAllStudent() {
        var studentList =
                studentRepository.findAll();

        System.out.println(" student list: " + studentList);
    }

    @Test
    public void printStudentByFirstName() {
        var students = studentRepository.findByFirstName("Rayller");

        System.out.println("students = " + students);
    }

    @Test
    public void printStudentByFirstNameContaining() {
        var students = studentRepository.findByFirstNameContaining("Ray");

        System.out.println("students = " + students);
    }

    @Test
    public void printStudentBasedOnGuardianName() {
        var students = studentRepository.findByGuardianName("Rayller");

        System.out.println("Students = " + students);
    }

    @Test
    public void printStudentByFirstNameAndLastName() {
        var student = studentRepository.findFirstByFirstNameAndLastName("Rayller", "Emery");

        System.out.println("students = " + student);
    }

    @Test
    public void printStudentByEmailAddress() {
        var student = studentRepository.getStudentByEmailAddress("email@email.com.br");
        System.out.println("student = " + student);
    }

    @Test
    public void printStudentFirstNameByEmailAddress() {
        var studentName = studentRepository.getStudentFirstNameByEmailAddress("email@email.com.br");
        System.out.println("student name = " + studentName);
    }

    @Test
    public void printStudentByEmailAddressNative() {
        var student = studentRepository.getStudentByEmailAddressNative("email@email.com.brr");
        System.out.println("student = " + student);
    }

    @Test
    public void printStudentByEmailAddressNativeNamedParam() {
        var student = studentRepository.getStudentByEmailAddressNativeNameParam("email@email.com.brr");
        System.out.println("student = " + student);
    }

    @Test
    public void updateStudentFirstNameByEmail() {
        studentRepository.updateStudentNameByEmailId(
                "Lerisson",
                "email@email.com.br"
        );
    }
}