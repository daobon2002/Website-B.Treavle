package vn.tour_dulich.do_an.dto;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;


@Data
public class TourDto {
    private Long id;

    @NotEmpty(message = "Không được để trống")
    private String tentour;

    @NotNull(message = "Không được để trống")
    private MultipartFile image;

    @NotEmpty(message = "Không được để trống")
    private String mota;

    @NotNull(message = "Không được để trống")
    private String gia;

    @NotNull(message = "Không được để trống")
    private Long loaitourId;

    @NotEmpty(message = "Không được để trống")
    private String lichtrinh;

    @NotEmpty(message = "Không được để trống")
    private String phuongtien;

    @NotNull(message = "Không được để trống")
    private Integer soday;

    @NotEmpty(message = "Không được để trống")
    private String diadiem;

    @NotNull(message = "Không được để trống")
    private Integer soluongghe;

    @NotEmpty(message = "Không được để trống")
    private String ngaykhoihanh;

    @NotNull(message = "Không được để trống")
    private Integer uudai;

    public Integer getUudai() {
        return uudai;
    }

    public void setUudai(Integer uudai) {
        this.uudai = uudai;
    }

    public String getLichtrinh() {
        return lichtrinh;
    }

    public void setLichtrinh(String lichtrinh) {
        this.lichtrinh = lichtrinh;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTentour() {
        return tentour;
    }

    public void setTentour(String tentour) {
        this.tentour = tentour;
    }

    public MultipartFile getImage() {
        return image;
    }

    public void setImage(MultipartFile image) {
        this.image = image;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }

    public String getGia() {
        return gia;
    }

    public void setGia(String gia) {
        this.gia = gia;
    }

    public Long getLoaitourId() {
        return loaitourId;
    }

    public void setLoaitourId(Long loaitourId) {
        this.loaitourId = loaitourId;
    }

    public String getPhuongtien() {
        return phuongtien;
    }

    public void setPhuongtien(String phuongtien) {
        this.phuongtien = phuongtien;
    }

    public Integer getSoday() {
        return soday;
    }

    public void setSoday(Integer soday) {
        this.soday = soday;
    }

    public String getDiadiem() {
        return diadiem;
    }

    public void setDiadiem(String diadiem) {
        this.diadiem = diadiem;
    }

    public Integer getSoluongghe() {
        return soluongghe;
    }

    public void setSoluongghe(Integer soluongghe) {
        this.soluongghe = soluongghe;
    }

    public String getNgaykhoihanh() {
        return ngaykhoihanh;
    }

    public void setNgaykhoihanh(String ngaykhoihanh) {
        this.ngaykhoihanh = ngaykhoihanh;
    }

    public TourDto() {
    }

}
