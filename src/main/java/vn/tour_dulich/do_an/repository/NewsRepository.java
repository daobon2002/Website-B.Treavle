package vn.tour_dulich.do_an.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import vn.tour_dulich.do_an.Entity.NewsEntity;

import java.util.List;

public interface NewsRepository extends JpaRepository<NewsEntity, Long> {
    @Query("SELECT n FROM NewsEntity n WHERE n.noidung LIKE %?1% or n.author like %?1% or n.tieude like %?1%")
    List<NewsEntity> searchNewsEntitiesBy(String keyword);
}
