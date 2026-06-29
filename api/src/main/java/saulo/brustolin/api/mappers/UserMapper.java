package saulo.brustolin.api.mappers;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

import saulo.brustolin.api.dtos.users.UpdateUserDTO;
import saulo.brustolin.api.entities.User;

@Mapper(componentModel = "spring")
public interface UserMapper {
    
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE, unmappedTargetPolicy = ReportingPolicy.IGNORE)
    void updateEntityFromDto(UpdateUserDTO dto, @MappingTarget User entity);
}
