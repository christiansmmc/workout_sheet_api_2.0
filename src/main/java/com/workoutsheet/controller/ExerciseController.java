package com.workoutsheet.controller;

import com.workoutsheet.facade.ExerciseFacade;
import com.workoutsheet.facade.dto.exercise.ExerciseDTO;
import com.workoutsheet.facade.dto.exercise.ExerciseIdDTO;
import com.workoutsheet.facade.dto.exercise.ExerciseToCreateDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/api/exercises")
@RequiredArgsConstructor
public class ExerciseController {

    private final ExerciseFacade facade;

    @GetMapping
    public ResponseEntity<List<ExerciseDTO>> findAll() {
        List<ExerciseDTO> response = facade.findAll();

        return ResponseEntity
                .ok()
                .body(response);
    }

    @PostMapping
    public ResponseEntity<ExerciseIdDTO> create(
            @RequestBody @Valid ExerciseToCreateDTO dto
    ) throws URISyntaxException {
        ExerciseIdDTO response = facade.create(dto);

        return ResponseEntity
                .created(new URI("/api/exercises/" + response.getId()))
                .body(response);
    }
}
