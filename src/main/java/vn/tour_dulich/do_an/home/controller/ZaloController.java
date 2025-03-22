package vn.tour_dulich.do_an.home.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import vn.tour_dulich.do_an.Entity.BooktourEntity;
import vn.tour_dulich.do_an.Entity.TourEntity;
import vn.tour_dulich.do_an.home.service.ChuyenTienService;
import vn.tour_dulich.do_an.home.service.PayService;

import java.util.Optional;

@Controller
public class ZaloController {

    @Autowired
    private PayService payService;

    @Autowired
    ChuyenTienService chuyenTienService;


        @GetMapping("/home/pay/zalo")
        public String pay(Model model){
            BooktourEntity latestBooking = payService.getLatestBooking();
            Optional<TourEntity> randomTour = payService.getAnyTour();

            if (randomTour.isPresent()) {
                model.addAttribute("tour", randomTour.get());
            } else {
                model.addAttribute("message", "Không tìm thấy tour nào.");
            }
            model.addAttribute("pay",latestBooking);
            return "/home/ZaloPay";
        }

        @PostMapping("/home/pay/zalo/complete")
        public String handlePaymentCompletion(
                @RequestParam("noiDungChuyenKhoan") String noiDungChuyenKhoan,
                @RequestParam("giaTien") String giaTien,
                Model model) {


            chuyenTienService.saveChuyenTien(noiDungChuyenKhoan, giaTien);

            model.addAttribute("noiDungChuyenKhoan", noiDungChuyenKhoan);
            model.addAttribute("giaTien", giaTien + " VND");

            return "/home/ZaloPay";
        }
    }

