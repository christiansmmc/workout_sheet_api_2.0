package com.workoutsheet.repository;

import com.workoutsheet.domain.ClientRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRecordRepository extends JpaRepository<ClientRecord, Long> {
}
