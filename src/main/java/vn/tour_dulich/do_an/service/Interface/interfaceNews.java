package vn.tour_dulich.do_an.service.Interface;

import org.springframework.data.domain.Page;
import vn.tour_dulich.do_an.Entity.NewsEntity;

import java.util.List;

public interface interfaceNews {
        List<NewsEntity> searchNews(String keyword);
        Page<NewsEntity> getNewsAll(Integer pageNumber);
        Page<NewsEntity> searchNews(String keyword, Integer pageNumber);
}
