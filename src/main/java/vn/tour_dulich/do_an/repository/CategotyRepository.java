package vn.tour_dulich.do_an.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import vn.tour_dulich.do_an.Entity.CategoryEntity;

import java.util.List;

public interface CategotyRepository extends JpaRepository<CategoryEntity,Long> {
    @Query("SELECT c FROM CategoryEntity c WHERE c.tentheloai LIKE %?1% ")
    List<CategoryEntity> searchCategoryEntitiesBy(String keyword);
}
