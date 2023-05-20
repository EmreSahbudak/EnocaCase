package com.emre.mapper;

import com.emre.dto.request.SaveEmployeeRequestDto;
import com.emre.dto.request.UpdateEmployeeRequestDto;
import com.emre.entity.Employee;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface IEmployeeMapper {

    IEmployeeMapper INSTANCE = Mappers.getMapper(IEmployeeMapper.class);

    Employee toEmployee(final SaveEmployeeRequestDto dto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Employee toUpdateEmployee(final UpdateEmployeeRequestDto dto, @MappingTarget Employee employee);
}
