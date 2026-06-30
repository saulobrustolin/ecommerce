package saulo.brustolin.api.mappers;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

import saulo.brustolin.api.dtos.reviews.UpdateReviewDTO;
import saulo.brustolin.api.entities.Review;

@Mapper(componentModel = "spring")
public interface ReviewMapper {
    
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE, unmappedTargetPolicy = ReportingPolicy.IGNORE)
    void updateEntityFromDto(UpdateReviewDTO dto, @MappingTarget Review entity);
}
