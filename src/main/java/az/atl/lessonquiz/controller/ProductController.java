package az.atl.lessonquiz.controller;

import az.atl.lessonquiz.dao.entity.ProductEntity;
import az.atl.lessonquiz.model.criteria.PageCriteria;
import az.atl.lessonquiz.model.criteria.UserCriteria;
import az.atl.lessonquiz.model.request.SaveProductRequest;
import az.atl.lessonquiz.model.response.ProductResponse;
import az.atl.lessonquiz.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping
    public ResponseEntity<Page<ProductEntity>> getAllProducts(PageCriteria pageCriteria, UserCriteria userCriteria) {
        return ResponseEntity.status(OK).body(productService.getAllProducts(pageCriteria, userCriteria));
    }

    @GetMapping({"/{id}"})
    public ResponseEntity<ProductResponse> getProduct(@PathVariable Long id) {
        return ResponseEntity.status(OK).body(productService.getProductById(id));
    }

    @PostMapping
    public ResponseEntity<Void> saveProduct(@Valid @RequestBody SaveProductRequest request) {
        productService.saveProduct(request);
        return ResponseEntity.status(OK).build();
    }

}
