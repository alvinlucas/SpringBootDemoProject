package com.exemple.springbootdemoproject.repository;

import com.exemple.springbootdemoproject.model.Etudiant;
import org.springframework.data.repository.CrudRepository;

public interface EtudiantRepository extends CrudRepository<Etudiant, Integer> {
}
