package com.workoutsheet.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Table(name = "client_record")
@Entity(name = "client_record")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class ClientRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "weight")
    private Double weight;

    @Column(name = "height")
    private Double height;

    @NotNull
    @Column(name = "date")
    @Builder.Default
    private LocalDate date = LocalDate.now();

    @OneToOne(optional = false)
    private Client client;
}
