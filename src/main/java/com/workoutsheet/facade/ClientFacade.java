package com.workoutsheet.facade;

import com.workoutsheet.domain.Client;
import com.workoutsheet.facade.dto.client.ClientIdDTO;
import com.workoutsheet.facade.dto.client.ClientToCreateDTO;
import com.workoutsheet.facade.mapper.ClientMapper;
import com.workoutsheet.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ClientFacade {

    private final ClientMapper mapper;
    private final ClientService service;

    @Transactional
    public ClientIdDTO create(ClientToCreateDTO dto) {
        Client client = mapper.toEntity(dto);
        return mapper.toIdDto(service.create(client));
    }
}
