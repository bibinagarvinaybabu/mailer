package com.example.JavaMailProject.Mailer;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;




@Repository
public interface MailerRepository extends JpaRepository<Mailer, Long>{
	
	
		@Query("SELECT s FROM Mailer s WHERE s.firstname = ?1")
		Optional<Mailer> FindMailByFirstname(String firstname);

}
