package saulo.brustolin.shared.mappers;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

import saulo.brustolin.shared.dtos.products.UpdateProductDTO;
import saulo.brustolin.shared.entities.Product;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE, unmappedTargetPolicy = ReportingPolicy.IGNORE)
    void updateEntityFromDto(UpdateProductDTO dto, @MappingTarget Product entity);
}
