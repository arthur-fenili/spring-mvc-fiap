package com.challenge.sinister_buster.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                // Autorização de URLs
                .authorizeHttpRequests(auth -> auth
                        // Recursos estáticos liberados
                        .requestMatchers("/css/**", "/js/**", "/images/**").permitAll()
                        // Apenas ADMIN vê lista de pacientes
                        .requestMatchers("/paciente/lista").hasRole("ADMIN")
                        // ADMIN e USER veem lista de dentistas
                        .requestMatchers("/dentista/lista").hasAnyRole("ADMIN", "USER")
                        // Demais URLs exigem autenticação
                        .anyRequest().authenticated()
                )
                // Form-login usando a página padrão do Spring Security (/login automaticamente)
                .formLogin(form -> form
                        .defaultSuccessUrl("/dentista/lista", true)
                        .permitAll()
                )
                // Logout no padrão (POST /logout) e redireciona para login com ?logout
                .logout(logout -> logout
                        .logoutSuccessUrl("/login?logout")
                        .permitAll()
                );
        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService(PasswordEncoder encoder) {
        UserDetails user = User.builder()
                .username("user")
                .password(encoder.encode("senha"))
                .roles("USER")
                .build();
        UserDetails admin = User.builder()
                .username("admin")
                .password(encoder.encode("admin123"))
                .roles("ADMIN")
                .build();
        return new InMemoryUserDetailsManager(user, admin);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
