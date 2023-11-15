package com.lana.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.lana.cache.PetitionSignatureCache;
import com.lana.model.Petition;
import com.lana.model.Signature;

@Controller
public class WebController {

	private PetitionSignatureCache cache = new PetitionSignatureCache();

	private static final String KEY_PETITIONS = "petitions";
	private static final String KEY_PETITION = "petition";
	private static final String KEY_SIGNATURES = "signatures";
	private static final String KEY_SIGNATURE = "signature";
	private static final String PAGE_HOME = "home";

	@GetMapping({ "/", "/home" })
	public ModelAndView getPetitionsPage() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject(KEY_PETITIONS, cache.getAllPetitions());
		modelAndView.setViewName(PAGE_HOME);
		Petition petition = new Petition();
		modelAndView.addObject(KEY_PETITION, petition);
		return modelAndView;
	}

	@GetMapping({ "/create" })
	public String createPetitionPage(Model model) {
		Petition petition = new Petition();
		model.addAttribute(KEY_PETITION, petition);
		return "create";
	}

	@GetMapping(value = "/view")
	public ModelAndView viewPetitionPage(@RequestParam("id") Long petitionId) {
		ModelAndView modelAndView = new ModelAndView();
		Signature signature = new Signature();
		Petition petition = cache.getPetition(petitionId);
		modelAndView.addObject(KEY_PETITION, petition);
		modelAndView.addObject(KEY_SIGNATURES, cache.getSignatures(petitionId));
		modelAndView.addObject(KEY_SIGNATURE, signature);
		modelAndView.setViewName("view");
		return modelAndView;
	}


	

}
