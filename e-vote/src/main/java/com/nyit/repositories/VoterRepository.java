package com.nyit.repositories;

import org.springframework.data.repository.CrudRepository;

import com.nyit.model.Voter;

import java.lang.String;
import java.util.List;

public interface VoterRepository extends CrudRepository<Voter, Long> {
	
	List<Voter> findByName(String name);
	Voter findByEmail(String email);
	Voter findByUsername(String username);
//	List<Voter> findByNameContains(String name);
//	List<Voter> findByNameAndEmail(String name, String email);

}