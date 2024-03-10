package com.workoutsheet.controller.vm.workout;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ExercisesToCreateVM {

    @NotNull
    private Double load;

    @NotNull
    private Long exerciseId;
}
