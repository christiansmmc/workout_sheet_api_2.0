package com.workoutsheet.facade.dto.exercise;

import com.workoutsheet.domain.enumeration.BodyPart;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ExerciseToCreateDTO {

    @NotBlank
    private String name;

    @NotNull
    private BodyPart bodyPart;
}
