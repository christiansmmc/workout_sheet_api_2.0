package com.workoutsheet.facade.mapper;

import com.workoutsheet.domain.User;
import com.workoutsheet.facade.dto.user.UserToCreateDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User toEntity(UserToCreateDTO dto);
}
