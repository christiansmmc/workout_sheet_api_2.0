package com.workoutsheet.facade;

import com.workoutsheet.domain.Exercise;
import com.workoutsheet.facade.dto.exercise.ExerciseDTO;
import com.workoutsheet.facade.dto.exercise.ExerciseIdDTO;
import com.workoutsheet.facade.dto.exercise.ExerciseToCreateDTO;
import com.workoutsheet.facade.mapper.ExerciseMapper;
import com.workoutsheet.service.ExerciseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ExerciseFacade {

    private final ExerciseMapper mapper;
    private final ExerciseService service;

    @Transactional(readOnly = true)
    public List<ExerciseDTO> findAll() {
        return mapper.toDto(service.findAll());
    }

    @Transactional
    public ExerciseIdDTO create(ExerciseToCreateDTO dto) {
        Exercise exercise = mapper.toEntity(dto);
        return mapper.toIdDto(service.create(exercise));
    }
}
