package vn.tour_dulich.do_an.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import vn.tour_dulich.do_an.Entity.BooktourEntity;
import vn.tour_dulich.do_an.Entity.CategoryEntity;

import java.util.List;

public interface BooktourRepository extends JpaRepository<BooktourEntity,Long> {
    @Query("SELECT b FROM BooktourEntity b WHERE b.hoten LIKE %?1% or b.gmail LIKE %?1% or b.tentour LIKE %?1% ")
    List<BooktourEntity> searchBooktourEntitiesBy(String keyword);

    @Query("SELECT COUNT(b) FROM BooktourEntity b WHERE b.trangthai = 'Hoan Thanh'")
    long countSuccessfulBookings();
}
