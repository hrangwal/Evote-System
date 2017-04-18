package com.nyit.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.nyit.model.Candidate;

public interface CandidateRepository extends CrudRepository<Candidate, Long> {
	
	List<Candidate> findByName(String name);
//	Voter findByEmail(String email);
//	Voter findByUsername(String username);
//	List<Voter> findByNameContains(String name);
//	List<Voter> findByNameAndEmail(String name, String email);

}