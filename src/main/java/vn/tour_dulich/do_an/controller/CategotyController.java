package vn.tour_dulich.do_an.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.tour_dulich.do_an.Entity.BooktourEntity;
import vn.tour_dulich.do_an.Entity.CategoryEntity;
import vn.tour_dulich.do_an.Entity.NewsEntity;
import vn.tour_dulich.do_an.dto.CategoryDto;
import vn.tour_dulich.do_an.service.CategotyService;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class CategotyController {
    @Autowired
    CategotyService categotyService;

    @GetMapping("/category")
    public String listCategory(Model model, @RequestParam(name = "pageNumber", defaultValue = "1") Integer pageNumber, @Param("keyword") String keyword) {
        Page<CategoryEntity> categoryEntities = this.categotyService.getCategoryAll(pageNumber);
        if (keyword != null && !keyword.trim().isEmpty()) {
            categoryEntities = this.categotyService.searchCategory(keyword, pageNumber);
            model.addAttribute("keyword", keyword);
        }
        model.addAttribute("totalPage", categoryEntities.getTotalPages());
        model.addAttribute("currentPage", pageNumber);
        model.addAttribute("category", categoryEntities);
        return "admin/category";
    }

    @GetMapping("/category/create")
    public String showCategoryForm(Model model) {
        model.addAttribute("category", new CategoryDto());
        return "admin/category/createCategory";
    }

    @PostMapping("/category/create")
    public String createReview(@Valid @ModelAttribute("category") CategoryDto categoryDto, BindingResult result, RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            return "admin/category/createCategory";
        }
        try {
            categotyService.saveCategory(categoryDto);
            redirectAttributes.addFlashAttribute("successMessage", "Thể loại đã được tạo thành công.");
            return "redirect:/admin/category";
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Đã xảy ra lỗi khi tạo thể loại: " + e.getMessage());
            return "admin/category/createCategory";
        }
    }

    @GetMapping("/category/update/{id}")
    public String showEditCategoryForm(@PathVariable Long id, Model model) {
        CategoryDto categoryDto = categotyService.getCategoryDtoById(id);
        model.addAttribute("category", categoryDto);
        return "admin/category/updateCategory";
    }
    @PostMapping("/category/update")
    public String updateCategory(@Valid @ModelAttribute("category") CategoryDto categoryDto, BindingResult result, RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            return "admin/category/updateCategory"; // Đảm bảo rằng bạn trả về đúng view
        }
        try {
            categotyService.updateCategory(categoryDto.getId(), categoryDto); // Gọi updateCategory với CategoryDto
            redirectAttributes.addFlashAttribute("successMessage", "Cập nhật thể loại thành công.");
            return "redirect:/admin/category"; // Chuyển hướng về danh sách thể loại
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Đã xảy ra lỗi khi cập nhật thể loại: " + e.getMessage());
            return "admin/category/updateCategory"; // Trả về form nếu có lỗi
        }
    }

    @PostMapping("/category/delete/{id}")
    public String deleteCategory(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        try {
            categotyService.deleteById(id);
            redirectAttributes.addFlashAttribute("message", "Người dùng xoá thành công.");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "Đã xảy ra lỗi khi xoá người dùng.");
        }
        return "redirect:/admin/category";
    }
}




