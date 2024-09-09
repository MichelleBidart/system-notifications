package com.microservice.organization.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.microservice.organization.dto.OrganizationDTO;
import com.microservice.organization.mapper.OrganizationMapper;
import com.microservice.organization.models.Organization;
import com.microservice.organization.repository.OrganizationRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrganizationServiceImpl implements OrganizationService {
	
	@Autowired
	OrganizationMapper mapper;
	
	@Autowired
	OrganizationRepository repository;

	@Override
	public OrganizationDTO addOrganization(OrganizationDTO dto) {
		Organization organization = mapper.toEntity(dto);
		return mapper.toDto(repository.save(organization));
	}

	@Override
	@Transactional(readOnly = true)
	public List<OrganizationDTO> getAll() {
	    return StreamSupport.stream(repository.findAll().spliterator(), false)
	            .map(mapper::toDto)
	            .collect(Collectors.toList());
	    

	}

}
