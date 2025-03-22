package vn.tour_dulich.do_an.Entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

@Entity
@Data
@Table(name = "chuyentien")
public class CKEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(name = "noidungchuyenkhoan")
    String noidungchuyenkhoan;
    @Column(name = "sotienchuyenkhoan")
    String sotienchuyenkhoan;
    @CreationTimestamp
    @Column(name = "thoigian")
    String thoigian;

    public String getThoigian() {
        return thoigian;
    }

    public void setThoigian(String thoigian) {
        this.thoigian = thoigian;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNoidungchuyenkhoan() {
        return noidungchuyenkhoan;
    }

    public void setNoidungchuyenkhoan(String noidungchuyenkhoan) {
        this.noidungchuyenkhoan = noidungchuyenkhoan;
    }

    public String getSotienchuyenkhoan() {
        return sotienchuyenkhoan;
    }

    public void setSotienchuyenkhoan(String sotienchuyenkhoan) {
        this.sotienchuyenkhoan = sotienchuyenkhoan;
    }
}
