package com.nyit.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="votes")
public class Votes {
	
	public String candidateId;
	public String voterId;
	public String name;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	int id;

	public Votes(String candidateId, String voterId, int id, String name) {
		super();
		this.candidateId = candidateId;
		this.voterId = voterId;
		this.id = id;
		this.name = name;
	}

	public Votes() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getCandidateId() {
		return candidateId;
	}

	public void setCandidateId(String candidateId) {
		this.candidateId = candidateId;
	}

	public String getVoterId() {
		return voterId;
	}

	public void setVoterId(String voterId) {
		this.voterId = voterId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Votes [candidateId=" + candidateId + ", voterId=" + voterId + ", name=" + name + ", id=" + id + "]";
	}
	
}
