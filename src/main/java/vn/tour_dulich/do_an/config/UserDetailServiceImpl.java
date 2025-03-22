package t3h.vn.bookshopclient_2408.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import vn.tour_dulich.do_an.Entity.UserEntity;
import vn.tour_dulich.do_an.repository.UserRepository;

import java.util.Collection;
import java.util.List;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Tìm user trong cơ sở dữ liệu
        UserEntity user = userRepository.findFirstByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("Không tồn tại user với username: " + username);
        }

        // Kiểm tra role và in log để xác minh
        System.out.println("Đã tìm thấy user: " + user.getUsername());
        System.out.println("Role của user: " + user.getRole());

        // Trả về thông tin UserDetails
        return new UserDetailImpl(user);
    }


    public static class UserDetailImpl implements UserDetails {
        @Getter
        private final UserEntity user;

        public UserDetailImpl(UserEntity user) {
            this.user = user;
        }
        @Override
        public Collection<? extends GrantedAuthority> getAuthorities() {
            System.out.println("Phân quyền: " + user.getRole());
            return List.of(new SimpleGrantedAuthority(user.getRole()));
        }

        @Override
        public String getPassword() {
            return user.getPassword();
        }

        @Override
        public String getUsername() {
            return user.getUsername();
        }

        @Override
        public boolean isAccountNonExpired() {
            return true;
        }

        @Override
        public boolean isAccountNonLocked() {
            return true;
        }

        @Override
        public boolean isCredentialsNonExpired() {
            return true;
        }

        @Override
        public boolean isEnabled() {
            return true;
        }
    }
}
