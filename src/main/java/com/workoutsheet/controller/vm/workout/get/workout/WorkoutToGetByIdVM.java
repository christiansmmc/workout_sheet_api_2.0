package com.workoutsheet.controller.vm.workout.get.workout;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WorkoutToGetByIdVM {

    private Long id;

    private String name;

    private List<WorkoutExerciseToGetWorkoutByIdVM> workoutExercises;
}
