package az.atl.lessonquiz.controller;

import az.atl.lessonquiz.model.request.SaveCategoryRequest;
import az.atl.lessonquiz.model.response.CategoryAllInfoResponse;
import az.atl.lessonquiz.model.response.CategoryResponse;
import az.atl.lessonquiz.service.CategoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("api/v1/categories")
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;

    @GetMapping()
    public ResponseEntity<List<CategoryAllInfoResponse>> getAllInfoCategories() {
        return ResponseEntity.status(OK).body(categoryService.getAllInfoCategories());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryResponse> getCategoryById(@PathVariable Long id) {
        return ResponseEntity.status(OK).body(categoryService.getCategoryById(id));
    }

    @PostMapping
    public ResponseEntity<Void> saveCategory(@Valid @RequestBody SaveCategoryRequest request) {
        categoryService.saveCategory(request);
        return ResponseEntity.status(OK).build();
    }
}
