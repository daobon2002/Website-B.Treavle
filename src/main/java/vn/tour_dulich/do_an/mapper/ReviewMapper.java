package vn.tour_dulich.do_an.mapper;

import org.springframework.jdbc.core.RowMapper;
import vn.tour_dulich.do_an.Entity.ReviewEntity;
import vn.tour_dulich.do_an.Entity.UserEntity;
import vn.tour_dulich.do_an.Entity.TourEntity;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ReviewMapper implements RowMapper<ReviewEntity> {
    @Override
    public ReviewEntity mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        ReviewEntity reviewEntity = new ReviewEntity();
        reviewEntity.setId(resultSet.getLong("id"));

        // Gán giá trị cho UserEntity
        UserEntity user = new UserEntity();
        user.setFullname(resultSet.getString("fullname"));
        reviewEntity.setUserid(user);

        // Gán giá trị cho TourEntity
        TourEntity tour = new TourEntity();
        tour.setTentour(resultSet.getString("tentour"));
        reviewEntity.setTourid(tour);

        reviewEntity.setRating(resultSet.getInt("rating"));
        reviewEntity.setBinhluan(resultSet.getString("binhluan"));
        reviewEntity.setReviewdate(resultSet.getString("reviewdate"));

        return reviewEntity;
    }
}

