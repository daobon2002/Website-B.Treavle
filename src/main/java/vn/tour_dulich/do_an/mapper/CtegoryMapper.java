package vn.tour_dulich.do_an.mapper;

import org.springframework.jdbc.core.RowMapper;
import vn.tour_dulich.do_an.Entity.CategoryEntity;


import java.sql.ResultSet;
import java.sql.SQLException;

public class CtegoryMapper implements RowMapper<CategoryEntity> {
    @Override
    public CategoryEntity mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        CategoryEntity categoryEntity = new CategoryEntity();
        categoryEntity.setId(resultSet.getLong("id"));
        categoryEntity.setTentheloai(resultSet.getString("tentheloai"));
        return categoryEntity;
    }
}
