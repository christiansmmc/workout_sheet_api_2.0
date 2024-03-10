package com.workoutsheet.domain;

import com.workoutsheet.domain.enumeration.BodyPart;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Table(name = "exercise")
@Entity(name = "exercise")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class Exercise {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(name = "name")
    private String name;

    @NotNull
    @Column(name = "body_part")
    @Enumerated(EnumType.STRING)
    private BodyPart bodyPart;

    @ManyToOne
    private Client client;
}
