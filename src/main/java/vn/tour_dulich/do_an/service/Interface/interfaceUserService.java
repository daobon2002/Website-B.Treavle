package vn.tour_dulich.do_an.service.Interface;

import org.springframework.data.domain.Page;
import vn.tour_dulich.do_an.Entity.UserEntity;

import java.util.List;

public interface interfaceUserService {
    List<UserEntity> getAll();

    List<UserEntity> searchUsers(String keyword);

    Page<UserEntity> getAll(Integer pageNo);
    Page<UserEntity> searchUsers(String keyword, Integer pageNumber);


}
