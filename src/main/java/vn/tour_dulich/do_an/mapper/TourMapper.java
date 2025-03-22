package vn.tour_dulich.do_an.mapper;

import org.springframework.jdbc.core.RowMapper;
import vn.tour_dulich.do_an.Entity.CategoryEntity;
import vn.tour_dulich.do_an.Entity.TourEntity;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TourMapper implements RowMapper<TourEntity> {
    @Override
    public TourEntity mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        TourEntity tourEntity = new TourEntity();
        tourEntity.setId(resultSet.getLong("id")); // Khóa chính
        tourEntity.setTentour(resultSet.getString("tentour")); // Tên tour
        tourEntity.setMota(resultSet.getString("mota")); // Mô tả
        tourEntity.setGia(resultSet.getString("gia")); // Giá

        // Fetch the category by ID (sửa đổi ở đây)
        CategoryEntity categoryEntity = new CategoryEntity();
        categoryEntity.setId(resultSet.getLong("loaitour_id")); // Lấy ID của loại tour
        tourEntity.setCategory(categoryEntity); // Gán loại tour

        tourEntity.setLichtrinh(resultSet.getString("lichtrinh")); // Phương tiện
        tourEntity.setPhuongtien(resultSet.getString("phuongtien")); // Phương tiện
        tourEntity.setSoday(resultSet.getInt("soday")); // Số ngày
        tourEntity.setDiadiem(resultSet.getString("diadiem")); // Địa điểm khởi hành
        tourEntity.setNgaykhoihanh(resultSet.getString("ngaykhoihanh")); // Ngày khởi hành
        tourEntity.setSoluongghe(resultSet.getInt("soluongghe")); // Số lượng ghế
        tourEntity.setImage(resultSet.getString("image")); // Ảnh tour
        tourEntity.setUudai(resultSet.getInt("uudai")); // Số lượng ghế


        return tourEntity;
    }
}