package vn.tour_dulich.do_an.Entity;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "tour")
public class TourEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "tentour", nullable = false, length = 100)
    private String tentour;

    @Column(name = "image")
    private String image;

    @Column(name = "mota", columnDefinition = "TEXT")
    private String mota;

    @Column(name = "gia")
    private String gia;

    @ManyToOne
    @JoinColumn(name = "loaitour_id", referencedColumnName = "id", nullable = false) // Sửa đổi ở đây
    private CategoryEntity category;

    @Column(name = "lichtrinh")
    private String lichtrinh;

    @Column(name = "phuongtien")
    private String phuongtien;

    @Column(name = "soday")
    private Integer soday;

    @Column(name = "diadiem", length = 100)
    private String diadiem;

    @Column(name="soluongghe")
    private Integer soluongghe;

    @Column(name = "ngaykhoihanh")
    private String ngaykhoihanh;
    @Column(name = "uudai")
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

    public Integer getSoluongghe() {
        return soluongghe;
    }

    public void setSoluongghe(Integer soluongghe) {
        this.soluongghe = soluongghe;
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

    public CategoryEntity getCategory() {
        return category;
    }

    public void setCategory(CategoryEntity category) {
        this.category = category;
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

    public String getNgaykhoihanh() {
        return ngaykhoihanh;
    }

    public void setNgaykhoihanh(String ngaykhoihanh) {
        this.ngaykhoihanh = ngaykhoihanh;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}