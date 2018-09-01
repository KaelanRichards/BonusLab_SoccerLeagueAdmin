package com.soccerleague.SoccerLeague.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.soccerleague.SoccerLeague.entity.Team;

@Repository
public interface TeamRepository extends JpaRepository<Team, Long>{

}
