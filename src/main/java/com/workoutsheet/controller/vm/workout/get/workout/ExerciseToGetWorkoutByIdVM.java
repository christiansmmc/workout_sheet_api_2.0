package com.workoutsheet.controller.vm.workout.get.workout;

import com.workoutsheet.domain.enumeration.BodyPart;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ExerciseToGetWorkoutByIdVM {

    private Long id;

    private String name;

    private BodyPart bodyPart;
}
