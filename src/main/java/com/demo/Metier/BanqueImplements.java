package com.demo.Metier;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.demo.dao.CompteRepository;
import com.demo.dao.OperationRepository;
import com.demo.entities.Compte;
import com.demo.entities.Operation;


@Transactional
public class BanqueImplements implements iBanqueMetier{
	@Autowired
	private CompteRepository compteRep;
	private OperationRepository operationRep;
	@Override
	public Compte consulterCompte(Long idCompte) {
		Compte cp1 = compteRep.findOne(idCompte);
		
		if(cp1 == null) throw new RuntimeException("compte inexistant");
		return cp1;
	}

	@Override
	public void verser(Long idCompte, double montant) {
		Compte cp1 = consulterCompte(idCompte);
		Operation op1 = new Operation(new Date(), montant, "v", cp1);
		operationRep.save(op1);
		cp1.setSolde(cp1.getSolde() + montant);
		compteRep.save(cp1);
		
	}

	@Override
	public void retirer(Long idCompte, double montant) {
		Compte cp1 = consulterCompte(idCompte);
		Operation op1 = new Operation(new Date(), montant, "r", cp1);
		operationRep.save(op1);
		if(cp1.getSolde() < montant) throw new RuntimeException("solde insuffisant");
		cp1.setSolde(cp1.getSolde() - montant);
		compteRep.save(cp1);		
	}

	@Override
	public void virerArgent(Long idCompte1, Long idCompte2, double montant) {
		retirer(idCompte1, montant);
		verser(idCompte2, montant);
		
		
	}

	@Override
	public List<Operation> historiqueOperation(Long idCompte) {
		// TODO Auto-generated method stub
		return null;
	}

}
