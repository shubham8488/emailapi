package com.email.emailapi.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.email.emailapi.model.EmailRequest;
import com.email.emailapi.model.EmailResponse;
import com.email.emailapi.service.EmailService;

@RestController
@CrossOrigin
public class EmailController {
	
	@Autowired
	EmailService emailservice;
	
	@GetMapping("/welcome")
	public String welcome() {
		return "welcome page loaded successfully !";
	}

	@PostMapping("/sendEmail")
	public ResponseEntity<?> sendEmail(@RequestBody EmailRequest request ) {
		String to=request.getTo();
		String subject=request.getSubject();
		String body=request.getBody();
		String message="";
		
		boolean flag=emailservice.sendEmail(to, subject, body);
		if(flag==true) {
			message="Email Send successfully !";
		}
		else {
			return new ResponseEntity<>(new EmailResponse("Email Send unsuccessfully !") , HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(new EmailResponse(message) , HttpStatus.OK);
	}
}
