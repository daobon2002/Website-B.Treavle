package vn.tour_dulich.do_an.service.Interface;

import org.springframework.data.domain.Page;
import vn.tour_dulich.do_an.Entity.BooktourEntity;
import vn.tour_dulich.do_an.Entity.CategoryEntity;

import java.util.List;

public interface interfaceBooktour {
    List<BooktourEntity> searchBooktour(String keyword);
    Page<BooktourEntity> getBooktourAll(Integer pageNumber);
    Page<BooktourEntity> searchBooktour(String keyword, Integer pageNumber);
}
