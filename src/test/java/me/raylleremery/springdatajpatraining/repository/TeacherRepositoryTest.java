package me.raylleremery.springdatajpatraining.repository;

import me.raylleremery.springdatajpatraining.entity.Course;
import me.raylleremery.springdatajpatraining.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class TeacherRepositoryTest {

    @Autowired
    private TeacherRepository repository;

    @Test
    public void saveTeacher() {

        var coursesDBA =
                Course.builder()
                        .title("DBA")
                        .credit(5)
                        .build();
        var coursesJava =
                Course.builder()
                        .title("Java")
                        .credit(6)
                        .build();

        var teacher =
                Teacher.builder()
                        .firstName("Roberto")
                        .lastName("Andrade")
                        //.courses(List.of(coursesDBA, coursesJava))
                        .build();

        repository.save(teacher);
    }
}