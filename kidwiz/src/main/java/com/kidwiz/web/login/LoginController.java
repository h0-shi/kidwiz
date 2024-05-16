/*package com.kidwiz.web.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/api")
public class LoginController {
	
    @Autowired
    private LoginService loginService;
    
    @PostMapping("/login")
    public String login(@RequestBody LoginDTO dto, HttpSession session, HttpServletResponse response) {
    	LoginDTO loginedUser = loginService.login(dto.getId(), dto.getPw());
        if (loginedUser != null) {
            session.setAttribute("USER", loginedUser);
            Cookie sessionCookie = new Cookie("SESSIONID", session.getId());
            sessionCookie.setHttpOnly(true);
            sessionCookie.setPath("/");
            response.addCookie(sessionCookie);
            return "Login successful";
        } else {
        	return "Invalid credentials";
        }
    }
}*/