package vn.tour_dulich.do_an.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public PasswordEncoder adminPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean(name = "adminSecurityFilterChain")
    public SecurityFilterChain securityFilterChainAdmin(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeHttpRequests(requests -> requests
                        .requestMatchers("/admin/**").authenticated()
                        .anyRequest().permitAll())
                .formLogin(form -> form
                        .loginPage("/admin/login")
                        .usernameParameter("username")
                        .passwordParameter("password")
                        .loginProcessingUrl("/admin/login")
                        .defaultSuccessUrl("/admin/home")
                        .failureUrl("/admin/login?error=access_denied")
                        .permitAll())
                .logout(logout -> logout.permitAll()); // Xử lý logout

        return http.build();
    }


}