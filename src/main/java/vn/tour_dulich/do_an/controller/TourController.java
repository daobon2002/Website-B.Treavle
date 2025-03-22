package vn.tour_dulich.do_an.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.tour_dulich.do_an.Entity.CategoryEntity;
import vn.tour_dulich.do_an.Entity.TourEntity;

import vn.tour_dulich.do_an.dto.TourDto;
import vn.tour_dulich.do_an.dto.UserDto;
import vn.tour_dulich.do_an.repository.TourRepository;
import vn.tour_dulich.do_an.service.CategotyService;
import vn.tour_dulich.do_an.service.TourService;


import java.util.List;
import java.util.Scanner;

@Controller
@RequestMapping("/admin")
public class TourController {
    @Autowired
    CategotyService categotyService;
    @Autowired
    TourService tourService;

    @GetMapping("/tour")
    public String listTours(Model model, @RequestParam(name = "pageNumber", defaultValue = "1") Integer pageNumber, @Param("keyword") String keyword) {
        Page<TourEntity> tourEntities = this.tourService.getAll(pageNumber);
        if (keyword != null && !keyword.trim().isEmpty()) {
            tourEntities = this.tourService.searchTour(keyword, pageNumber);
            model.addAttribute("keyword", keyword);
        }
        model.addAttribute("totalPage", tourEntities.getTotalPages());
        model.addAttribute("currentPage", pageNumber);
        model.addAttribute("tour", tourEntities); // Sửa 'category' thành 'tours'
        return "admin/tour";
    }

    @GetMapping("/tour/create")
    public String showCreateTourForm(Model model) {
        TourDto tour = new TourDto(); // Thay đổi từ TourEntity sang TourDto
        model.addAttribute("tour", tour);
        List<CategoryEntity> loaiTours = categotyService.getAll(); // Lấy danh sách loại tour
        model.addAttribute("loaiTours", loaiTours);
        return "admin/tour/createTour"; // Trả về tên trang Thymeleaf
    }

    @PostMapping("/tour/create")
    public String saveTour(@Valid @ModelAttribute("tour") TourDto tourDto, BindingResult result, RedirectAttributes redirectAttributes) {
        // Kiểm tra lỗi xác thực
        if (result.hasErrors()) {
            return "admin/tour/createTour"; // Trả về trang tạo tour nếu có lỗi
        }

        // Kiểm tra xem hình ảnh có được tải lên không
        if (tourDto.getImage() == null || tourDto.getImage().isEmpty()) {
            result.rejectValue("image", "error.image", "Vui lòng tải lên hình ảnh.");
            return "admin/tour/createTour"; // Trả về trang tạo tour nếu không có hình ảnh
        }

        try {
            // Lưu tour vào cơ sở dữ liệu
            tourService.saveTour(tourDto);
            redirectAttributes.addFlashAttribute("successMessage", "Tour đã được tạo thành công.");
            return "redirect:/admin/tour"; // Chuyển hướng đến danh sách tour
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Đã xảy ra lỗi khi tạo tour: " + e.getMessage());
            return "admin/tour/createTour"; // Trả về trang tạo tour nếu có lỗi
        }
    }

    @GetMapping("/tour/update/{id}")
    public String showUpdateTourForm(@PathVariable("id") Long id, Model model) {
        TourDto tour = tourService.findById(id);
        model.addAttribute("tour", tour);
        List<CategoryEntity> loaiTours = categotyService.getAll();
        model.addAttribute("loaiTours", loaiTours);
        return "admin/tour/updateTour";
    }
    @PostMapping("/tour/update")
    public String updateTour(@ModelAttribute TourDto tourDto, RedirectAttributes redirectAttributes) {
        try {
            tourService.updateTour(tourDto); // Gọi service để cập nhật tour
            redirectAttributes.addFlashAttribute("successMessage", "Tour đã được cập nhật thành công.");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Đã xảy ra lỗi khi cập nhật tour: " + e.getMessage());
        }
        return "redirect:/admin/tour"; // Chuyển hướng đến danh sách tour
    }

    @PostMapping("/tour/delete/{id}")
    public String deleteTour(@PathVariable("id") Long id, RedirectAttributes redirectAttributes) {
        try {
            tourService.deleteTour(id);
            redirectAttributes.addFlashAttribute("successMessage", "Tour đã được xóa thành công.");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Đã xảy ra lỗi khi xóa tour: " + e.getMessage());
        }
        return "redirect:/admin/tour"; // Chuyển hướng đến danh sách tour sau khi xóa
    }




}
