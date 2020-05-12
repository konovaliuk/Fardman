package com.iasa.repairagency.repository.repoClasses;


import com.iasa.repairagency.model.Request;
import com.iasa.repairagency.model.User;
import com.iasa.repairagency.repository.RequestRepository;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.Manager;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class RequestRepoClass {

    private final RequestRepository requestRepository;

    public void save(Request request) {
        requestRepository.save(request);
    }

    public List<Request> getAllByManager(User manager){
        return requestRepository.getAllByManager(manager);
    }

    public Optional<Request> findById(Long id){
        return requestRepository.findById(id);
    }

    public List<Request> getAllByClient(User client){
        return requestRepository.getAllByClient(client);
    }
}
