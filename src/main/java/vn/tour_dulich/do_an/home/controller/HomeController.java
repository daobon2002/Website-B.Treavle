package vn.tour_dulich.do_an.home.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import vn.tour_dulich.do_an.Entity.TourEntity;
import vn.tour_dulich.do_an.home.service.HomeService;

import java.util.List;

@Controller("homeController1")
public class HomeController {

    @Autowired
    HomeService homeService;

    @GetMapping("/home")
    public String getTours(Model model) {
        List<TourEntity> tours = homeService.getRandomTours();
        List<TourEntity> beachTours = homeService.getBeachTours();
        List<TourEntity> northwestTours = homeService.getNuiTous();
        TourEntity highestPriceTour = homeService.getHighestPriceTour(); // Tour có giá cao nhất
        TourEntity secondHighestPriceTour = homeService.getSecondHighestPriceTour(); // Tour có giá cao thứ hai
        TourEntity thirdHighestPriceTour = homeService.getThirdHighestPriceTour(); // Tour có giá cao thứ ba

        model.addAttribute("tours", tours); // Danh sách tour ngẫu nhiên
        model.addAttribute("beachTours", beachTours); // Danh sách tour biển
        model.addAttribute("northwestTours", northwestTours); // Danh sách tour miền núi
        model.addAttribute("highestPriceTour", highestPriceTour);
        model.addAttribute("secondHighestPriceTour", secondHighestPriceTour);
        model.addAttribute("thirdHighestPriceTour", thirdHighestPriceTour);

        return "home/index"; // Đường dẫn chính xác tới template home.html
    }

    @GetMapping("/home/introduce")
    public String introduce() {
        return "home/gioithieu"; // Đường dẫn chính xác
    }
}