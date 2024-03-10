package com.workoutsheet.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Table(name = "workout_exercise")
@Entity(name = "workout_exercise")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class WorkoutExercise {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "exercise_load")
    @Builder.Default
    private Double load = 0.0;

    @ManyToOne(optional = false)
    private Workout workout;

    @ManyToOne(optional = false)
    private Exercise exercise;
}
