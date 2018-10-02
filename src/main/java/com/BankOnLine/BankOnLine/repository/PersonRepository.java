package com.BankOnLine.BankOnLine.repository;

import com.BankOnLine.BankOnLine.models.Person;
import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<Person, Long> {

}
