package vn.tour_dulich.do_an.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import vn.tour_dulich.do_an.dto.UserDto;
import vn.tour_dulich.do_an.service.UserService;

@Controller
@RequestMapping("/admin")
public class loginController {

    @Autowired
    UserService userService;

    // Hiển thị form đăng nhập
    @GetMapping("/login")
    public String loginForm(Model model) {
        model.addAttribute("userDto", new UserDto()); // Chuẩn bị DTO cho form
        return "admin/login"; // Đảm bảo view `admin/login.html` tồn tại
    }

    // Xử lý đăng nhập
    @PostMapping("/login")
    public String login(UserDto userDto, Model model, HttpSession session,
                        @RequestParam(value = "redirectAdminPage", required = false) String redirectAdminPage) {
        UserDto user = userService.findByUsernameAndPassword(userDto.getUsername(), userDto.getPassword());

        if (user != null) {
            session.setAttribute("adminId", user.getId());

            if (redirectAdminPage != null) {
                return "redirect:" + redirectAdminPage; // Điều hướng đến trang được chỉ định
            }
            return "redirect:/admin/home"; // Trang chính của admin
        } else {
            model.addAttribute("error", "Đăng nhập thất bại! Vui lòng kiểm tra lại Username và mật khẩu.");
            return "admin/login"; // Trả về trang login với thông báo lỗi
        }
    }



    // Đăng xuất
    @GetMapping("/logout")
    public String logout(HttpSession session, SessionStatus sessionStatus) {
        session.invalidate(); // Xóa toàn bộ session
        sessionStatus.setComplete();
        return "redirect:/admin/login";
    }

}
