package com.iasa.repairagency.controller;


import com.iasa.repairagency.dto.*;
import com.iasa.repairagency.service.ManagerService;
import com.iasa.repairagency.service.MasterService;
import com.iasa.repairagency.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class Controller {

    private final UserService userService;
    private final ManagerService managerService;
    private final MasterService masterService;


    @PostMapping("/new-user")
    String createUser(@RequestBody UserToCreateDto dto) {
        return userService.createUser(dto);
    }

    @PostMapping("/new-request")
    String createRequest(@RequestBody RequestToCreateDto dto) {
        return userService.createRequest(dto);
    }

    @GetMapping("/show-manager-request/{id}")
    List<RequestToViewDto> showManagerRequest(@PathVariable Long id) {
        return managerService.showRequestList(id);
    }

    @PutMapping("/accept-request")
    RequestToViewDto acceptRequest(@RequestBody RequestToAcceptDto dto) throws Exception {
        return managerService.acceptRequest(dto);
    }

    @GetMapping("/show-client-request/{id}")
    List<RequestToViewDto> showClientRequest(@PathVariable Long id){
        return userService.showRequestList(id);
    }

    @PutMapping("/reject-request")
    RequestToViewDto rejectRequest(@RequestBody RequestToRejectDto dto) throws Exception {
        return managerService.rejectRequest(dto);
    }

    @PutMapping("/implement-request/{id}")
    RequestToViewDto implementRequest(@PathVariable Long id) throws  Exception{
        return masterService.implementRequest(id);
    }

    @GetMapping("/show-request/{id}")
    RequestToViewFullDto showRequest(@PathVariable Long id) throws  Exception{
        return userService.showRequestInfo(id);
    }

    @PostMapping("/leave-feedback")
    RequestToViewFullDto leaveFeedback(@RequestBody FeedbackToLeaveDto dto) throws Exception {
        return userService.leaveFeedback(dto);
    }
}
