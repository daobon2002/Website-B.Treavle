package vn.tour_dulich.do_an.mapper;

import org.springframework.jdbc.core.RowMapper;
import vn.tour_dulich.do_an.Entity.BooktourEntity;
import vn.tour_dulich.do_an.Entity.TourEntity;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BooktourMapper implements RowMapper<BooktourEntity> {
    @Override
    public BooktourEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
        BooktourEntity booktourEntity=new BooktourEntity();
        booktourEntity.setId(rs.getLong("id"));
        booktourEntity.setHoten(rs.getString("hoten"));
        booktourEntity.setGmail(rs.getString("gmail"));
        booktourEntity.setSodienthoai(rs.getString("sodienthoai"));
        booktourEntity.setTentour(rs.getString("tentour"));
        booktourEntity.setSoluong(rs.getInt("soluong"));
        booktourEntity.setSotien(rs.getString("sotien"));
        booktourEntity.setNgaythanhtoan(rs.getString("ngaythanhtoan"));
        booktourEntity.setTrangthai(rs.getString("trangthai"));
        return booktourEntity;
    }
}
