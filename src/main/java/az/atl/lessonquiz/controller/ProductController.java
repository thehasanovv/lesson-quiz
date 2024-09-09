package az.atl.lessonquiz.controller;

import az.atl.lessonquiz.model.request.SaveProductRequest;
import az.atl.lessonquiz.model.response.ProductResponse;
import az.atl.lessonquiz.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService categoryService;


    @GetMapping({"/{id}"})
    public ResponseEntity<ProductResponse> getProduct(@PathVariable Long id) {
        return ResponseEntity.status(OK).body(categoryService.getCategoryById(id));
    }

    @PostMapping
    public ResponseEntity<Void> saveProduct(@Valid @RequestBody SaveProductRequest request) {
        categoryService.saveCategory(request);
        return ResponseEntity.status(OK).build();
    }

}
