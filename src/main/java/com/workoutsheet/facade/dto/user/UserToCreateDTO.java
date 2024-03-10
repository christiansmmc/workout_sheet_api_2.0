package com.workoutsheet.facade.dto.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserToCreateDTO {

    @NotBlank
    private String email;

    @NotBlank
    private String password;
}
