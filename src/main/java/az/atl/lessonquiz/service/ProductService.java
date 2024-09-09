package az.atl.lessonquiz.service;

import az.atl.lessonquiz.model.request.SaveProductRequest;
import az.atl.lessonquiz.model.response.ProductResponse;

public interface ProductService {
    ProductResponse getCategoryById(Long id);

    void saveCategory(SaveProductRequest categoryRequest);
}
