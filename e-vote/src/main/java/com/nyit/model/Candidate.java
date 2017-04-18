package com.nyit.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="candidates")
public class Candidate {
	
	@Column(unique=true)
	public String name;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	int id;
	
	public String candidateid;

	public Candidate(String name, int id, String candidateid) {
		super();
		this.name = name;
		this.id = id;
		this.candidateid = candidateid;
	}

	public Candidate() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Candidate [name=" + name + ", id=" + id + ", candidateid=" + candidateid + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCandidateid() {
		return candidateid;
	}

	public void setCandidateid(String candidateid) {
		this.candidateid = candidateid;
	}

	
}
