package az.atl.lessonquiz.utils;

import az.atl.lessonquiz.dao.entity.ProductEntity;
import org.springframework.data.jpa.domain.Specification;

public class UserSpecs {
    public static Specification<ProductEntity> hasName(String providedName) {
        return (root, query, cb) -> cb.like(cb.lower(root.get("name")),
                "%" + providedName.toLowerCase() + "%");
    }
}
