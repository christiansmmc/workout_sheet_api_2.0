package com.workoutsheet.facade.dto.exercise;

import com.workoutsheet.domain.enumeration.BodyPart;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ExerciseDTO {

    private Long id;

    private String name;

    private BodyPart bodyPart;
}
