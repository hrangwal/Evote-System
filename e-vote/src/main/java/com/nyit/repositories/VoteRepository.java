package com.nyit.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.nyit.model.Results;
import com.nyit.model.Votes;

public interface VoteRepository extends CrudRepository<Votes, Long> {
	
	 @Query(value = "Select count(distinct (v.voter_id)) as voter_id, v.candidate_id as candidate_id, c.name as name from votes v join candidates c on v.candidate_id= c.candidateid group by candidate_id;"
			 , nativeQuery=true)
	 List<Results> findResults();
//	List<Voter> findByNameContains(String name);
//	List<Voter> findByNameAndEmail(String name, String email);

}