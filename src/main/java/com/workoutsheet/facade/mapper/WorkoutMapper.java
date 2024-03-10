package com.workoutsheet.facade.mapper;

import com.workoutsheet.domain.Workout;
import com.workoutsheet.facade.dto.workout.WorkoutDTO;
import com.workoutsheet.facade.dto.workout.WorkoutIdDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface WorkoutMapper {

    WorkoutIdDTO toIdDto(Workout workout);

    WorkoutDTO toDto(Workout workout);
}
