package com.workoutsheet.controller;

import com.workoutsheet.controller.vm.workout.WorkoutToCreateVM;
import com.workoutsheet.controller.vm.workout.get.workout.WorkoutToGetByIdVM;
import com.workoutsheet.facade.WorkoutFacade;
import com.workoutsheet.facade.dto.workout.WorkoutDTO;
import com.workoutsheet.facade.dto.workout.WorkoutIdDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/api/workouts")
@RequiredArgsConstructor
public class WorkoutController {

    private final WorkoutFacade facade;

    @PostMapping("/")
    public ResponseEntity<WorkoutIdDTO> create(
            @RequestBody @Valid WorkoutToCreateVM vm
    ) throws URISyntaxException {
        WorkoutIdDTO response = facade.create(vm);

        return ResponseEntity
                .created(new URI("/api/workouts/" + response.getId()))
                .body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<WorkoutToGetByIdVM> findById(
            @RequestParam Long id
    ) {
        WorkoutToGetByIdVM response = facade.findById(id);
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/")
    public ResponseEntity<List<WorkoutDTO>> findAllByLoggedClient() {
        List<WorkoutDTO> response = facade.findAllByLoggedClient();
        return ResponseEntity.ok().body(response);
    }
}
