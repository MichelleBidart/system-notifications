package com.microservice.organization.service;


import java.util.List;

import com.microservice.organization.dto.OrganizationDTO;

public interface OrganizationService {
			
	OrganizationDTO  addOrganization(OrganizationDTO dto);

	List<OrganizationDTO> getAll();

		
}
