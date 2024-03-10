package com.workoutsheet.service;

import com.workoutsheet.domain.Client;
import com.workoutsheet.domain.User;
import com.workoutsheet.exception.EmailAlreadyExistsException;
import com.workoutsheet.repository.ClientRepository;
import com.workoutsheet.util.SecurityUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClientService {

    private final ClientRepository repository;
    private final UserService userService;
    private final ClientRecordService clientRecordService;

    public Client create(Client client) {
        if (userService.isEmailRegistered(client.getUser().getEmail())) {
            throw new EmailAlreadyExistsException();
        }

        User user = userService.create(client.getUser());

        client.setUser(user);
        Client clientCreated = repository.save(client);

        clientRecordService.create(clientCreated);

        return clientCreated;
    }

    public Client getLoggedUser() {
        String loggedUserEmail = SecurityUtils.getCurrentUserLogin()
                .orElseThrow();

        return repository.findByUserEmail(loggedUserEmail)
                .orElseThrow();
    }
}
