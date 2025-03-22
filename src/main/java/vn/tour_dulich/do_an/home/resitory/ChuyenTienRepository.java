package vn.tour_dulich.do_an.home.resitory;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import vn.tour_dulich.do_an.Entity.CKEntity;

import java.util.List;

public interface ChuyenTienRepository extends JpaRepository<CKEntity, Long> {
    @Query(value = "SELECT c FROM CKEntity c ORDER BY c.id DESC")
    List<CKEntity> findTop5ByOrderByIdDesc();
}