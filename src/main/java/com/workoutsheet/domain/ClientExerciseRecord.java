package com.workoutsheet.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Table(name = "client_exercise_record")
@Entity(name = "client_exercise_record")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class ClientExerciseRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "exercise_load")
    private Double load = 0.0;

    @NotNull
    @Column(name = "date")
    @Builder.Default
    private LocalDate date = LocalDate.now();

    @ManyToOne(optional = false)
    private Client client;

    @ManyToOne(optional = false)
    private Exercise exercise;
}
