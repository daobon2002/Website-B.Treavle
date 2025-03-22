package vn.tour_dulich.do_an.service;

import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import vn.tour_dulich.do_an.Entity.CategoryEntity;
import vn.tour_dulich.do_an.Entity.TourEntity;
import vn.tour_dulich.do_an.Entity.UserEntity;
import vn.tour_dulich.do_an.dto.CategoryDto;
import vn.tour_dulich.do_an.dto.UserDto;
import vn.tour_dulich.do_an.repository.UserRepository;
import vn.tour_dulich.do_an.service.Interface.interfaceUserService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService implements interfaceUserService {

    @Autowired
    UserRepository userRepository;


    @Autowired
    private PasswordEncoder passwordEncoder;


    @Override
    public List<UserEntity> getAll() {
        return null;
    }

    @Override
    public List<UserEntity> searchUsers(String keyword) {
        return userRepository.searchUserEntity(keyword);
    }

    @Override
    public Page<UserEntity> getAll(Integer pageNumber) {
        Pageable pageable = PageRequest.of(pageNumber - 1, 10);
        return userRepository.findAll(pageable);
    }
    @Override
    public Page<UserEntity> searchUsers(String keyword, Integer pageNumber) {
        List<UserEntity> list = this.searchUsers(keyword);
        Pageable pageable = PageRequest.of(pageNumber - 1, 10);
        int start = (int) pageable.getOffset();
        int end = Math.min(start + pageable.getPageSize(), list.size());
        List<UserEntity> subList = list.subList(start, end);
        return new PageImpl<>(subList, pageable, list.size());
    }


    public void saveUser(UserDto userDto) {
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername(userDto.getUsername());

        // Mã hóa mật khẩu trước khi lưu
        String encodedPassword = passwordEncoder.encode(userDto.getPassword());
        userEntity.setPassword(encodedPassword);

        userEntity.setFullname(userDto.getFullname());
        userEntity.setGender(userDto.isGender());
        userEntity.setEmail(userDto.getEmail());
        userEntity.setPhonenumber(userDto.getPhonenumber());
        userEntity.setAddress(userDto.getAddress());
        userEntity.setRole(userDto.getRole());

        userRepository.save(userEntity);
    }
    public void updateUser(UserDto userDto) {
        Optional<UserEntity> userEntityOptional = userRepository.findById(userDto.getId());
        if (userEntityOptional.isPresent()) {
            UserEntity userEntity = userEntityOptional.get();

            // Update the fields with new values
            userEntity.setUsername(userDto.getUsername());

            // Only encode the password if it is not empty
            if (userDto.getPassword() != null && !userDto.getPassword().isEmpty()) {
                String encodedPassword = passwordEncoder.encode(userDto.getPassword());
                userEntity.setPassword(encodedPassword);
            }

            userEntity.setFullname(userDto.getFullname());
            userEntity.setGender(userDto.isGender());
            userEntity.setEmail(userDto.getEmail());
            userEntity.setPhonenumber(userDto.getPhonenumber());
            userEntity.setAddress(userDto.getAddress());
            userEntity.setRole(userDto.getRole());

            userRepository.save(userEntity); // Save updated user back to the database
        } else {
            throw new RuntimeException("User not found with id: " + userDto.getId());
        }
    }
    public UserDto getUserById(Long id) {
        Optional<UserEntity> userEntityOptional = userRepository.findById(id);
        if (userEntityOptional.isPresent()) {
            UserEntity userEntity = userEntityOptional.get();
            return convertToDto(userEntity); // Assuming you have a method to convert UserEntity to UserDto
        }
        return null; // Or throw an exception if you prefer
    }

    private UserDto convertToDto(UserEntity userEntity) {
        UserDto userDto = new UserDto();
        userDto.setId(userEntity.getId());
        userDto.setUsername(userEntity.getUsername());
        userDto.setPassword(userEntity.getPassword());
        userDto.setFullname(userEntity.getFullname());
        userDto.setGender(userEntity.getGender());
        userDto.setEmail(userEntity.getEmail());
        userDto.setPhonenumber(userEntity.getPhonenumber());
        userDto.setAddress(userEntity.getAddress());
        userDto.setRole(userEntity.getRole());
        return userDto;
    }
    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }


    public boolean login(String username, String password) {
        UserEntity user = userRepository.findByUsername(username);
        if (user != null && passwordEncoder.matches(password, user.getPassword())) {
            return true;
        }
        return false;
    }
    public UserDto findByUsernameAndPassword(String username, String password) {
        UserEntity userEntity = userRepository.findByUsername(username);
        if (userEntity != null && passwordEncoder.matches(password, userEntity.getPassword())) {
            return convertToDto(userEntity); // Chuyển đổi UserEntity sang UserDto
        }
        return null;
    }



}
