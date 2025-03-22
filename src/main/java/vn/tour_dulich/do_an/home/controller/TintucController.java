package vn.tour_dulich.do_an.home.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import vn.tour_dulich.do_an.Entity.CategoryEntity;
import vn.tour_dulich.do_an.Entity.NewsEntity;
import vn.tour_dulich.do_an.home.service.HomeNewsService;
import vn.tour_dulich.do_an.service.NewsService;

import java.util.List;

@Controller("homeTintucController")
@RequestMapping("/home")
public class TintucController {

    @Autowired
    HomeNewsService newsService;

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
        return "home/tintuc";
    }
//    @GetMapping("/news")
//    public String getNews(@RequestParam(defaultValue = "0") int page, Model model) {
//        Page<NewsEntity> newsPage = homeNewsService.getAllNews(PageRequest.of(page, 5));
//        model.addAttribute("news", newsPage.getContent());
//        model.addAttribute("currentPage", page);
//        model.addAttribute("totalPages", newsPage.getTotalPages());
//
//        return "/home/tintuc";
//    }


}
