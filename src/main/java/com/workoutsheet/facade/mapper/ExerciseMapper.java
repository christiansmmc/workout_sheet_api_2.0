package com.workoutsheet.facade.mapper;

import com.workoutsheet.domain.Exercise;
import com.workoutsheet.facade.dto.exercise.ExerciseDTO;
import com.workoutsheet.facade.dto.exercise.ExerciseIdDTO;
import com.workoutsheet.facade.dto.exercise.ExerciseToCreateDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ExerciseMapper {

    Exercise toEntity(ExerciseToCreateDTO dto);

    List<ExerciseDTO> toDto(List<Exercise> exercises);

    ExerciseIdDTO toIdDto(Exercise exercises);
}
