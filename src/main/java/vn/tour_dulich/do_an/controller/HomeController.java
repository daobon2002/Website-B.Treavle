package vn.tour_dulich.do_an.controller;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import vn.tour_dulich.do_an.Entity.CKEntity;
import vn.tour_dulich.do_an.Entity.UserEntity;
import vn.tour_dulich.do_an.home.resitory.ChuyenTienRepository;
import vn.tour_dulich.do_an.home.service.ChuyenTienService;
import vn.tour_dulich.do_an.repository.BooktourRepository;
import vn.tour_dulich.do_an.repository.CategotyRepository;
import vn.tour_dulich.do_an.repository.TourRepository;
import vn.tour_dulich.do_an.repository.UserRepository;

import java.security.Principal;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class HomeController {

    @Autowired
    UserRepository userRepository;
    @Autowired
    TourRepository tourRepository;
    @Autowired
    CategotyRepository categotyRepository;
    @Autowired
    BooktourRepository booktourRepository;

    @Autowired
    ChuyenTienService chuyenTienService;


    @GetMapping("")
    public String admin(Model model) {
        List<CKEntity> latestTransfers = chuyenTienService.getLatestFiveTransfers();
        model.addAttribute("Ck", latestTransfers);
        return "admin/home";

    }

    @GetMapping("/home")
    public String home(Model model) {
        List<CKEntity> latestTransfers = chuyenTienService.getLatestFiveTransfers();
        model.addAttribute("Ck", latestTransfers);
        return "admin/home";
    }
    @Autowired
    private EntityManager entityManager;

    @GetMapping("/revenue")
    @ResponseBody
    public int[] getMonthlyRevenue() {
        String sql = "SELECT sotien, MONTH(ngaythanhtoan) as month FROM datlich WHERE trangthai = 'Hoan Thanh'";
        Query query = entityManager.createNativeQuery(sql);
        List<Object[]> results = query.getResultList();

        // Initialize array with 12 months
        int[] revenueByMonth = new int[12];
        Arrays.fill(revenueByMonth, 0);

        // Tổng hợp doanh thu theo tháng
        for (Object[] result : results) {
            int month = (int) result[1] - 1; // Convert to 0-based index
            String revenueStr = (String) result[0];

            // Chuyển đổi từ String sang số nguyên
            int revenue = 0;
            try {
                revenue = Integer.parseInt(revenueStr.replace(",", "").trim()); // Loại bỏ dấu phẩy và chuyển đổi
            } catch (NumberFormatException e) {
                System.err.println("Không thể chuyển đổi giá trị: " + revenueStr);
            }

            revenueByMonth[month] += revenue;
        }

        return revenueByMonth;
    }

    @GetMapping("/userCount")
    @ResponseBody
    public long getUserCount() {
        return userRepository.count();
    }

    // Lấy số lượng thể loại tour
    @GetMapping("/tourTypeCount")
    @ResponseBody
    public long getTourTypeCount() {
        return categotyRepository.count();
    }

    @GetMapping("/tourCount")
    @ResponseBody
    public long getTourCount() {
        return tourRepository.count(); // Giả sử bạn có phương thức trong repository
    }

    // Lấy số lượng người đã đặt lịch thành công
    @GetMapping("/successfulBookings")
    @ResponseBody
    public long getSuccessfulBookings() {
        return booktourRepository.countSuccessfulBookings(); // Giả sử bạn có phương thức trong repository
    }


}
