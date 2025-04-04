package com.softuni.repository;

import com.softuni.model.entity.Exercise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ExerciseRepository extends JpaRepository<Exercise,Long> {

    @Query("SELECT e.name from Exercise e ORDER BY e.name")
    List<String>findAllExNames();

    Optional<Exercise> findByName(String name);
}
