package vn.tour_dulich.do_an.home.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import vn.tour_dulich.do_an.dto.UserDto;
import vn.tour_dulich.do_an.home.service.LoginService;
import vn.tour_dulich.do_an.service.UserService;

@Controller("homeLoginController")
@SessionAttributes("username")
@RequestMapping("/home")
public class HomeLoginController {

    @Autowired
    LoginService loginService;

    @GetMapping("/login")
    public String login(Model model, @RequestParam(value = "tourid", required = false) Long tourId) {
        model.addAttribute("userDto", new UserDto());


        if (tourId != null) {
            model.addAttribute("redirectTourId", tourId);
        }
        return "home/login";
    }
    @PostMapping("/login")
    public String login(UserDto userDto, Model model,
                        HttpSession session,
                        @RequestParam(value = "redirectTourId", required = false) Long redirectTourId) {
        UserDto user = loginService.findByUsernameAndPassword(userDto.getUsername(), userDto.getPassword());

        if (user != null) {
            model.addAttribute("username", user.getUsername());
            session.setAttribute("userId", user.getId());
            if (redirectTourId != null) {
                return "redirect:/home/tour/tour_details?tourid=" + redirectTourId;
            }
            return "redirect:/home";
        } else {
            model.addAttribute("error", "Đăng nhập thất bại! Vui lòng kiểm tra lại Username và mật khẩu.");
            return "home/login";
        }
    }
    @GetMapping("/logout")
    public String logout(SessionStatus sessionStatus) {
        sessionStatus.setComplete();
        return "redirect:/home";
    }
}
