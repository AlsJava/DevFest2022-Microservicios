package edu.alsjava.deffest.controller;


import edu.alsjava.deffest.model.network.request.CalculateFactorialRequest;
import edu.alsjava.deffest.model.network.request.CreateUserRequest;
import edu.alsjava.deffest.model.network.response.CalculateFactorialResponse;
import edu.alsjava.deffest.model.network.response.CreateUserResponse;
import edu.alsjava.deffest.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RequiredArgsConstructor
@RestController
@RequestMapping("/demo")
public class DemoController {

    private final UserService userService;

    @PostMapping("/create")
    public ResponseEntity<CreateUserResponse> get(@Valid @RequestBody CreateUserRequest createUserRequest) {
        return ResponseEntity.ok(userService.createUser(createUserRequest));
    }

    @PostMapping("/factorial")
    public ResponseEntity<CalculateFactorialResponse> calculateFactorial(@Valid @RequestBody CalculateFactorialRequest calculateFactorialRequest) {
        return ResponseEntity.ok(userService.calculateFactorial(calculateFactorialRequest));
    }

}
