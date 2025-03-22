package vn.tour_dulich.do_an.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.tour_dulich.do_an.Entity.BooktourEntity;
import vn.tour_dulich.do_an.dto.BooktourDto;
import vn.tour_dulich.do_an.dto.NewsDto;
import vn.tour_dulich.do_an.service.BooktourService;

import java.util.Map;
import java.util.Optional;

@Controller
@RequestMapping("/admin")
public class BooktourController {
    @Autowired
    BooktourService booktourService;

    @GetMapping("/booktour")
    public String listReview(Model model, @RequestParam(name = "pageNumber", defaultValue = "1") Integer pageNumber, @Param("keyword") String keyword) {
        Page<BooktourEntity> booktourEntities = this.booktourService.getBooktourAll(pageNumber);
        if (keyword != null && !keyword.trim().isEmpty()) {
            booktourEntities = this.booktourService.searchBooktour(keyword, pageNumber);
            model.addAttribute("keyword", keyword);
        }

        model.addAttribute("totalPage", booktourEntities.getTotalPages());
        model.addAttribute("currentPage", pageNumber);
        model.addAttribute("booktour", booktourEntities);
        return "admin/booktour";
    }

    // Method to show the edit form
    @GetMapping("/booktour/update")
    public String showUpdateBooktourForm(@RequestParam("id") Long id, Model model) {
        BooktourDto booktourDto = booktourService.getBooktourDtoById(id);
        if (booktourDto == null) {
            return "redirect:/admin/booktour";
        }
        model.addAttribute("booktour", booktourDto);
        return "admin/booktour/updateBooktour";
    }


    @PostMapping("/booktour/update")
    public String updateBooktour(@Valid @ModelAttribute("booktour") BooktourEntity booktourEntity,
                                 BindingResult result,
                                 RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            return "admin/booktour/updateBooktour";
        }
        try {
            booktourService.updateBooktour(booktourEntity.getId(), booktourEntity);
            redirectAttributes.addFlashAttribute("successMessage", "Cập nhật đặt tour thành công.");
            return "redirect:/admin/booktour";
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Đã xảy ra lỗi khi cập nhật đặt tour: " + e.getMessage());
            return "admin/booktour/updateBooktour";
        }
    }
    @PostMapping("/booktour/update-status")
    @ResponseBody
    public ResponseEntity<String> updateStatus(@RequestBody Map<String, String> payload) {
        try {
            Long id = Long.parseLong(payload.get("id"));
            String newStatus = payload.get("trangthai");
            booktourService.updateStatus(id, newStatus);
            return ResponseEntity.ok("Cập nhật thành công!");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Lỗi: " + e.getMessage());
        }
    }



}