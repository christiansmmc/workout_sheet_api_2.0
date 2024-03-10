package com.workoutsheet.controller.vm.workout.get.workout;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WorkoutExerciseToGetWorkoutByIdVM {

    private Long id;

    private Double load;

    private ExerciseToGetWorkoutByIdVM exercise;
}
