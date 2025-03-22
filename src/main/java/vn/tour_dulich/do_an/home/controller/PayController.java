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
import vn.tour_dulich.do_an.home.service.HomeService;
import vn.tour_dulich.do_an.home.service.PayService;

import java.util.List;
import java.util.Optional;

@Controller
public class PayController {
    @Autowired
    private PayService payService;

    @Autowired
    ChuyenTienService chuyenTienService;


    @GetMapping("/home/pay")
    public String pay(Model model){
        BooktourEntity latestBooking = payService.getLatestBooking();
        Optional<TourEntity> randomTour = payService.getAnyTour();

        if (randomTour.isPresent()) {
            model.addAttribute("tour", randomTour.get());
        } else {
            model.addAttribute("message", "Không tìm thấy tour nào.");
        }
        model.addAttribute("pay",latestBooking);
        return "/home/pay";
    }

    @PostMapping("/home/pay/complete")
    public String handlePaymentCompletion(
            @RequestParam("noiDungChuyenKhoan") String noiDungChuyenKhoan,
            @RequestParam("giaTien") String giaTien,
            Model model) {

        // Lưu thông tin vào cơ sở dữ liệu
        chuyenTienService.saveChuyenTien(noiDungChuyenKhoan, giaTien);

        // Gán giá trị vào model để hiển thị
        model.addAttribute("noiDungChuyenKhoan", noiDungChuyenKhoan);
        model.addAttribute("giaTien", giaTien + " VND");

        return "/home/pay";
    }
}
