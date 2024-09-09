package az.atl.lessonquiz.service;

import az.atl.lessonquiz.model.request.SaveCategoryRequest;
import az.atl.lessonquiz.model.response.CategoryAllInfoResponse;
import az.atl.lessonquiz.model.response.CategoryResponse;

import java.util.List;

public interface CategoryService {

    CategoryResponse getCategoryById(Long id);

    List<CategoryAllInfoResponse> getAllInfoCategories();

    void saveCategory(SaveCategoryRequest categoryRequest);
}
