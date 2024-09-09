package com.microservice.organization.mapper;

import org.mapstruct.Mapper;

import com.microservice.organization.dto.OrganizationDTO;
import com.microservice.organization.models.Organization;


@Mapper(componentModel = "spring")
public interface OrganizationMapper {

    OrganizationDTO toDto(Organization organization);
    Organization toEntity(OrganizationDTO organizationDTO);
    
}
