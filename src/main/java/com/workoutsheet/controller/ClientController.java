package com.workoutsheet.controller;

import com.workoutsheet.facade.ClientFacade;
import com.workoutsheet.facade.dto.client.ClientIdDTO;
import com.workoutsheet.facade.dto.client.ClientToCreateDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;

@RestController
@RequestMapping("/api/clients")
@RequiredArgsConstructor
public class ClientController {

    private final ClientFacade facade;

    @PostMapping
    public ResponseEntity<ClientIdDTO> create(
            @Valid @RequestBody ClientToCreateDTO dto
    ) throws URISyntaxException {
        ClientIdDTO response = facade.create(dto);

        return ResponseEntity
                .created(new URI("/api/clients/" + response.getId()))
                .body(response);
    }
}
