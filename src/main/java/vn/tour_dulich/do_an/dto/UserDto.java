package vn.tour_dulich.do_an.dto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UserDto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long Id;

    @NotEmpty(message = "Tên đăng nhập không được để trống.")
    @Size(min = 6, max = 15, message = "Tên đăng nhập phải từ 6 đến 15 ký tự.")
    private String username;

    @NotEmpty(message = "Mật khẩu không được để trống.")
    @Size(min = 6, max = 15, message = "Tên đăng nhập phải từ 6 đến 15 ký tự.")
    private String password;

    @NotEmpty(message = "Họ và tên không được để trống.")
    private String fullname;

    @NotEmpty(message = "Email không hợp lệ.")
    @Pattern(regexp = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")
    private String email;

    @NotEmpty(message = "Số điện thoại không được để trống.")
    @Pattern(regexp = "^0[0-9]{9}$", message = "Số điện thoại phải bắt đầu bằng số 0")
    private String phonenumber;

    private boolean gender;

    @NotEmpty(message = "Địa chỉ không được để trống.")
    private String address;

    private String role;

    @NotEmpty(message = "Mật khẩu không được để trống.")
    @Size(min = 6, max = 15, message = "Tên đăng nhập phải từ 6 đến 15 ký tự.")
    private String confirmPassword;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}