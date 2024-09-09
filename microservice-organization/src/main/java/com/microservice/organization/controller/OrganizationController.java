package com.microservice.organization.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.organization.dto.OrganizationDTO;
import com.microservice.organization.service.OrganizationService;




@RestController
@RequestMapping("/organization")
public class OrganizationController {
	

    @Autowired
    private OrganizationService service;	
	
	@GetMapping
	public ResponseEntity<?> getAllOrganizations() {
		  List<OrganizationDTO> organizations = service.getAll();
	      return new ResponseEntity<>(organizations, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<OrganizationDTO> addOrganizations(@RequestBody OrganizationDTO dto) {
			  return new ResponseEntity<>(service.addOrganization(dto), HttpStatus.OK);
	}


}
