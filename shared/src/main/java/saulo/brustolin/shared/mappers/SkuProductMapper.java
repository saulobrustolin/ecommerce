package saulo.brustolin.shared.mappers;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

import saulo.brustolin.shared.dtos.products.UpdateSkuProductDTO;
import saulo.brustolin.shared.entities.Sku;

@Mapper(componentModel = "spring")
public interface SkuProductMapper {
    
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE, unmappedTargetPolicy = ReportingPolicy.IGNORE)
    void updateEntityFromDto(UpdateSkuProductDTO dto, @MappingTarget Sku entity);
}
