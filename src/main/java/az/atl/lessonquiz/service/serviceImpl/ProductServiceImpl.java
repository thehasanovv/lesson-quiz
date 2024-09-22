package az.atl.lessonquiz.service.serviceImpl;

import az.atl.lessonquiz.dao.entity.ProductEntity;
import az.atl.lessonquiz.dao.repository.ProductRepository;
import az.atl.lessonquiz.model.criteria.PageCriteria;
import az.atl.lessonquiz.model.criteria.UserCriteria;
import az.atl.lessonquiz.model.request.SaveProductRequest;
import az.atl.lessonquiz.model.response.ProductResponse;
import az.atl.lessonquiz.service.ProductService;
import az.atl.lessonquiz.utils.UserSpecs;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import static az.atl.lessonquiz.mapper.ProductMapper.PRODUCT_MAPPER;


@Service
@RequiredArgsConstructor
@Slf4j
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    @Override
    public Page<ProductEntity> getAllProducts(PageCriteria pageCriteria, UserCriteria userCriteria) {

        Specification<ProductEntity> spec = Specification.where(null);

        if (userCriteria.getName() != null && !userCriteria.getName().isBlank()) {
            spec.and(UserSpecs.hasName(userCriteria.getName()));
        }

        return productRepository.findAll(spec, PageRequest.of(pageCriteria.getPage(), pageCriteria.getCount()));
    }

    @Override
    public ProductResponse getProductById(Long id) {
        var category = fetchProductsIfExist(id);
        return PRODUCT_MAPPER.buildProductResponse(category);
    }

    @Override
    public void saveProduct(SaveProductRequest productRequest) {
        productRepository.save(PRODUCT_MAPPER.buildProductEntity(productRequest));

    }

    private ProductEntity fetchProductsIfExist(Long id) {
        return productRepository.findById(id).orElseThrow(
                () -> {
                    log.error("ActionLog.fetchCategoryIfExist.error id:{}", id);
                    return new RuntimeException("PRODUCT_NOT_FOUND");
                }
        );
    }
}
