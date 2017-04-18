package com.nyit.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.nyit.model.Candidate;
import com.nyit.model.Results;
import com.nyit.model.Voter;
import com.nyit.model.Votes;
import com.nyit.repositories.CandidateRepository;
import com.nyit.repositories.VoteRepository;
import com.nyit.repositories.VoterRepository;

@Controller
public class HomeController {
	@Autowired
	private VoterRepository voterRepository;
	@Autowired
	private VoteRepository voteRepository;
	@Autowired
	private CandidateRepository candidateRepository;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String getHome(Model model){
		model.addAttribute("message", "Welcome to the Electronic Voting System");
		
		return "home";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET) 
	public String getLogin(Model model){
		model.addAttribute("message", "Login here.");
		model.addAttribute("loginForm", new Voter());
		
		return "login";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String postLogin(Model model, Voter loginForm, HttpSession session){
		
		System.out.println(loginForm.toString());
		Voter voter = voterRepository.findByEmail(loginForm.getEmail());
		System.out.println(voter.toString());
		if(voter.getEmail().equalsIgnoreCase(loginForm.getEmail()) &&
				voter.getPassword().equalsIgnoreCase(loginForm.getPassword())){
				session.setAttribute("authenticated", "true");
				session.setAttribute("voter", voter);
				return "redirect:/vote";
		}else{
			model.addAttribute("loginForm", loginForm);
			model.addAttribute("message", "Wrong credentials");
		}
		return "login";
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String getRegistration(Model model){
		model.addAttribute("message", "register on this page");
		model.addAttribute("registrationForm", new Voter());
		return "register";
	}
	
	@RequestMapping(value = "/candidateRegistration", method = RequestMethod.GET)
	public String getcandidateRegistration(Model model){
		model.addAttribute("message", "Candidates register on this page");
		model.addAttribute("registrationForm", new Candidate());
		return "candidateRegistration";
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String postRegistration(Model model, Voter registrationForm){
		model.addAttribute("message", "register on this page");
		registrationForm.toString();
		try {
			voterRepository.save(registrationForm);
		} catch (Exception e) {
			model.addAttribute("registrationForm", registrationForm);
			e.printStackTrace();
			return "register";
		}
		
		return "redirect:/login";
	}
	
	@RequestMapping(value = "/candidateRegistration", method = RequestMethod.POST)
	public String postcandidateRegistration(Model model, Candidate registrationForm){
		model.addAttribute("message", "Candidates register on this page");
		registrationForm.toString();
		try {
			candidateRepository.save(registrationForm);
		} catch (Exception e) {
			model.addAttribute("registrationForm", registrationForm);
			e.printStackTrace();
			return "candidateRegistration";
		}
		
		return "candidateRegistration";
	}
	
	@RequestMapping(value = "/vote", method = RequestMethod.GET)
	public String getVoteCasting(Model model, HttpSession session){
		if(session.getAttribute("authenticated")==null){
			model.addAttribute("message", "you are not authenticated");
			return "login";
		}
			
		model.addAttribute("message", "Please select the candidate u want to vote for.");
		List<Candidate>candidates= (List<Candidate>) candidateRepository.findAll();
		model.addAttribute("candidates", candidates);
		return "vote";
	}
	
	@RequestMapping(value = "/vote", method = RequestMethod.POST )
	public String postVotes(Model model, HttpSession session, HttpServletRequest request, @ModelAttribute Votes vote, Voter voter){
		if(session.getAttribute("authenticated")==null){
			model.addAttribute("message", "you are not authenticated");
			return "login";
		}
		voter=(Voter)session.getAttribute("voter");
		vote.setVoterId(voter.getVoterid());
		voteRepository.save(vote);
		model.addAttribute("message", "Your vote has been saved.");
		List<Candidate>candidates= (List<Candidate>) candidateRepository.findAll();
		model.addAttribute("candidates", candidates);
		return "vote";
	}
	
	@RequestMapping(value = "/results", method = RequestMethod.GET)
	public String getResults(Model model){
		model.addAttribute("message", "Here are the results so far..");
		List<Results> results = voteRepository.findResults();
		model.addAttribute("results", results);
		return "results";
	}
	
	@RequestMapping(value = "/mypage", method = RequestMethod.GET)
	public String getMypage(Model model){
		model.addAttribute("message", "this is my page");
		
		return "mypage";
	}
	
	
	@RequestMapping(value="/logout", method = RequestMethod.GET)
	public String doLogout (Model model, HttpSession session) {
		model.addAttribute("message", "You have been logged out");
		session.removeAttribute("authenticated");
		return "login";
	}
	
//	@RequestMapping(value = "/car-bs", method = RequestMethod.GET)
//	@ResponseBody
//	public HashMap<String,Object> getHome(){
//		HashMap<String,Object> model = new HashMap<>();
//		model.put("message", "some bs about car deals.");
//		model.put("car1", "old car");
//		model.put("car2", "new car");
//		model.put("car3", "sports car");
//		return model;
//	}

}
