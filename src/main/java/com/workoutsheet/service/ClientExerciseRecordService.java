package com.workoutsheet.service;

import com.workoutsheet.domain.ClientExerciseRecord;
import com.workoutsheet.repository.ClientExerciseRecordRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClientExerciseRecordService {

    private final ClientExerciseRecordRepository repository;

    public ClientExerciseRecord save(ClientExerciseRecord clientExerciseRecord) {
        return repository.save(clientExerciseRecord);
    }
}
