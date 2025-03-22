package vn.tour_dulich.do_an.home.resitory;

import org.springframework.data.domain.Page;
import vn.tour_dulich.do_an.Entity.TourEntity;

import java.util.List;

public interface Pagehome {
    List<TourEntity> searchTour(String keyword);

    Page<TourEntity> getAll(Integer pageNo);
    Page<TourEntity> searchTour(String keyword, Integer pageNumber);
}
