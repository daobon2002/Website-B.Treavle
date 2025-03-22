package vn.tour_dulich.do_an.home.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import vn.tour_dulich.do_an.Entity.CategoryEntity;
import vn.tour_dulich.do_an.Entity.TourEntity;
import vn.tour_dulich.do_an.Entity.UserEntity;
import vn.tour_dulich.do_an.home.resitory.HomeCategoryRepository;
import vn.tour_dulich.do_an.home.resitory.HomeTourRepository;
import vn.tour_dulich.do_an.home.resitory.Pagehome;
import vn.tour_dulich.do_an.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service("homeTourService")
public class TourService implements Pagehome {
    @Autowired
    HomeTourRepository homeTourRepository;

    @Autowired
    HomeCategoryRepository homeCategoryRepository;

    @Autowired
    UserRepository userRepository;

    @Override
    public List<TourEntity> searchTour(String keyword) {
        return homeTourRepository.searchBy(keyword);
    }

    @Override
    public Page<TourEntity> getAll(Integer pageNumber) {
        Pageable pageable = PageRequest.of(pageNumber - 1, 15);
        return homeTourRepository.findAll(pageable);
    }

    @Override
    public Page<TourEntity> searchTour(String keyword, Integer pageNumber) {
        List<TourEntity> list = this.searchTour(keyword);
        Pageable pageable = PageRequest.of(pageNumber - 1, 15);
        int start = (int) pageable.getOffset();
        int end = Math.min((start + pageable.getPageSize()), list.size());
        list = list.subList(start, end);
        return new PageImpl<>(list, pageable, this.searchTour(keyword).size());
    }

    public List<CategoryEntity> getAllCategories() {
        return homeCategoryRepository.findAll(); // Đảm bảo phương thức này trả về danh sách không rỗng
    }

    public Page<TourEntity> getToursByCategory(Long categoryId, int pageNumber) {
        Pageable pageable = PageRequest.of(pageNumber - 1, 20);
        return homeTourRepository.findByCategory_Id(categoryId, pageable);
    }

    public Optional<TourEntity> getTourById(Long tourId) {
        return homeTourRepository.findById(tourId);
    }

    public List<TourEntity> getRandomTours() {
        Pageable pageable = PageRequest.of(0, 3);
        return homeTourRepository.findRandomTours(pageable);
    }
    public Optional<UserEntity> findById(Long id) {
        return userRepository.findById(id);
    }

}
