package com.example.JavaMailProject.Mailer;

import java.time.LocalDate;
import java.util.Properties;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Transient;

import org.springframework.beans.factory.annotation.Autowired;


@Entity
@javax.persistence.Table
public class Mailer {
	
	@Id
	@SequenceGenerator(
			name="mail_sequence",
			sequenceName = "mail_sequence",
			allocationSize = 1
			
			)
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "mail_sequence"
			)
	private long id;
	private String firstname;
	private String lastname;
	private String emp_id;
	private String to_address;
	@Column(columnDefinition="text")
	private String mailBody;
	@Transient
	private LocalDate sentTime;
	
	
	
	public Mailer() {
		super();
	}
	
	public Mailer(long id, String firstname, String lastname, String emp_id, String to_address, String mailBody) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.emp_id = emp_id;
		this.to_address = to_address;
		this.mailBody = mailBody;
		
	}
	
	

	public Mailer(String firstname, String lastname, String emp_id, String to_address, String mailBody) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.emp_id = emp_id;
		this.to_address = to_address;
		this.mailBody = mailBody;
		
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getEmp_id() {
		return emp_id;
	}
	public void setEmp_id(String emp_id) {
		this.emp_id = emp_id;
	}
	public String getTo_address() {
		return "bibinagarvinaybabu@gmail.com";
	}
	public void setTo_address(String to_address) {
		this.to_address = "bibinagarvinaybabu@gmail.com";
	}
	public String getMailBody() {
		return mailBody;
	}
	public void setMailBody(String mailBody) {
		this.mailBody = mailBody;
	}
	public LocalDate getSentTime() {
		return LocalDate.now();
	}
	public void setSentTime(LocalDate sentTime) {
		this.sentTime = sentTime;
	}
	@Override
	public String toString() {
		return "Mailer [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", emp_id=" + emp_id
				+ ", to_address=" + to_address + ", mailBody=" + mailBody + ", sentTime=" + sentTime + "]";
	}
	
	

}
