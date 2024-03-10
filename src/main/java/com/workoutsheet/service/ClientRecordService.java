package com.workoutsheet.service;

import com.workoutsheet.domain.Client;
import com.workoutsheet.domain.ClientRecord;
import com.workoutsheet.repository.ClientRecordRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClientRecordService {

    private final ClientRecordRepository repository;

    public ClientRecord create(Client client) {
        ClientRecord clientRecord = new ClientRecord();

        if (client.getWeight() != null) clientRecord.setWeight(client.getWeight());
        if (client.getHeight() != null) clientRecord.setHeight(client.getHeight());
        clientRecord.setClient(client);

        return repository.save(clientRecord);
    }

}
