package com.workoutsheet.service;

import com.workoutsheet.domain.WorkoutExercise;
import com.workoutsheet.repository.WorkoutExerciseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WorkoutExerciseService {

    private final WorkoutExerciseRepository repository;

    public WorkoutExercise save(WorkoutExercise workoutExercise) {
        return repository.save(workoutExercise);
    }

    public List<WorkoutExercise> findAllByWorkoutId(Long workoutId) {
        return repository.findAllByWorkoutId(workoutId);
    }
}
