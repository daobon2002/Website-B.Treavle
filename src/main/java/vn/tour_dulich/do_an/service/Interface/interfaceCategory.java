package vn.tour_dulich.do_an.service.Interface;

import org.springframework.data.domain.Page;
import vn.tour_dulich.do_an.Entity.CategoryEntity;
import vn.tour_dulich.do_an.Entity.NewsEntity;

import java.util.List;

public interface interfaceCategory {
    List<CategoryEntity> searchCategory(String keyword);
    Page<CategoryEntity> getCategoryAll(Integer pageNumber);
    Page<CategoryEntity> searchCategory(String keyword, Integer pageNumber);
}
