package vn.tour_dulich.do_an.home.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import vn.tour_dulich.do_an.Entity.ReviewEntity;
import vn.tour_dulich.do_an.Entity.TourEntity;
import vn.tour_dulich.do_an.Entity.UserEntity;
import vn.tour_dulich.do_an.home.service.TourService;
import vn.tour_dulich.do_an.repository.UserRepository;
import vn.tour_dulich.do_an.service.ReviewService;

import java.time.LocalDate;
import java.util.List;

@Controller("homeTourdetailsController")
@RequestMapping("/home")
public class TourdetailsController {

    @Autowired
    TourService tourService;

    @Autowired
    private ReviewService reviewService; // Inject dịch vụ để lưu đánh giá

    @Autowired
    private UserRepository userRepository; // Inject repository để tìm user

    @GetMapping("/tour/tour_details")
    public String tourDetails(@RequestParam("tourid") Long tourId,
                              @RequestParam(defaultValue = "1") int page,
                              @RequestParam(defaultValue = "5") int size,
                              Model model) {
        TourEntity tour = tourService.getTourById(tourId)
                .orElseThrow(() -> new RuntimeException("Tour not found"));

        // Lấy danh sách đánh giá với phân trang
        Page<ReviewEntity> reviewsPage = reviewService.getReviewsByTourId(tourId, page, size);
        List<ReviewEntity> reviews = reviewsPage.getContent(); // Lấy danh sách đánh giá

        List<TourEntity> randomTours = tourService.getRandomTours();
        model.addAttribute("randomTours", randomTours);
        model.addAttribute("tour", tour);
        model.addAttribute("reviews", reviews); // Thêm đánh giá vào model
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", reviewsPage.getTotalPages()); // Tổng số trang

        return "home/chitiettour"; // Tên view
    }

    @PostMapping("/tour/add_review")
    public String addReview(@RequestParam("tourid") Long tourId,
                            HttpSession session,
                            @RequestParam("rating") int rating,
                            @RequestParam("content") String content,
                            Model model) {
        // Kiểm tra xem người dùng đã đăng nhập hay chưa
        Long userId = (Long) session.getAttribute("userId"); // Giả định bạn đã lưu userId trong session
        if (userId == null) {
            return "redirect:/home/login?tourid=" + tourId + "&redirectTourId=" + tourId;
        }

        // Tìm kiếm người dùng trong cơ sở dữ liệu
        UserEntity user = tourService.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        // Lưu đánh giá
        ReviewEntity review = new ReviewEntity();
        TourEntity tour = tourService.getTourById(tourId)
                .orElseThrow(() -> new RuntimeException("Tour not found"));

        review.setTourid(tour);
        review.setUserid(user); // Thiết lập đối tượng UserEntity
        review.setRating(rating);
        review.setBinhluan(content);
        review.setReviewdate(LocalDate.now().toString()); // Chỉ lưu ngày hiện tại

        reviewService.saveReview(review);

        // Chuyển hướng về trang chi tiết tour và giữ lại trang hiện tại
        return "redirect:/home/tour/tour_details?tourid=" + tourId + "&page=1"; // Trả về trang đầu tiên
    }
}