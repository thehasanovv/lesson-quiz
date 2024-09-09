package az.atl.lessonquiz.mapper;

import az.atl.lessonquiz.dao.entity.CategoryEntity;
import az.atl.lessonquiz.dao.entity.ProductEntity;
import az.atl.lessonquiz.model.request.SaveProductRequest;
import az.atl.lessonquiz.model.response.ProductResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;


@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface ProductMapper {
    ProductMapper PRODUCT_MAPPER = Mappers.getMapper(ProductMapper.class);

    ProductResponse buildProductResponse(ProductEntity productEntity);


    @Mapping(target = "id", ignore = true)
//    @Mapping(target = "isActive", source = "active")
//    @Mapping(target = "isDeleted", source = "deleted")
    @Mapping(target = "category.id",  source = "category")
    ProductEntity buildProductEntity(SaveProductRequest userRequest);

//    default CategoryEntity mapCategory(Long categoryId) {
//        return CategoryEntity.builder().id(categoryId).build();
//    }
}
