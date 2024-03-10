package com.workoutsheet.service;

import com.workoutsheet.controller.vm.workout.WorkoutToCreateVM;
import com.workoutsheet.controller.vm.workout.get.workout.ExerciseToGetWorkoutByIdVM;
import com.workoutsheet.controller.vm.workout.get.workout.WorkoutExerciseToGetWorkoutByIdVM;
import com.workoutsheet.controller.vm.workout.get.workout.WorkoutToGetByIdVM;
import com.workoutsheet.domain.*;
import com.workoutsheet.exception.WorkoutNotFromClientException;
import com.workoutsheet.repository.WorkoutRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class WorkoutService {

    private final WorkoutRepository repository;
    private final ClientService clientService;
    private final ExerciseService exerciseService;
    private final WorkoutExerciseService workoutExerciseService;
    private final ClientExerciseRecordService clientExerciseRecordService;

    public Workout create(WorkoutToCreateVM vm) {
        Client client = clientService.getLoggedUser();

        Workout workout = Workout
                .builder()
                .name(vm.getName())
                .client(client)
                .build();

        Workout workoutCreated = repository.save(workout);

        vm.getExercises()
                .forEach(exerciseToCreate -> {
                    Exercise exercise = exerciseService.findById(exerciseToCreate.getExerciseId());

                    this.createWorkoutExercise(
                            exerciseToCreate.getLoad(),
                            workoutCreated,
                            exercise
                    );

                    this.createClientExerciseRecord(
                            exerciseToCreate.getLoad(),
                            client,
                            exercise
                    );
                });

        return workoutCreated;
    }

    private void createWorkoutExercise(
            Double load,
            Workout workoutCreated,
            Exercise exercise
    ) {
        WorkoutExercise workoutExercise = WorkoutExercise
                .builder()
                .load(load)
                .workout(workoutCreated)
                .exercise(exercise)
                .build();

        workoutExerciseService.save(workoutExercise);
    }

    private void createClientExerciseRecord(
            Double load,
            Client client,
            Exercise exercise
    ) {
        ClientExerciseRecord clientExerciseRecord = ClientExerciseRecord
                .builder()
                .load(load)
                .client(client)
                .exercise(exercise)
                .build();

        clientExerciseRecordService.save(clientExerciseRecord);
    }

    public WorkoutToGetByIdVM findById(Long id) {
        Client client = clientService.getLoggedUser();
        Workout workout = repository.findById(id)
                .orElseThrow(); // TODO

        if (!workout.getClient().equals(client)) {
            throw new WorkoutNotFromClientException();
        }

        List<WorkoutExercise> workoutExercises = workoutExerciseService.findAllByWorkoutId(id);

        return getWorkoutToGetByIdVm(workout, workoutExercises);
    }

    public List<Workout> findAllByLoggedClient() {
        Client client = clientService.getLoggedUser();
        return repository.findAllByClientId(client.getId());
    }

    private WorkoutToGetByIdVM getWorkoutToGetByIdVm(
            Workout workout,
            List<WorkoutExercise> workoutExercises
    ) {
        List<WorkoutExerciseToGetWorkoutByIdVM> workoutExerciseVm = workoutExercises
                .stream()
                .map(workoutExercise -> {
                    ExerciseToGetWorkoutByIdVM exercise = ExerciseToGetWorkoutByIdVM
                            .builder()
                            .id(workoutExercise.getExercise().getId())
                            .name(workoutExercise.getExercise().getName())
                            .bodyPart(workoutExercise.getExercise().getBodyPart())
                            .build();

                    return WorkoutExerciseToGetWorkoutByIdVM
                            .builder()
                            .load(workoutExercise.getLoad())
                            .exercise(exercise)
                            .build();
                })
                .collect(Collectors.toList());

        return WorkoutToGetByIdVM
                .builder()
                .id(workout.getId())
                .name(workout.getName())
                .workoutExercises(workoutExerciseVm)
                .build();

    }
}
