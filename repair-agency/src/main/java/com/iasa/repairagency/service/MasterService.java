package com.iasa.repairagency.service;

import com.iasa.repairagency.dto.RequestToViewDto;
import com.iasa.repairagency.model.Request;
import com.iasa.repairagency.repository.repoClasses.RequestRepoClass;
import com.iasa.repairagency.repository.repoClasses.UserRepoClass;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MasterService {

    private final UserRepoClass userRepoClass;
    private final RequestRepoClass requestRepoClass;

    public RequestToViewDto implementRequest(Long requestId) throws Exception {
        RequestToViewDto dto = new RequestToViewDto();
        try {
            Optional<Request> optionalRequest = requestRepoClass.findById(requestId);
            if (optionalRequest.isPresent()) {
                Request request = optionalRequest.get();
                request.setCompleted(true);
                requestRepoClass.save(request);
                dto = new RequestToViewDto(request);
            }
            return dto;
        } catch (Exception e) {
            throw new Exception("Oooops! Somethink get wrong");
        }
    }
}
