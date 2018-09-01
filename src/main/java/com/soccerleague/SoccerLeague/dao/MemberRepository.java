package com.soccerleague.SoccerLeague.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.soccerleague.SoccerLeague.entity.Member;
import com.soccerleague.SoccerLeague.entity.Team;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long>{

	List<Member> findByTeam(Team team);	
}
