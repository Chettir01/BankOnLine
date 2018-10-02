package com.BankOnLine.BankOnLine.services;

import com.BankOnLine.BankOnLine.models.Compte;
import com.BankOnLine.BankOnLine.repository.CompteRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class CompteService {

    @Autowired
    CompteRepository compteRepo;

    public Iterable<Compte> getCompteList() {
        return this.compteRepo.findAll();
    }

    public Compte unpdateOrCreate(Compte compte){
        Compte compteToAdd = compte;
        if (compte.getId() != 0){
            if(this.compteRepo.findById(compte.getId()).isPresent()) {
                compteToAdd = compteRepo.findById(compte.getId()).get();
                compteToAdd.setIdPerson(compte.getIdPerson());
                compteToAdd.setIban(compte.getIban());
                compteToAdd.setNumCompte(compte.getNumCompte());
                compteToAdd.setSolde(compte.getSolde());
                compteToAdd.setTypeCompte(compte.getTypeCompte());
                compteToAdd = compte;
                this.compteRepo.save(compte);
            }
        }
        this.compteRepo.save(compte);
        return  compteToAdd;
    }

    public boolean existCompte(long id){
        return (this.compteRepo.findById(id)).isPresent();
    }

    public Compte displayCompte(long id) {
        return this.compteRepo.findById(id).get();
    }

    public void deleteCompte(long id){
        if(compteRepo.findById(id) != null){
            this.compteRepo.deleteById(id);
        }
    }
}
