package me.raylleremery.springdatajpatraining.repository;

import me.raylleremery.springdatajpatraining.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {
}
