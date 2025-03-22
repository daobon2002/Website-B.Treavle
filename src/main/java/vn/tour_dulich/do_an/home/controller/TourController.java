package vn.tour_dulich.do_an.home.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import vn.tour_dulich.do_an.Entity.CategoryEntity;
import vn.tour_dulich.do_an.Entity.TourEntity;
import vn.tour_dulich.do_an.home.service.TourService;

import java.util.List;

@Controller("homeTourController") // Specify a unique bean name
@RequestMapping("/home")
public class TourController {
    @Autowired
    TourService tourService;

    @GetMapping("/tour")
    public String listTours(Model model,
                            @RequestParam(name = "categoryid", required = false) Long categoryId,
                            @RequestParam(name = "pageNumber", defaultValue = "1") Integer pageNumber,
                            @Param("keyword") String keyword) {

        Page<TourEntity> tourEntities;

        if (keyword != null && !keyword.trim().isEmpty()) {
            tourEntities = this.tourService.searchTour(keyword, pageNumber);
            model.addAttribute("keyword", keyword);
        } else if (categoryId != null) {
            tourEntities = this.tourService.getToursByCategory(categoryId, pageNumber);
            model.addAttribute("selectedCategory", categoryId);
        } else {
            tourEntities = this.tourService.getAll(pageNumber);
        }

        List<CategoryEntity> categoryEntities = tourService.getAllCategories();
        model.addAttribute("categories", categoryEntities);
        model.addAttribute("totalPage", tourEntities.getTotalPages());
        model.addAttribute("currentPage", pageNumber);
        model.addAttribute("tour", tourEntities);
        return "/home/tour"; // Trả về view hiển thị danh sách tour
    }


}
