package com.soccerleague.SoccerLeague.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="teams")
public class Team {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long teamid;
	private String teamname;
	//private List[] members;
	
	// this is the "one" in the one to many relationship
	@OneToMany(mappedBy = "team", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Member> members = new ArrayList<>();
	
	public Team() {
		
	}

	public Team(long teamid, String teamname, List<Member> members) {
		this.teamid = teamid;
		this.teamname = teamname;
		this.members = members;
	}
	public Team(String teamname, List<Member> members) {
	
		this.teamname = teamname;
		this.members = members;
	}


	public long getTeamid() {
		return teamid;
	}

	public void setTeamid(long teamid) {
		this.teamid = teamid;
	}

	public String getTeamname() {
		return teamname;
	}

	public void setTeamname(String teamname) {
		this.teamname = teamname;
	}

	public List<Member> getMembers() {
		return members;
	}

	public void setMembers(List<Member> members) {
		this.members = members;
	}
	
	@Override
	public String toString() {
		return "Team [teamid=" + teamid + ", teamname=" + teamname + "]";
	}

	
	
}
