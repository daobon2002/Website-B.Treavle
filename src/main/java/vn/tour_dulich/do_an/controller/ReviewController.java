package vn.tour_dulich.do_an.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.tour_dulich.do_an.Entity.ReviewEntity;
import vn.tour_dulich.do_an.service.ReviewService;

@Controller
@RequestMapping("/admin")
public class ReviewController {
    @Autowired
    private ReviewService reviewService;

//    @GetMapping("/review")
//    public  String listReview(Model model){
//        List<ReviewEntity> reviewEntity=reviewService.getAllReviews();
//        model.addAttribute("review",reviewEntity);
//        return "admin/review";
//    }

    @GetMapping("/review")
    public String listReviews(Model model, @RequestParam(name = "pageNumber", defaultValue = "1") Integer pageNumber, @Param("keyword") String keyword) {
        Page<ReviewEntity> reviewList = this.reviewService.getAllReviewsPaged(pageNumber);
        if (keyword != null) {
            reviewList = this.reviewService.searchReviewsPaged(keyword, pageNumber);
            model.addAttribute("keyword", keyword);
        }
        model.addAttribute("totalPage", reviewList.getTotalPages());
        model.addAttribute("currentPage", pageNumber);
        model.addAttribute("review", reviewList);
        return "admin/review";
    }
    @PostMapping("/review/delete/{id}")
    public String deleteReview(@PathVariable("id") Long id, RedirectAttributes redirectAttributes) {
        try {
            reviewService.deleteReview(id);
            redirectAttributes.addFlashAttribute("successMessage", "Tour đã được xóa thành công.");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Đã xảy ra lỗi khi xóa tour: " + e.getMessage());
        }
        return "redirect:/admin/review"; // Chuyển hướng đến danh sách tour sau khi xóa
    }


}
