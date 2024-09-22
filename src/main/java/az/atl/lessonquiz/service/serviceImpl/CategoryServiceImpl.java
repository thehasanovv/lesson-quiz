package az.atl.lessonquiz.service.serviceImpl;

import az.atl.lessonquiz.dao.entity.CategoryEntity;
import az.atl.lessonquiz.dao.repository.CategoryRepository;
import az.atl.lessonquiz.model.request.SaveCategoryRequest;
import az.atl.lessonquiz.model.response.CategoryAllInfoResponse;
import az.atl.lessonquiz.model.response.CategoryResponse;
import az.atl.lessonquiz.service.CategoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

import static az.atl.lessonquiz.mapper.CategoryMapper.CATEGORY_MAPPER;

@Service
@RequiredArgsConstructor
@Slf4j
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;
    private final RedisTemplate<String, Object> redisTemplate;

    @Override
    public CategoryResponse getCategoryById(Long id) {
        var category = fetchCategoryIfExist(id);
        return CATEGORY_MAPPER.buildCategoryResponse(category);
    }

    @Transactional
    @Override
    public List<CategoryAllInfoResponse> getAllInfoCategories() {
        var categories = categoryRepository.findAll();

        return categories.stream()
                .map(CATEGORY_MAPPER::buildCategoryAllInfoResponse)
                .collect(Collectors.toList());
    }

    @Override
    public void saveCategory(SaveCategoryRequest categoryRequest) {
        var category = CATEGORY_MAPPER.buildCategoryEntity(categoryRequest);
        categoryRepository.save(category);
    }

    private CategoryEntity fetchCategoryIfExist(Long id) {
        return categoryRepository.findById(id).orElseThrow(
                () -> {
                    log.error("ActionLog.fetchCategoryIfExist.error id:{}", id);
                    return new RuntimeException("CATEGORY_NOT_FOUND");
                }
        );
    }
}
