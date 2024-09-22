package az.atl.lessonquiz.service;

import az.atl.lessonquiz.dao.entity.ProductEntity;
import az.atl.lessonquiz.model.criteria.PageCriteria;
import az.atl.lessonquiz.model.criteria.UserCriteria;
import az.atl.lessonquiz.model.request.SaveProductRequest;
import az.atl.lessonquiz.model.response.ProductResponse;
import org.springframework.data.domain.Page;

public interface ProductService {
    Page<ProductEntity> getAllProducts(PageCriteria pageCriteria, UserCriteria userCriteria);

    ProductResponse getProductById(Long id);

    void saveProduct(SaveProductRequest productRequest);
}
