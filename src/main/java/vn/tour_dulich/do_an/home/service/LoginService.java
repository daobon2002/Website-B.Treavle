package vn.tour_dulich.do_an.home.service;

import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import vn.tour_dulich.do_an.Entity.UserEntity;
import vn.tour_dulich.do_an.dto.UserDto;
import vn.tour_dulich.do_an.repository.UserRepository;
import vn.tour_dulich.do_an.service.Interface.interfaceUserService;

import java.util.List;

@Service
public class LoginService  {

    @Autowired
    UserRepository userRepository;


    @Autowired
    private PasswordEncoder passwordEncoder;



    private UserDto convertToUserDto(UserEntity userEntity) {
        UserDto userDto = new UserDto();
        userDto.setId(userEntity.getId());
        userDto.setUsername(userEntity.getUsername());
        userDto.setFullname(userEntity.getFullname());

        if (userEntity.getGender() != null) {
            userDto.setGender(userEntity.getGender());
        } else {
            userDto.setGender(false);
        }

        userDto.setEmail(userEntity.getEmail());
        userDto.setPhonenumber(userEntity.getPhonenumber());
        userDto.setAddress(userEntity.getAddress());
        userDto.setRole(userEntity.getRole());
        return userDto;
    }



    public UserDto findByUsernameAndPassword(String username, String password) {
        UserEntity userEntity = userRepository.findByUsername(username);
        if (userEntity != null && passwordEncoder.matches(password, userEntity.getPassword())) {
            return convertToUserDto(userEntity); // Chuyển đổi UserEntity sang UserDto
        }
        return null;
    }

    public boolean login(String username, String password) {
        UserEntity user = userRepository.findByUsername(username);
        if (user != null && passwordEncoder.matches(password, user.getPassword())) {
            return true;
        }
        return false;
    }

    public boolean emailExists(String username) {
        return userRepository.findByUsername(username) != null;
    }
        public String saveUser(UserDto userDto) {
        UserEntity userEntity = new UserEntity();
        BeanUtils.copyProperties(userDto, userEntity);

        userEntity.setPassword(passwordEncoder.encode(userDto.getPassword()));
        userRepository.save(userEntity);
        return "OK";
    }




}
