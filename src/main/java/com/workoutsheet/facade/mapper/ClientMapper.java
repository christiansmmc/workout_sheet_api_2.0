package com.workoutsheet.facade.mapper;

import com.workoutsheet.domain.Client;
import com.workoutsheet.facade.dto.client.ClientIdDTO;
import com.workoutsheet.facade.dto.client.ClientToCreateDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {UserMapper.class})
public interface ClientMapper {

    Client toEntity(ClientToCreateDTO dto);

    ClientIdDTO toIdDto(Client entity);
}
