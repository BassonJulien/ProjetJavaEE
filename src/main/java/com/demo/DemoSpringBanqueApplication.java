package com.demo;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.demo.Metier.iBanqueMetier;
import com.demo.dao.ClientRepository;
import com.demo.dao.CompteRepository;
import com.demo.entities.Client;
import com.demo.entities.Compte;

@SpringBootApplication
public class DemoSpringBanqueApplication implements CommandLineRunner{
	@Autowired
	private ClientRepository clientRep;
	@Autowired
	private CompteRepository compteRep;


	public static void main(String[] args) {
		SpringApplication.run(DemoSpringBanqueApplication.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {
		Client c1 = clientRep.save(new Client("jbasson", "juju@yolo.fr"));
		Client c2 = clientRep.save(new Client("lcaminale", "lolo@yolo.fr"));

		
		Compte cp1 = compteRep.save(new Compte(new Date(), 6000, c1));
		Compte cp2 = compteRep.save(new Compte(new Date(), 600, c1));
		Compte cp3 = compteRep.save(new Compte(new Date(), 2000, c2));
		
		iBanqueMetier metier ;

		// TODO Auto-generated method stub
		
	}
}
