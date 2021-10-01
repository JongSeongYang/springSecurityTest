package com.jsyang.springSecurityTest.controller;

import com.jsyang.springSecurityTest.dto.Auth;
import com.jsyang.springSecurityTest.service.StaffService;
import com.jsyang.springSecurityTest.util.JwtFilter;
import com.jsyang.springSecurityTest.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
@Slf4j
public class AuthController {

    private final JwtUtil jwtUtil;
    private final AuthenticationManager authenticationManager;
    private static final Logger logger = LoggerFactory.getLogger(AuthController.class);


    @PostMapping("/check")
    public String check() {
        logger.info("check");
        return "success";
    }

    @PostMapping("/authenticate")
    public String generateToken(@RequestBody Auth.LoginRequest request)  {
        Authentication authentication = new UsernamePasswordAuthenticationToken(request.getLoginId(), request.getLoginPWD());
        return jwtUtil.generateToken(request.getLoginId());
    }

}
