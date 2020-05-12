package com.iasa.repairagency.service;

import com.iasa.repairagency.dto.*;
import com.iasa.repairagency.model.Feedback;
import com.iasa.repairagency.model.Request;
import com.iasa.repairagency.model.User;
import com.iasa.repairagency.repository.repoClasses.FeedbackRepoClass;
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
public class UserService {

    private final UserRepoClass userRepoClass;
    private final RequestRepoClass requestRepoClass;
    private final FeedbackRepoClass feedbackRepoClass;


    public String createUser(UserToCreateDto dto) {
        try {
            User user = new User(dto.getLogin(), dto.getPassword(), dto.getName(), dto.getPhone(), dto.getRole());
            userRepoClass.save(user);
            return "user was created";
        } catch (Exception ex) {
            log.error(ex.getMessage());
            return "user has not being created";
        }

    }

    public String createRequest(RequestToCreateDto dto) {
        try {
            Optional<User> optionalManager = userRepoClass.findByNameAndRole(dto.getManagerName(), "manager");
            Optional<User> optionalClient = userRepoClass.findById(dto.getClientId());
            if ((optionalManager.isPresent()) && (optionalClient.isPresent())) {
                User manager = optionalManager.get();
                User client = optionalClient.get();
                Request request = new Request(dto.getDescription(), client, manager);
                requestRepoClass.save(request);
                return "request has been created. Manager " + manager.getName().split(" ")[1] + " will review it as soon as possible";
            } else return "There is no manager with this name";

        } catch (Exception e) {
            return "Ooop! Something get wrong.....";
        }
    }

    public List<RequestToViewDto> showRequestList(Long clientId) {
        List<RequestToViewDto> dtos = new ArrayList<>();
        Optional<User> optionalUser = userRepoClass.findById(clientId);
        if (optionalUser.isPresent()) {
            List<Request> requests = requestRepoClass.getAllByClient(optionalUser.get());
            dtos = requests.stream().map(RequestToViewDto::new).collect(Collectors.toList());
        }
        return dtos;
    }

    public RequestToViewFullDto leaveFeedback(FeedbackToLeaveDto dto) throws Exception {
        RequestToViewFullDto requestToViewFullDto = new RequestToViewFullDto();
        Optional<User> optionalUser = userRepoClass.findById(dto.getClientId());
        Optional<Request> optionalRequest = requestRepoClass.findById(dto.getRequestId());
        if ((optionalUser.isPresent()) && (optionalRequest.isPresent())) {
            Request request = optionalRequest.get();
            User author = optionalUser.get();
            Feedback feedback = new Feedback();
            feedback.setAuthor(author);
            feedback.setRequest(request);
            feedback.setText(dto.getText());
            feedbackRepoClass.save(feedback);
            requestToViewFullDto = new RequestToViewFullDto(request);
        } else throw new Exception("Oops! Something get wrong");
        return requestToViewFullDto;
    }

    public RequestToViewFullDto showRequestInfo(Long id) throws Exception {
        Optional<Request> optionalRequest = requestRepoClass.findById(id);
        RequestToViewFullDto dto = new RequestToViewFullDto();
        if (optionalRequest.isPresent()) {
            dto = new RequestToViewFullDto(optionalRequest.get());
        } else throw new Exception("Oops! Something get wrong");
        return dto;
    }
}
