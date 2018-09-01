package com.soccerleague.SoccerLeague.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="members")
public class Member {

	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long memberid;
	private String membername;
	private String memberrole;
	
	// This is the many in the one to many relationship
	@ManyToOne
	@JoinColumn(name = "teamid")
	private Team team;
	
	public Member() {
		
	}

	public Member(long memberid, String membername, String memberrole, Team team) {
		this.memberid = memberid;
		this.membername = membername;
		this.memberrole = memberrole;
		this.team = team;
	}
	public Member(String membername, String memberrole, Team team) {
		
		this.membername = membername;
		this.memberrole = memberrole;
		this.team = team;
	}


	public long getMemberid() {
		return memberid;
	}

	public void setMemberid(long memberid) {
		this.memberid = memberid;
	}

	public String getMembername() {
		return membername;
	}

	public void setMembername(String membername) {
		this.membername = membername;
	}

	public String getMemberrole() {
		return memberrole;
	}

	public void setMemberrole(String memberrole) {
		this.memberrole = memberrole;
	}

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	@Override
	public String toString() {
		return "Member [memberid=" + memberid + ", membername=" + membername + ", memberrole=" + memberrole + ", team="
				+ team + "]";
	}
	
	
	
}
