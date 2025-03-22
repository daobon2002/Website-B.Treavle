package vn.tour_dulich.do_an.home.resitory;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import vn.tour_dulich.do_an.Entity.TourEntity;

import java.util.List;

public interface HomeRepository extends JpaRepository<TourEntity,Long> {

    @Query(value = "SELECT t FROM TourEntity t ORDER BY RAND()")
    List<TourEntity> findRandomTours(Pageable pageable);

    @Query("SELECT t FROM TourEntity t WHERE t.category.tentheloai = :tentheloai ORDER BY RAND()")
    List<TourEntity> findRandomToursByCategory(@Param("tentheloai") String tentheloai, Pageable pageable);

    @Query("SELECT t FROM TourEntity t ORDER BY t.gia DESC")
    List<TourEntity> findTopTour(Pageable pageable); // Lấy tour có giá cao nhất

    // Thêm phương thức để lấy tour có giá cao thứ hai
    default TourEntity findSecondHighestPriceTour() {
        Pageable pageable = PageRequest.of(1, 1); // Trang 1, kích thước 1 (thứ hai)
        List<TourEntity> tours = findTopTour(pageable);
        return tours.isEmpty() ? null : tours.get(0); // Trả về tour nếu có, nếu không trả về null
    }

    // Thêm phương thức để lấy tour có giá cao thứ ba
    default TourEntity findThirdHighestPriceTour() {
        Pageable pageable = PageRequest.of(2, 1); // Trang 2, kích thước 1 (thứ ba)
        List<TourEntity> tours = findTopTour(pageable);
        return tours.isEmpty() ? null : tours.get(0); // Trả về tour nếu có, nếu không trả về null
    }
}
