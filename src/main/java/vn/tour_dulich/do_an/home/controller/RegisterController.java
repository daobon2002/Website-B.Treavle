package vn.tour_dulich.do_an.home.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import vn.tour_dulich.do_an.dto.UserDto;
import vn.tour_dulich.do_an.home.service.LoginService;
import vn.tour_dulich.do_an.service.UserService;

@Controller
public class RegisterController {
    @Autowired
    private LoginService loginService;

    @GetMapping("home/register")
    public String register(Model model) {
        model.addAttribute("userDto", new UserDto());
        return "/home/register";
    }

    @PostMapping("/home/register")
    public String register(@Valid UserDto userDto,
                           BindingResult result,
                           Model model) {

        // Kiểm tra xem email đã tồn tại chưa
        if (loginService.emailExists(userDto.getEmail())) {
            result.rejectValue("email", "error.email", "Email đã tồn tại.");
        }

        // Nếu có lỗi, trả về form
        if (result.hasErrors()) {
            return "/home/register"; // Trở về trang đăng ký với lỗi
        }

        // Lưu người dùng (chuyển từ UserDto sang UserEntity nếu cần)
        loginService.saveUser(userDto);
        return "redirect:/home/login"; // Chuyển hướng đến trang đăng nhập
    }
}
