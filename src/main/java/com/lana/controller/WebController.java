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


	

	@GetMapping({ "/create" })
	public String createPetitionPage(Model model) {
		Petition petition = new Petition();
		model.addAttribute(KEY_PETITION, petition);
		return "create";
	}

	

}
