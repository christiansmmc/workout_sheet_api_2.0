package com.workoutsheet.repository;

import com.workoutsheet.domain.Exercise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExerciseRepository extends JpaRepository<Exercise, Long> {

    @Query("SELECT e FROM exercise e WHERE e.client IS null OR e.client.id = ?1")
    List<Exercise> findAll(Long clientId);
}
