package com.nyit.model;
public class Results {
	
	public String candidateId;
	public String voterId;
	public String name;
	public Results(String candidateId, String voterId, String name) {
		super();
		this.candidateId = candidateId;
		this.voterId = voterId;
		this.name = name;
	}
	@Override
	public String toString() {
		return "Results [candidateId=" + candidateId + ", voterId=" + voterId + ", name=" + name + "]";
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	
}