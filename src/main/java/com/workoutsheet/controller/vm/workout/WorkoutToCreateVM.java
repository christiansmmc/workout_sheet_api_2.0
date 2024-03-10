package com.workoutsheet.controller.vm.workout;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WorkoutToCreateVM {

    @NotBlank
    private String name;

    @Valid
    @NotEmpty
    private List<ExercisesToCreateVM> exercises;
}
