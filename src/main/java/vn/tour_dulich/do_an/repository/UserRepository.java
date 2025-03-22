package vn.tour_dulich.do_an.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import vn.tour_dulich.do_an.Entity.UserEntity;
import vn.tour_dulich.do_an.dto.UserDto;

import java.util.List;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    @Query("SELECT u FROM UserEntity u WHERE u.username LIKE %?1% OR u.fullname LIKE %?1% OR u.email LIKE %?1%")
    List<UserEntity> searchUserEntity(String keyword);

    UserEntity findByUsernameAndPassword(String username, String password);

    UserEntity findFirstByUsername(String username);

    UserEntity findByUsername(String username);

}



