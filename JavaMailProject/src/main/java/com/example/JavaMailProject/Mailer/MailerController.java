package com.example.JavaMailProject.Mailer;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="api/v1/mailer")
public class MailerController {
	
	private final MailerService mailerService;
	
	
	@Autowired
	public MailerController(MailerService mailerService) {
		super();
		this.mailerService = mailerService;
	}
	
	@GetMapping("/index")
	public String index(HttpServletResponse response) {
		response.setHeader("Content-Type","text/html");
		return "index.html";
	}
	
	@GetMapping
	public List<Mailer> getEmails(){
		return mailerService.getEmails();
	}
	
	@PostMapping("/sendemail")
	public void SendNewMail(@RequestBody Mailer[] mailer) {
		for(int i=0; i<mailer.length; i++) {
		mailerService.SendMail(mailer[i]);
		}
	}
	
	@DeleteMapping(path = "/deleteByID/{deleteByID}")
	public void DeleteByID(@PathVariable("deleteByID") long deletebyID ) {
		
		mailerService.DeleteMailById(deletebyID);
		
	}

}
