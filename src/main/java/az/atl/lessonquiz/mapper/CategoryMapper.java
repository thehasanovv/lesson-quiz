package az.atl.lessonquiz.mapper;

import az.atl.lessonquiz.dao.entity.CategoryEntity;
import az.atl.lessonquiz.model.request.SaveCategoryRequest;
import az.atl.lessonquiz.model.response.CategoryAllInfoResponse;
import az.atl.lessonquiz.model.response.CategoryResponse;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;


@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface CategoryMapper {
    CategoryMapper CATEGORY_MAPPER = Mappers.getMapper(CategoryMapper.class);

    CategoryResponse buildCategoryResponse(CategoryEntity entity);

    @Mapping(target = "id", ignore = true)
    CategoryEntity buildCategoryEntity(SaveCategoryRequest request);

    CategoryAllInfoResponse buildCategoryAllInfoResponse(CategoryEntity entity);
}
