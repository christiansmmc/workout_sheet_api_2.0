package com.workoutsheet.repository;

import com.workoutsheet.domain.ClientExerciseRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientExerciseRecordRepository extends JpaRepository<ClientExerciseRecord, Long> {

}
