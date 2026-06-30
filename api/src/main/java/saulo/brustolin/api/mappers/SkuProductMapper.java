package saulo.brustolin.api.mappers;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

import saulo.brustolin.api.dtos.products.UpdateSkuProductDTO;
import saulo.brustolin.api.entities.SkuProduct;

@Mapper(componentModel = "spring")
public interface SkuProductMapper {
    
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE, unmappedTargetPolicy = ReportingPolicy.IGNORE)
    void updateEntityFromDto(UpdateSkuProductDTO dto, @MappingTarget SkuProduct entity);
}
