package com.edson.jwtapi.controller;


import com.edson.jwtapi.domain.user.AuthenticationDTO;
import com.edson.jwtapi.domain.user.LoginResponseDTO;
import com.edson.jwtapi.domain.user.RegisterDTO;
import com.edson.jwtapi.domain.user.User;
import com.edson.jwtapi.security.TokenService;
import com.edson.jwtapi.repositories.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth")
public class AuthenticationController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserRepository repository;
    @Autowired
    private TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid AuthenticationDTO data){
        System.out.println("AuthenticationDTO:: " + data);
        UsernamePasswordAuthenticationToken usernamePassword = new UsernamePasswordAuthenticationToken(data.login(), data.password());
        System.out.println("usernamePassword:: " + usernamePassword);
//        Authentication auth = this.authenticationManager.authenticate(usernamePassword);
//        System.out.println("auth:: " + auth);
//        UserDetails userDetails = (UserDetails) auth.getPrincipal(); // Supondo que o principal seja do tipo UserDetails
//        String token = tokenService.generateToken((User) userDetails);
//        System.out.println("token:: " + token);
        return ResponseEntity.ok(new LoginResponseDTO("token"));
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody @Valid RegisterDTO data){

        System.out.println("RegisterDTO:: "+data);
        if(this.repository.findByLogin(data.login()) != null) return ResponseEntity.badRequest().build();

        String encryptedPassword = new BCryptPasswordEncoder().encode(data.password());
        User newUser = new User(data.login(), encryptedPassword, data.role());

        this.repository.save(newUser);

        return ResponseEntity.ok().build();
    }
}
