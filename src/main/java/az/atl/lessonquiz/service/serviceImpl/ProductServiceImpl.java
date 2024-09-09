package az.atl.lessonquiz.service.serviceImpl;

import az.atl.lessonquiz.dao.entity.ProductEntity;
import az.atl.lessonquiz.dao.repository.ProductRepository;
import az.atl.lessonquiz.model.request.SaveProductRequest;
import az.atl.lessonquiz.model.response.ProductResponse;
import az.atl.lessonquiz.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import static az.atl.lessonquiz.mapper.ProductMapper.PRODUCT_MAPPER;


@Service
@RequiredArgsConstructor
@Slf4j
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    @Override
    public ProductResponse getCategoryById(Long id) {
        var category = fetchCategoryIfExist(id);
        return PRODUCT_MAPPER.buildProductResponse(category);
    }

    @Override
    public void saveCategory(SaveProductRequest categoryRequest) {
        productRepository.save(PRODUCT_MAPPER.buildProductEntity(categoryRequest));

    }

    private ProductEntity fetchCategoryIfExist(Long id) {
        return productRepository.findById(id).orElseThrow(
                () -> {
                    log.error("ActionLog.fetchCategoryIfExist.error id:{}", id);
                    return new RuntimeException("PRODUCT_NOT_FOUND");
                }
        );
    }
}
