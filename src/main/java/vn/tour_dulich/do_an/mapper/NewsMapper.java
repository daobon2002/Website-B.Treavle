package vn.tour_dulich.do_an.mapper;

import org.springframework.jdbc.core.RowMapper;
import vn.tour_dulich.do_an.Entity.NewsEntity;

import java.sql.ResultSet;
import java.sql.SQLException;

public class NewsMapper implements RowMapper<NewsEntity> {
    @Override
    public NewsEntity mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        NewsEntity newsEntity = new NewsEntity();
        newsEntity.setId(resultSet.getLong("id"));
        newsEntity.setTieude(resultSet.getString("tieude"));
        newsEntity.setNoidung(resultSet.getString("noidung"));
        newsEntity.setAuthor(resultSet.getString("author"));
        newsEntity.setNgaydang(resultSet.getString("ngaydang"));
        newsEntity.setImage(resultSet.getString("image"));
        return newsEntity;
    }
}
