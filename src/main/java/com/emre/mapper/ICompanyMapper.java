package com.emre.mapper;

import com.emre.dto.request.SaveCompanyRequestDto;
import com.emre.dto.request.UpdateCompanyRequestDto;
import com.emre.entity.Company;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface ICompanyMapper {

    ICompanyMapper INSTANCE = Mappers.getMapper(ICompanyMapper.class);

    Company toCompany(final SaveCompanyRequestDto dto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Company toUpdateCompany(final UpdateCompanyRequestDto dto, @MappingTarget Company company);
}
