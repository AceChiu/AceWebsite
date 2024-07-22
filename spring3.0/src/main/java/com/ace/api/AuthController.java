package com.ace.api;

import com.ace.common.ResourcePaths;
import com.ace.dto.AuthResponseDto;
import com.ace.dto.LoginDto;
import com.ace.dto.UserProfileDto;
import com.ace.entity.UserProfile;
import com.ace.repository.RoleRepository;
import com.ace.security.JWTGenerator;
import com.ace.service.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Objects;

@RestController
@RequestMapping("/api/" + ResourcePaths.AUTH)
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserProfileService userProfileService;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private JWTGenerator jwtGenerator;

    @GetMapping(value = "/isExistUser/{username}")
    public boolean isExistedUser(@PathVariable String username) {
        UserProfile userProfile = userProfileService.findByUsername(username);
        if (Objects.nonNull(userProfile)) {
            return true;
        } else {
            return false;
        }
    }

    @PostMapping(value = "/login")
    public ResponseEntity<AuthResponseDto> login(@RequestBody LoginDto loginDto) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginDto.getUsername(), loginDto.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = jwtGenerator.generateToken(authentication);
        return new ResponseEntity<>(new AuthResponseDto(token), HttpStatus.OK);
    }

    @PostMapping(value = "/register")
    public UserProfileDto create(@RequestBody UserProfileDto userProfileDto) {
        UserProfile userProfile = userProfileService.create(userProfileDto);
        return UserProfileDto.builder()
                .username(userProfile.getUsername())
                .email(userProfile.getEmail())
                .name(userProfile.getName())
                .familyName(userProfile.getFamilyName())
                .givenName(userProfile.getGivenName())
                .build();
    }
}
