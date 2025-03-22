package vn.tour_dulich.do_an.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.tour_dulich.do_an.Entity.NewsEntity;
import vn.tour_dulich.do_an.dto.NewsDto;
import vn.tour_dulich.do_an.service.NewsService;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;

@Controller
@RequestMapping("/admin")
public class NewsController {
    @Autowired
    private NewsService newsService;

    @GetMapping("/news")
    public String listNews(Model model, @RequestParam(name = "pageNumber", defaultValue = "1") Integer pageNumber, @Param("keyword") String keyword) {
        Page<NewsEntity> newsList = this.newsService.getNewsAll(pageNumber);
        if (keyword != null && !keyword.trim().isEmpty()) {
            newsList = this.newsService.searchNews(keyword, pageNumber);
            model.addAttribute("keyword", keyword);
        }
        model.addAttribute("totalPage", newsList.getTotalPages());
        model.addAttribute("currentPage", pageNumber);
        model.addAttribute("news", newsList);
        return "admin/news";
    }

    @GetMapping("/news/create")
    public String showCreateNewsForm(Model model) {
        model.addAttribute("news", new NewsDto());
        return "admin/news/createNews";
    }

    @PostMapping("/news/create")
    public String createNews(@Valid @ModelAttribute("news") NewsDto newsDto, BindingResult result, Model model, RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            model.addAttribute("errorMessage", "Có lỗi xảy ra trong quá trình tạo tin tức. Vui lòng kiểm tra lại các trường nhập liệu.");
            return "admin/news/createNews";
        }
        if (newsDto.getImage() == null || newsDto.getImage().isEmpty()) {
            result.rejectValue("image", "error.image", "Vui lòng tải lên hình ảnh.");
            model.addAttribute("errorMessage", "Vui lòng tải lên hình ảnh.");
            return "admin/news/createNews"; // Trả về trang tạo tin tức nếu không có hình ảnh
        }

        try {
            newsService.createNews(newsDto);
            redirectAttributes.addFlashAttribute("successMessage", "Tin tức đã được tạo thành công.");
            return "redirect:/admin/news"; // Chuyển hướng đến danh sách tin tức
        } catch (Exception e) {
            model.addAttribute("errorMessage", "Lỗi xảy ra khi tạo tin tức: " + e.getMessage());
            return "admin/news/createNews"; // Trả về trang tạo tin tức nếu có lỗi
        }
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
        dateFormat.setLenient(false); // Strict parsing để kiểm tra lỗi định dạng
        binder.registerCustomEditor(LocalDateTime.class, new CustomDateEditor(dateFormat, false));
    }

    @GetMapping("/news/update")
    public String showUpdateNewsForm(@RequestParam("id") Long id, Model model) {
        NewsDto newsDto = newsService.getNewsById(id);
        if (newsDto == null) {
            return "redirect:/admin/news"; // Chuyển hướng nếu không tìm thấy tin tức
        }
        model.addAttribute("news", newsDto);
        return "admin/news/update"; // Trả về trang sửa tin tức
    }

    @PostMapping("/news/update")
    public String updateNews(@Valid @ModelAttribute("news") NewsDto newsDto, BindingResult result, RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            return "admin/news/update"; // Trả về trang sửa tin tức nếu có lỗi
        }
        try {
            newsService.updateNews(newsDto.getId(), newsDto);
            redirectAttributes.addFlashAttribute("successMessage", "Tin tức đã được cập nhật thành công.");
            return "redirect:/admin/news"; // Chuyển hướng đến danh sách tin tức
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Đã xảy ra lỗi khi cập nhật tin tức: " + e.getMessage());
            return "admin/news/update"; // Trả về trang sửa tin tức nếu có lỗi
        }
    }



    @PostMapping("/news/delete")
    public String deleteNews(@RequestParam("id") Long id, RedirectAttributes redirectAttributes) {
        try {
            newsService.deleteNewsById(id);
            redirectAttributes.addFlashAttribute("successMessage", "Tin tức đã được xóa thành công.");
        } catch (DataIntegrityViolationException ex) {
            redirectAttributes.addFlashAttribute("errorMessage", "Không thể xóa bản ghi này vì nó đang có liên kết với các bản ghi khác.");
        }
        return "redirect:/admin/news";
    }

}
