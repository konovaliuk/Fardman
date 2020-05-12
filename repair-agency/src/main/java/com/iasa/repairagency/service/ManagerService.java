package com.iasa.repairagency.service;

import com.iasa.repairagency.dto.RequestToAcceptDto;
import com.iasa.repairagency.dto.RequestToRejectDto;
import com.iasa.repairagency.dto.RequestToViewDto;
import com.iasa.repairagency.model.Request;
import com.iasa.repairagency.model.User;
import com.iasa.repairagency.repository.repoClasses.RequestRepoClass;
import com.iasa.repairagency.repository.repoClasses.UserRepoClass;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Log4j2
@Service
@RequiredArgsConstructor
public class ManagerService {

    private final RequestRepoClass requestRepoClass;
    private final UserRepoClass userRepoClass;

    public List<RequestToViewDto> showRequestList(Long managerId) {
        List<RequestToViewDto> dtos = new ArrayList<>();
        Optional<User> optionalUser = userRepoClass.findById(managerId);
        if (optionalUser.isPresent()) {
            List<Request> requests = requestRepoClass.getAllByManager(optionalUser.get());
            dtos = requests.stream().map(RequestToViewDto::new).collect(Collectors.toList());
        }
        return dtos;
    }

    public RequestToViewDto acceptRequest(RequestToAcceptDto dto) throws Exception {
        RequestToViewDto requestToViewDto = new RequestToViewDto();
        try {
            Optional<User> optionalMaster = userRepoClass.findByNameAndRole(dto.getMasterName(), "master");
            Optional<Request> optionalRequest = requestRepoClass.findById(dto.getRequestId());
            if ((optionalRequest.isPresent()) && (optionalMaster.isPresent())) {
                Request request = optionalRequest.get();
                request.setAccepted(true);
                request.setCost(dto.getCost());
                User master = optionalMaster.get();
                request.setMaster(master);
                requestRepoClass.save(request);
                requestToViewDto = new RequestToViewDto(request);
            }
            return requestToViewDto;
        } catch (Exception ex) {
            throw new Exception("Ooops! Something get wrong");
        }
    }

    public RequestToViewDto rejectRequest(RequestToRejectDto dto) throws Exception {
        RequestToViewDto requestToViewDto = new RequestToViewDto();
        try {
            Optional<Request> optionalRequest = requestRepoClass.findById(dto.getRequestId());
            if (optionalRequest.isPresent()) {
                Request request = optionalRequest.get();
                request.setAccepted(false);
                request.setReason(dto.getReason());
                requestRepoClass.save(request);
                requestToViewDto = new RequestToViewDto(request);
            }
            return requestToViewDto;
        } catch (Exception ex) {
            throw new Exception("Ooops! Something get wrong");
        }

    }
}
