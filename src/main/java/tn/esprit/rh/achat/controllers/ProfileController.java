package tn.esprit.rh.achat.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import tn.esprit.rh.achat.AppProfile;
import tn.esprit.rh.achat.entities.Produit;
import tn.esprit.rh.achat.services.IProduitService;
@RestController
@CrossOrigin("*")
@Api(tags = "Gestion des profiles")
@RequestMapping("/profiles")
public class ProfileController {

	@Autowired
	AppProfile app;

	// http://localhost:8089/SpringMVC/profiles/getProfile
	@GetMapping("/")
	@ResponseBody
	public String getProfile() {
		return app.getMessage().toString();
	}


}
