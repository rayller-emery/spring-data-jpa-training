package me.raylleremery.springdatajpatraining.repository;

import me.raylleremery.springdatajpatraining.entity.CourseMaterial;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseMaterialRepository extends JpaRepository<CourseMaterial, Long> {
}
