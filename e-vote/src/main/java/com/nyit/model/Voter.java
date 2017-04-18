package com.nyit.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="voters")
public class Voter {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	int id;
	@Column(unique=true)
	public String username; 
	@Column(unique=true)
	public String email;
	public String ssn;
	public String password;
	public String repassword;
	public String name;
	public String voterid;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSsn() {
		return ssn;
	}
	public void setSsn(String ssn) {
		this.ssn = ssn;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRepassword() {
		return repassword;
	}
	public void setRepassword(String repassword) {
		this.repassword = repassword;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getVoterid() {
		return voterid;
	}
	public void setVoterid(String voterid) {
		this.voterid = voterid;
	}
	public Voter(int id, String username, String email, String ssn, String password, String repassword, String name,
			String voterid) {
		super();
		this.id = id;
		this.username = username;
		this.email = email;
		this.ssn = ssn;
		this.password = password;
		this.repassword = repassword;
		this.name = name;
		this.voterid = voterid;
	}
	public Voter() {
		super();
	}
	@Override
	public String toString() {
		return "Voter [id=" + id + ", username=" + username + ", email=" + email + ", ssn=" + ssn + ", password="
				+ password + ", repassword=" + repassword + ", name=" + name + ", voterid=" + voterid + "]";
	}

}
