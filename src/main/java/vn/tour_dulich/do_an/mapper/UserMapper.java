package vn.tour_dulich.do_an.mapper;

import org.springframework.jdbc.core.RowMapper;
import vn.tour_dulich.do_an.Entity.UserEntity;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements RowMapper<UserEntity> {


    @Override
    public UserEntity mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        UserEntity userEntity = new UserEntity();
        userEntity.setId(resultSet.getLong("id"));
        userEntity.setUsername(resultSet.getString("username"));
        userEntity.setPassword(resultSet.getString("password"));
        userEntity.setFullname(resultSet.getString("fullname"));
        userEntity.setEmail(resultSet.getString("email"));
        userEntity.setPhonenumber(resultSet.getString("phonenumber"));
        userEntity.setGender(resultSet.getBoolean("gender"));
        userEntity.setAddress(resultSet.getString("address"));
        userEntity.setRole(resultSet.getString("role"));

        return userEntity;
    }

}
