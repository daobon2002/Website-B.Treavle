package vn.tour_dulich.do_an.home.controller;

import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import vn.tour_dulich.do_an.Entity.BooktourEntity;
import vn.tour_dulich.do_an.Entity.TourEntity;
import vn.tour_dulich.do_an.home.service.EmailService;
import vn.tour_dulich.do_an.service.TourService;

import java.util.List;

@RestController
public class EmailController {

    @Autowired
    private EmailService emailService;

    @PostMapping("/sendEmail")
    public ResponseEntity<String> sendEmail(@RequestBody BooktourEntity bookingInfo) {
        try {
            emailService.sendEmail(
                    bookingInfo.getGmail(),
                    bookingInfo.getHoten(),
                    bookingInfo.getTentour(),
                    bookingInfo.getNgaythanhtoan(),
                    bookingInfo.getSodienthoai(),
                    bookingInfo.getSoluong(),
                    bookingInfo.getSotien()
            );
            return new ResponseEntity<>("Email đã được gửi thành công!", HttpStatus.OK);
        } catch (MessagingException e) {
            return new ResponseEntity<>("Lỗi khi gửi email: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @Autowired
    private TourService tourService; // Đảm bảo bạn đã thêm TourService

    @PostMapping("/sendEmails")
    public ResponseEntity<String> sendEmails(@RequestBody List<BooktourEntity> bookingInfos) {
        try {
            for (BooktourEntity bookingInfo : bookingInfos) {
                // Lấy thông tin tour từ bảng EntityTour
                TourEntity tour = tourService.findTourByName(bookingInfo.getTentour());

                if (tour == null) {
                    return new ResponseEntity<>("Không tìm thấy tour: " + bookingInfo.getTentour(), HttpStatus.NOT_FOUND);
                }

                // Gửi email cho từng bookingInfo với thông tin tour
                emailService.sendEmail1(
                        bookingInfo.getGmail(),
                        bookingInfo.getHoten(),
                        bookingInfo.getTentour(), // Tên tour
                        bookingInfo.getNgaythanhtoan(),
                        bookingInfo.getSodienthoai(),
                        bookingInfo.getSoluong(),
                        bookingInfo.getSotien(),
                        tour.getDiadiem(),
                        tour.getLichtrinh(),
                        tour.getPhuongtien(),
                        tour.getNgaykhoihanh(),
                        tour.getGia(),
                        tour.getMota(),
                        tour.getSoday(),
                        tour.getSoluongghe(),
                        tour.getNgaykhoihanh());
            }
            return new ResponseEntity<>("Tất cả email đã được gửi thành công!", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Lỗi khi gửi email: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PostMapping("/sendEmails1")
    public ResponseEntity<String> sendEmails1(@RequestBody List<BooktourEntity> bookingInfos) {
        try {
            for (BooktourEntity bookingInfo : bookingInfos) {
                TourEntity tour = tourService.findTourByName(bookingInfo.getTentour());

                if (tour == null) {
                    return new ResponseEntity<>("Không tìm thấy tour: " + bookingInfo.getTentour(), HttpStatus.NOT_FOUND);
                }

                emailService.sendEmails1(
                        bookingInfo.getGmail(),
                        bookingInfo.getHoten(),
                        bookingInfo.getTentour(), // Tên tour
                        bookingInfo.getNgaythanhtoan(),
                        bookingInfo.getSodienthoai(),
                        bookingInfo.getSoluong(),
                        bookingInfo.getSotien(),
                        tour.getDiadiem(),
                        tour.getLichtrinh(),
                        tour.getPhuongtien(),
                        tour.getNgaykhoihanh(),
                        tour.getGia(),
                        tour.getMota(),
                        tour.getSoday(),
                        tour.getSoluongghe(),
                        tour.getNgaykhoihanh());
            }
            return new ResponseEntity<>("Tất cả email đã được gửi thành công!", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Lỗi khi gửi email: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}