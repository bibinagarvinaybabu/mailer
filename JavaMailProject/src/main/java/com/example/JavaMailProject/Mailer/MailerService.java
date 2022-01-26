package com.example.JavaMailProject.Mailer;

import java.util.List;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class MailerService {
	
	private final MailerRepository mailRepository;
	
	
	@Autowired
	public MailerService(MailerRepository mailRepository) {
		super();
		this.mailRepository = mailRepository;
	}



	public List<Mailer> getEmails(){
		return mailRepository.findAll();
	}



	public void SendMail(Mailer mailer) {
		
//	Optional<Mailer> MailByFirstname = mailRepository.FindMailByFirstname(mailer.getFirstname());
//		
//		if(MailByFirstname.isPresent()) {
//			throw new IllegalStateException("mail already send for that employee");
//		}
		mailRepository.save(mailer);
		try {
			JavaMail jMail = new JavaMail();
					jMail.SendMailAPI(mailer);
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}



	public void DeleteMailById(long deletebyID) {
		
		if(!mailRepository.existsById(deletebyID)) {
			throw new IllegalStateException("Mail with ID " + deletebyID + "does not exist");
		}
		
		mailRepository.deleteById(deletebyID);
		
	}

}
