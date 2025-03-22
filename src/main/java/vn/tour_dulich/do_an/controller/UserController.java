package vn.tour_dulich.do_an.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.tour_dulich.do_an.Entity.UserEntity;
import vn.tour_dulich.do_an.dto.UserDto;
import vn.tour_dulich.do_an.service.UserService;

@Controller
@RequestMapping("/admin")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/user")
    public String listUsers(Model model, @RequestParam(name = "keyword", required = false) String keyword, @RequestParam(name = "pageNumber", defaultValue = "1") Integer pageNumber) {
        Page<UserEntity> userList = userService.getAll(pageNumber);
        if (keyword != null && !keyword.isEmpty()) {
            userList = userService.searchUsers(keyword, pageNumber);
            model.addAttribute("keyword", keyword);
        }

        model.addAttribute("totalPage", userList.getTotalPages());
        model.addAttribute("currentPage", pageNumber);
        model.addAttribute("user", userList);
        return "admin/user";
    }

    @GetMapping("/user/create")
    public String showCreateUserForm(Model model) {
        model.addAttribute("user", new UserDto());
        return "admin/createUser";
    }
    @PostMapping("/user/create")
    public String createUser(@Valid @ModelAttribute("user") UserDto userDto, BindingResult result, RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            result.getAllErrors().forEach(error -> System.out.println("Error: " + error.getDefaultMessage()));
            return "admin/createUser";
        }
        try {
            userService.saveUser(userDto);
            redirectAttributes.addFlashAttribute("successMessage", "Người dùng tạo thành công.");
            return "redirect:/admin/user";
        } catch (Exception e) {
            e.printStackTrace();
            redirectAttributes.addFlashAttribute("errorMessage", "Đã xảy ra lỗi khi tạo người dùng: " + e.getMessage());
            return "redirect:/admin/user/create";
        }
    }
    @GetMapping("/user/update/{id}")
    public String showUpdateUserForm(@PathVariable Long id, Model model) {
        UserDto userDto = userService.getUserById(id); // Get the user details by ID
        if (userDto == null) {
            return "redirect:/admin/user"; // Redirect if user not found
        }
        model.addAttribute("user", userDto);
        return "admin/update"; // Return the update form view
    }

    @PostMapping("/user/update")
    public String updateUser(@Valid @ModelAttribute("user") UserDto userDto, BindingResult result, RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            return "admin/update"; // Return to the form if there are validation errors
        }
        try {
            userService.updateUser(userDto); // Update the user
            redirectAttributes.addFlashAttribute("successMessage", "Người dùng cập nhật thành công.");
            return "redirect:/admin/user"; // Redirect to the user list
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Đã xảy ra lỗi khi cập nhật người dùng: " + e.getMessage());
            return "redirect:/admin/user/update/" + userDto.getId(); // Redirect back on error
        }
    }



    @PostMapping("/user/delete/{id}")
    public String deleteUser(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        try {
            userService.deleteUserById(id);
            redirectAttributes.addFlashAttribute("message", "Người dùng xoá thành công.");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "Đã xảy ra lỗi khi xoá người dùng.");
        }
        return "redirect:/admin/user";
    }
}


//    @PostMapping("/user/update")
//    public String updateUser(@Valid @ModelAttribute("user") UserDto userDto, BindingResult result, RedirectAttributes redirectAttributes) {
//        if (result.hasErrors()) {
//            return "admin/update";
//        }
//        try {
//            userService.updateUser(userDto);
//            redirectAttributes.addFlashAttribute("successMessage", "Người dùng cập nhật thành công.");
//            return "redirect:/admin/user";
//        } catch (Exception e) {
//            redirectAttributes.addFlashAttribute("errorMessage", "Đã xảy ra lỗi khi cập nhật người dùng: " + e.getMessage());
//            return "redirect:/admin/user/update/" + userDto.getId();
//        }
//    }
