package vn.tour_dulich.do_an.service.Interface;

import org.springframework.data.domain.Page;
import vn.tour_dulich.do_an.Entity.TourEntity;
import vn.tour_dulich.do_an.Entity.UserEntity;

import java.util.List;

public interface interfaceTour {
    List<TourEntity> searchTour(String keyword);

    Page<TourEntity> getAll(Integer pageNo);
    Page<TourEntity> searchTour(String keyword, Integer pageNumber);
}
