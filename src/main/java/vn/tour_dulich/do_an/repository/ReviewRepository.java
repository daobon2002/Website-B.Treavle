package vn.tour_dulich.do_an.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import vn.tour_dulich.do_an.Entity.ReviewEntity;
import vn.tour_dulich.do_an.Entity.TourEntity;

import java.util.List;

public interface ReviewRepository extends JpaRepository<ReviewEntity,Long> {
    @Query("SELECT r FROM ReviewEntity r WHERE r.binhluan LIKE %?1% ")
    List<ReviewEntity> searchReviewEntityBy(String keyword);

    List<ReviewEntity> findByTourid(TourEntity tourId);
    Page<ReviewEntity> findByTourid(TourEntity tour, Pageable pageable);
    long countByTourid(TourEntity tour);
}
