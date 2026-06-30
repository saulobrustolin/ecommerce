package saulo.brustolin.api.mappers;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

import saulo.brustolin.api.dtos.categories.UpdateCategoryDTO;
import saulo.brustolin.api.entities.Category;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE, unmappedTargetPolicy = ReportingPolicy.IGNORE)
    void updateEntityFromDto(UpdateCategoryDTO dto, @MappingTarget Category entity);
}
