package edu.alsjava.deffest.controller;


import edu.alsjava.deffest.model.network.request.CreateUserRequest;
import edu.alsjava.deffest.model.network.response.CreateUserResponse;
import edu.alsjava.deffest.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;


@RequiredArgsConstructor
@RestController
@RequestMapping("/demo")
public class DemoController {

    private final UserService userService;

    @PutMapping("/create")
    public ResponseEntity<CreateUserResponse> get(@Valid @RequestBody CreateUserRequest createUserRequest) {
        return ResponseEntity.ok(userService.createUser(createUserRequest));
    }

}
