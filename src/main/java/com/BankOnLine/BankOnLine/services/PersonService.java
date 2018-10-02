package com.BankOnLine.BankOnLine.services;


import com.BankOnLine.BankOnLine.models.Person;
import com.BankOnLine.BankOnLine.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PersonService {

    @Autowired
    PersonRepository personRepo;

    public Iterable<Person> getPersonList() {
        return this.personRepo.findAll();
    }

    //modifier ou créer une personne
    public Person unpdateOrCreate(Person person){
        Person personToAdd = person;
        if (person.getId() != 0){
            if(this.personRepo.findById(person.getId()).isPresent()) {
                personToAdd = personRepo.findById(person.getId()).get();
                personToAdd.setNom(person.getNom());
                personToAdd.setPrenom(person.getPrenom());
                personToAdd.setDateNaissance(person.getDateNaissance());
                personToAdd.setLogin(person.getLogin());
                personToAdd.setMdp(person.getMdp());
                personToAdd.setTel(person.getTel());
                personToAdd.setAdresse(person.getAdresse());
                personToAdd.setTypePerson(person.getTypePerson());
                personToAdd = person;
                this.personRepo.save(person);
            }
        }
        this.personRepo.save(person);
        return  personToAdd;
    }

    //Vérifier l'exiestence d'une personne dans la base de donnée
    public boolean existPerson(long id){
        return (this.personRepo.findById(id)).isPresent();
    }

    //récupérer une personne précise
    public Person displayPerson(long id) {
        return this.personRepo.findById(id).get();
    }

    //Supprimer une personne
    public void deleteCompte(long id){
        if(personRepo.findById(id) != null){
            this.personRepo.deleteById(id);
        }
    }

}
