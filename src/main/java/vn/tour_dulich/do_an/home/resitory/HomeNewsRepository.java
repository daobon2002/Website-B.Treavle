package vn.tour_dulich.do_an.home.resitory;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.tour_dulich.do_an.Entity.CategoryEntity;
import vn.tour_dulich.do_an.Entity.NewsEntity;

import java.util.List;

public interface HomeNewsRepository extends JpaRepository<NewsEntity,Long> {

}
