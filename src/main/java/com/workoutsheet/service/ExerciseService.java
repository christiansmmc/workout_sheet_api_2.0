package com.workoutsheet.service;

import com.workoutsheet.domain.Client;
import com.workoutsheet.domain.Exercise;
import com.workoutsheet.repository.ExerciseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ExerciseService {

    private final ExerciseRepository repository;
    private final ClientService clientService;

    public List<Exercise> findAll() {
        Client client = clientService.getLoggedUser();
        return repository.findAll(client.getId());
    }

    public Exercise create(Exercise exercise) {
        Client client = clientService.getLoggedUser();

        exercise.setClient(client);

        return repository.save(exercise);
    }

    public Exercise findById(Long id) {
        return repository.findById(id)
                .orElseThrow();
    }
}
