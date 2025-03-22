package vn.tour_dulich.do_an.dto;

import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotEmpty;
import vn.tour_dulich.do_an.Entity.TourEntity;

public class BooktourDto {

    Long id;
    @NotEmpty(message = "Không được để trống")
    String hoten;
    @NotEmpty(message = "Không được để trống")
    @Column(name = "gmail")
    String gmail;
    @NotEmpty(message = "Không được để trống")
    @Column(name = "sodienthoai")
    String sodienthoai;
    @NotEmpty(message = "Không được để trống")
    @Column(name = "soluong")
    Integer soluong;

    @NotEmpty(message = "Không được để trống")
    String tentour;
    @NotEmpty(message = "Không được để trống")
    @Column(name = "sotien")
    String sotien;
    @NotEmpty(message = "Không được để trống")
    @Column(name = "ngaythanhtoan")
    String ngaythanhtoan;
    @NotEmpty(message = "Không được để trống")
    @Column(name = "trangthai")
    String trangthai;


    public String getTrangthai() {
        return trangthai;
    }

    public void setTrangthai(String trangthai) {
        this.trangthai = trangthai;
    }

    public Long getId() {
        return id;
    }

    public Integer getSoluong() {
        return soluong;
    }

    public void setSoluong(Integer soluong) {
        this.soluong = soluong;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public String getGmail() {
        return gmail;
    }

    public void setGmail(String gmail) {
        this.gmail = gmail;
    }

    public String getSodienthoai() {
        return sodienthoai;
    }

    public void setSodienthoai(String sodienthoai) {
        this.sodienthoai = sodienthoai;
    }

    public String getTentour() {
        return tentour;
    }

    public void setTentour(String tentour) {
        this.tentour = tentour;
    }

    public String getSotien() {
        return sotien;
    }

    public void setSotien(String sotien) {
        this.sotien = sotien;
    }

    public String getNgaythanhtoan() {
        return ngaythanhtoan;
    }

    public void setNgaythanhtoan(String ngaythanhtoan) {
        this.ngaythanhtoan = ngaythanhtoan;
    }
}
