package vn.tour_dulich.do_an.service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import vn.tour_dulich.do_an.Entity.ReviewEntity;
import vn.tour_dulich.do_an.Entity.TourEntity;
import vn.tour_dulich.do_an.repository.ReviewRepository;

import java.util.List;

@Service
public class ReviewService {
    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    TourService tourService;

    public List<ReviewEntity> getAllReviews() {
        return reviewRepository.findAll();
    }

    public Page<ReviewEntity> getAllReviewsPaged(Integer pageNumber) {
        Pageable pageable = PageRequest.of(pageNumber - 1, 10);
        return reviewRepository.findAll(pageable);
    }

    public ReviewEntity getReviewById(Long id) {
        return reviewRepository.findById(id).orElse(null);
    }

    public List<ReviewEntity> searchReviews(String keyword) {
        return reviewRepository.searchReviewEntityBy(keyword);
    }

    public Page<ReviewEntity> searchReviewsPaged(String keyword, Integer pageNumber) {
        List<ReviewEntity> list = this.searchReviews(keyword);
        Pageable pageable = PageRequest.of(pageNumber - 1, 10);
        int start = (int) pageable.getOffset();
        int end = Math.min((start + pageable.getPageSize()), list.size());
        list = list.subList(start, end);
        return new PageImpl<>(list, pageable, this.searchReviews(keyword).size());
    }

    public void deleteReview(Long id) {

        ReviewEntity reviewEntity = reviewRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tour không tồn tại với ID: " + id));
        // Xóa tour
        reviewRepository.delete(reviewEntity);
    }
    public ReviewEntity saveReview(ReviewEntity review) {
        return reviewRepository.save(review);
    }


    public Page<ReviewEntity> getReviewsByTourId(Long tourId, int pageNumber, int pageSize) {
        TourEntity tour = tourService.getTourById(tourId) // Lấy TourEntity bằng tourId
                .orElseThrow(() -> new RuntimeException("Tour not found"));

        Pageable pageable = PageRequest.of(pageNumber - 1, pageSize); // Tạo đối tượng Pageable
        return reviewRepository.findByTourid(tour, pageable); // Gọi phương thức repository với pageable
    }
}
