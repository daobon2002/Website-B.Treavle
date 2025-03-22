package vn.tour_dulich.do_an.home.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import vn.tour_dulich.do_an.Entity.TourEntity;
import vn.tour_dulich.do_an.home.resitory.HomeRepository;

import java.util.List;

@Service("HomeService1")
public class HomeService {

    @Autowired
    private HomeRepository homeRepository;

    public List<TourEntity> getRandomTours() {
        return homeRepository.findRandomTours(PageRequest.of(0, 6));
    }
    public List<TourEntity> getBeachTours() {
        String beachCategoryName = "Tour du lịch biển"; // Tên danh mục
        return homeRepository.findRandomToursByCategory(beachCategoryName, PageRequest.of(0, 6)); // Lấy 6 tour biển
    }
    public List<TourEntity> getNuiTous() {
        String beachCategoryName = "Tour Tây Bắc"; // Tên danh mục
        return homeRepository.findRandomToursByCategory(beachCategoryName, PageRequest.of(0, 6)); // Lấy 6 tour biển
    }
    public TourEntity getHighestPriceTour() {
        Pageable pageable = PageRequest.of(0, 1); // Trang 0, kích thước 1
        List<TourEntity> tours = homeRepository.findTopTour(pageable);
        return tours.isEmpty() ? null : tours.get(0); // Trả về tour nếu có, nếu không trả về null
    }

    public TourEntity getSecondHighestPriceTour() {
        return homeRepository.findSecondHighestPriceTour(); // Tour có giá cao thứ hai
    }

    public TourEntity getThirdHighestPriceTour() {
        return homeRepository.findThirdHighestPriceTour(); // Tour có giá cao thứ ba
    }
}
