package vn.tour_dulich.do_an.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Table(name = "review")
@Data
@Entity
public class ReviewEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "userid", nullable = false)
    private UserEntity userid;

    @ManyToOne
    @JoinColumn(name = "tourid", nullable = false)
    private TourEntity tourid;

    @Column(name = "rating", nullable = false)
    private int rating;

    @Column(name = "binhluan", columnDefinition = "TEXT")
    private String binhluan;

    @Column(name = "reviewdate", nullable = false)
    private String reviewdate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserEntity getUserid() {
        return userid;
    }

    public void setUserid(UserEntity userid) {
        this.userid = userid;
    }

    public TourEntity getTourid() {
        return tourid;
    }

    public void setTourid(TourEntity tourid) {
        this.tourid = tourid;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getBinhluan() {
        return binhluan;
    }

    public void setBinhluan(String binhluan) {
        this.binhluan = binhluan;
    }

    public String getReviewdate() {
        return reviewdate;
    }

    public void setReviewdate(String reviewdate) {
        this.reviewdate = reviewdate;
    }
}
