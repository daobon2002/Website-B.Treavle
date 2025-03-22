package vn.tour_dulich.do_an.service.Interface;

import org.springframework.data.domain.Page;
import vn.tour_dulich.do_an.Entity.ReviewEntity;

import java.util.List;

public interface interfaceRevireService {
    List<ReviewEntity> searchReview(String keyword);

    Page<ReviewEntity> getAll(Integer pageNumber);
    Page<ReviewEntity> searchReview(String keyword, Integer pageNumber);
}
