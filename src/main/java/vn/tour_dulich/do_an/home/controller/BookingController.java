package vn.tour_dulich.do_an.home.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import vn.tour_dulich.do_an.Entity.BooktourEntity;
import vn.tour_dulich.do_an.Entity.TourEntity;
import vn.tour_dulich.do_an.dto.BooktourDto;
import vn.tour_dulich.do_an.home.service.BookingService;
import vn.tour_dulich.do_an.home.service.EmailService;
import vn.tour_dulich.do_an.home.service.TourService;
import vn.tour_dulich.do_an.service.BooktourService;

import java.util.List;

@Controller
public class BookingController {
    @Autowired
    private TourService tourService;

    @Autowired
    private BookingService bookingService;



    @GetMapping("/home/booking")
    public String booking(@RequestParam("tourid") Long tourId, Model model){
        TourEntity tour = tourService.getTourById(tourId).orElse(null);
        model.addAttribute("tour", tour);
        return "/home/datlich";
    }

    @PostMapping("/saveBooking")
    public String saveBooking(@ModelAttribute BooktourDto booktourDto) {
        System.out.println("Tentour: " + booktourDto.getTentour()); // Kiểm tra giá trị
        bookingService.createBooking(booktourDto);
        return "redirect:/home/pay";
    }





}
