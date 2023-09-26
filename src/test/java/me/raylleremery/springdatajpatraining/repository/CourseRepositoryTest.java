package me.raylleremery.springdatajpatraining.repository;

import me.raylleremery.springdatajpatraining.entity.Course;
import me.raylleremery.springdatajpatraining.entity.Student;
import me.raylleremery.springdatajpatraining.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

@SpringBootTest
class CourseRepositoryTest {

    @Autowired
    private CourseRepository repository;

    @Test
    public void printCourses() {
        var courses =
                repository.findAll();

        System.out.println("courses = " + courses);
    }

    @Test
    public void saveCourseWithTeacher() {
        var teacher =
                Teacher.builder()
                        .firstName("Pryanka")
                        .lastName("Syth")
                        .build();

        var course =
                Course.builder()
                        .title("Python")
                        .credit(6)
                        .teacher(teacher)
                        .build();

        repository.save(course);
    }

    @Test
    public void findAllPagination() {
        var firstPageWithThreeRecords =
                PageRequest.of(0, 3);
        var secondPageWithTwoRecords =
                PageRequest.of(1, 2);

        var coursesFirstPage = repository.findAll(firstPageWithThreeRecords).getContent();
        var coursesSecondPage = repository.findAll(secondPageWithTwoRecords).getContent();

        var totalElements = repository.findAll(firstPageWithThreeRecords).getTotalElements();
        var totalPages = repository.findAll(firstPageWithThreeRecords).getTotalPages();

        System.out.println(" totalPages = " + totalPages);

        System.out.println(" totalElements = " + totalElements);

        System.out.println(" courses = " + coursesFirstPage);
        System.out.println(" courses = " + coursesSecondPage);
    }

    @Test
    public void findAllSorting() {
        Pageable sortByTitle =
                PageRequest.of(0, 2, Sort.by("title"));
        Pageable sortByCreditDesc =
                PageRequest.of(0, 2, Sort.by("credit").descending());
        Pageable sortByTitleAndCreditDesc =
                PageRequest.of(0, 2, Sort.by("title").descending().and(Sort.by("credit")));

        var coursesByTitle =
                repository.findAll(sortByTitle).getContent();
        var coursesByCredit =
                repository.findAll(sortByCreditDesc).getContent();
        var coursesByTitleAndCredit =
                repository.findAll(sortByTitleAndCreditDesc).getContent();

        System.out.println("sort by title " + coursesByTitle);
        System.out.println("sort by credit " + coursesByCredit);
        System.out.println("sort by title and credit" + coursesByTitleAndCredit);

    }

    @Test
    public void saveCourseWithStudentAndTeacher() {
        var teacher =
                Teacher.builder()
                        .firstName("Lenka")
                        .lastName("Straus")
                        .build();
        var course =
                Course.builder()
                        .title("AI")
                        .credit(12)
                        .teacher(teacher)
                        .build();

        var student =
                Student.builder()
                        .firstName("Ricardo")
                        .lastName("da Silva")
                        .emailId("ricardo@gmail.com")
                        .build();

        course.addStudent(student);
        repository.save(course);
    }
}