package az.atl.lessonquiz.dao.repository;

import az.atl.lessonquiz.dao.entity.CategoryEntity;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepository extends JpaRepository<CategoryEntity, Long> {
    @EntityGraph(attributePaths = {"products"}, type = EntityGraph.EntityGraphType.FETCH)
    List<CategoryEntity> findAll();
}
