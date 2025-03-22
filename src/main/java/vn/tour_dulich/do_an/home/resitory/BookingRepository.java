package vn.tour_dulich.do_an.home.resitory;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.tour_dulich.do_an.Entity.BooktourEntity;

public interface BookingRepository extends JpaRepository<BooktourEntity,Long> {

}
