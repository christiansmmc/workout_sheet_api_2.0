package com.workoutsheet.facade.dto.client;

import com.workoutsheet.facade.dto.user.UserToCreateDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClientToCreateDTO {

    @NotBlank
    private String name;

    private Double weight;

    private Double height;

    @Valid
    private UserToCreateDTO user;
}
