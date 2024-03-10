package com.workoutsheet.controller;

import com.workoutsheet.config.JwtConfig;
import com.workoutsheet.controller.vm.JwtTokenVM;
import com.workoutsheet.controller.vm.LoginVM;
import com.workoutsheet.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/authenticate")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationManager authenticationManager;
    private final JwtConfig jwtConfig;

    @PostMapping
    public ResponseEntity<JwtTokenVM> login(
            @RequestBody @Valid LoginVM vm
    ) {
        UsernamePasswordAuthenticationToken usernamePassword = new UsernamePasswordAuthenticationToken(
                vm.getEmail(),
                vm.getPassword()
        );
        Authentication auth = authenticationManager.authenticate(usernamePassword);

        String token = jwtConfig.generateToken((User) auth.getPrincipal());

        return ResponseEntity.ok().body(new JwtTokenVM(token));
    }
}
