package com.BankOnLine.BankOnLine.repository;

import com.BankOnLine.BankOnLine.models.Compte;
import org.springframework.data.repository.CrudRepository;

public interface CompteRepository extends CrudRepository<Compte,Long> {
}
