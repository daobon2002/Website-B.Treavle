package vn.tour_dulich.do_an.repository;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import vn.tour_dulich.do_an.Entity.CategoryEntity;
import vn.tour_dulich.do_an.Entity.TourEntity;

import java.util.List;

@Repository
public interface TourRepository extends JpaRepository<TourEntity, Long> {

    @Query("SELECT t FROM TourEntity t WHERE t.tentour LIKE %?1% or t.mota like %?1% ")
    List<TourEntity> searchBy(String keyword);

    TourEntity findByTentour(String tourName); // Lưu ý: tentour phải đúng với tên trường trong TourEntity.
}
