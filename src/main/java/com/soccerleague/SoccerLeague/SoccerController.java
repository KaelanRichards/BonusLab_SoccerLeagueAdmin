package com.soccerleague.SoccerLeague;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.soccerleague.SoccerLeague.dao.MemberRepository;
import com.soccerleague.SoccerLeague.dao.TeamRepository;
import com.soccerleague.SoccerLeague.entity.Member;
import com.soccerleague.SoccerLeague.entity.Team;

@Controller
public class SoccerController {

	@Autowired
	MemberRepository memberRepo;

	@Autowired
	TeamRepository teamRepo;

	@RequestMapping("/")
	public ModelAndView home() {
		return new ModelAndView("index");
	}

	@RequestMapping("/teamlist")
	public ModelAndView displayTeams() {
		ModelAndView mv = new ModelAndView("teamlist");
		mv.addObject("teams", teamRepo.findAll());
		return mv;
	}

	@RequestMapping("/team/{teamid}/edit")
	public ModelAndView editTeam(@PathVariable("teamid") Team id) {
		ModelAndView mv = new ModelAndView("teameditform");
		mv.addObject("title", "Update Team");
		mv.addObject("team", id);

		return mv;
	}

	@PostMapping("/team/{teamid}/edit")
	public ModelAndView updateProduct(Team t) {
		ModelAndView mv = new ModelAndView("redirect:/teamlist");

		teamRepo.save(t);

		return mv;
	}

	@RequestMapping("/team/{teamid}/delete")
	public ModelAndView deleteTeam(@PathVariable("teamid") Long id) {
		teamRepo.deleteById(id);
		return new ModelAndView("redirect:/teamlist");
	}

	@RequestMapping("/team/{teamid}/view")
	public ModelAndView displayMembers(@PathVariable("teamid") Long id) {
		ModelAndView mv = new ModelAndView("teammembers");
		Team team = teamRepo.findById(id).orElse(null);
		mv.addObject("member", memberRepo.findByTeam(team));
		// mv.addObject("title", teamname);
		return mv;
	}

	@RequestMapping("/team/add")
	public ModelAndView addForm() {
		ModelAndView mv = new ModelAndView("teameditform");

		mv.addObject("title", "Add Item");

		return mv;

	}

	@PostMapping("/team/add")
	public ModelAndView addTeam(Team t) {
		ModelAndView mv = new ModelAndView("redirect:/");
		// mv.addObject("title", "Update Product");
		// mv.addObject("product", id);
		teamRepo.save(t);
		return mv;

	}

	@RequestMapping("/member/{memberid}/edit")
	public ModelAndView editMember(@PathVariable("memberid") Member id) {
		ModelAndView mv = new ModelAndView("editmemberform");
		mv.addObject("title", "Update Member");
		mv.addObject("member", id);
		//mv.addObject("teams", teamRepo.findAll());

		return mv;
	}

	@PostMapping("/member/{memberid}/edit")
	public ModelAndView submitMember(Member m) {
		ModelAndView mv = new ModelAndView("redirect:/teamlist");

		memberRepo.save(m);

		return mv;
	}

	@RequestMapping("/member/{memberid}/delete")
	public ModelAndView deleteMember(@PathVariable("memberid") Long id) {
		memberRepo.deleteById(id);
		return new ModelAndView("redirect:/teamlist");
	}

	@RequestMapping("/member/add")
	public ModelAndView addmemberForm() {
		ModelAndView mv = new ModelAndView("editmemberform");
		
		mv.addObject("title", "Add Item");
		//mv.addObject("teams", teamRepo.findAll());
		return mv;

	}

	@PostMapping("/member/add")
	public ModelAndView addMember(Member m) {
		ModelAndView mv = new ModelAndView("redirect:/");
		memberRepo.save(m);
		return mv;

	}
}
