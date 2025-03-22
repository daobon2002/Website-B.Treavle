package vn.tour_dulich.do_an.home.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import vn.tour_dulich.do_an.Entity.NewsEntity;
import vn.tour_dulich.do_an.home.resitory.HomeNewsRepository;
import vn.tour_dulich.do_an.repository.NewsRepository;

import java.util.List;

@Service
public class HomeNewsService {
    @Autowired
    NewsRepository newsRepository;


    public Page<NewsEntity> getAllNews(Pageable pageable) {
        return newsRepository.findAll(pageable);
    }

    public List<NewsEntity> searchNews(String keyword) {
        return newsRepository.searchNewsEntitiesBy(keyword);
    }


    public Page<NewsEntity> searchNews(String keyword, Integer pageNumber) {
        Pageable pageable = PageRequest.of(pageNumber - 1, 5);
        List<NewsEntity> list = searchNews(keyword);
        int start = (int) pageable.getOffset();
        int end = Math.min((start + pageable.getPageSize()), list.size());
        return new PageImpl<>(list.subList(start, end), pageable, list.size());
    }


    public Page<NewsEntity> getNewsAll(Integer pageNumber) {
        Pageable pageable = PageRequest.of(pageNumber - 1, 5);
        return newsRepository.findAll(pageable);
    }
}
