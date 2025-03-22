package vn.tour_dulich.do_an.home.resitory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import vn.tour_dulich.do_an.Entity.TourEntity;

import java.util.List;
import java.util.Optional;

public interface HomeTourRepository extends JpaRepository<TourEntity,Long> {
    @Query("SELECT t FROM TourEntity t WHERE t.tentour LIKE %?1% or t.mota like %?1% ")
    List<TourEntity> searchBy(String keyword);

    Page<TourEntity> findByCategory_Id(Long categoryId, Pageable pageable);

    @Query(value = "SELECT t FROM TourEntity t ORDER BY RAND()")
    List<TourEntity> findRandomTours(Pageable pageable);

    @Query(value = "SELECT t FROM TourEntity t ORDER BY RAND()")
    List<TourEntity> findRandomTours(); // Lấy danh sách tour ngẫu nhiên

    default Optional<TourEntity> findOneRandomTour() {
        List<TourEntity> randomTours = findRandomTours();
        return randomTours.isEmpty() ? Optional.empty() : Optional.of(randomTours.get(0));
    }
}
