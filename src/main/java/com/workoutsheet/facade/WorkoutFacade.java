package com.workoutsheet.facade;

import com.workoutsheet.controller.vm.workout.WorkoutToCreateVM;
import com.workoutsheet.controller.vm.workout.get.workout.WorkoutToGetByIdVM;
import com.workoutsheet.domain.Workout;
import com.workoutsheet.facade.dto.workout.WorkoutDTO;
import com.workoutsheet.facade.dto.workout.WorkoutIdDTO;
import com.workoutsheet.facade.mapper.WorkoutMapper;
import com.workoutsheet.service.WorkoutService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class WorkoutFacade {

    private final WorkoutMapper mapper;
    private final WorkoutService service;

    @Transactional
    public WorkoutIdDTO create(WorkoutToCreateVM vm) {
        Workout workout = service.create(vm);
        return mapper.toIdDto(workout);
    }

    @Transactional(readOnly = true)
    public WorkoutToGetByIdVM findById(Long id) {
        return service.findById(id);
    }

    @Transactional(readOnly = true)
    public List<WorkoutDTO> findAllByLoggedClient() {
        return service.findAllByLoggedClient()
                .stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }
}
