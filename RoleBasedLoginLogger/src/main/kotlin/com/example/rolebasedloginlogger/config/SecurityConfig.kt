package com.example.rolebasedloginlogger.config

import com.example.rolebasedloginlogger.model.CustomLoginSuccessHandler
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.provisioning.InMemoryUserDetailsManager
import org.springframework.security.web.SecurityFilterChain

@Configuration
class SecurityConfig {

    @Bean
    fun userDetailsService(): UserDetailsService {
        val admin = User.withUsername("admin").password("{noop}admin123").roles("ADMIN").build()
        val user = User.withUsername("user").password("{noop}user123").roles("USER").build()
        return InMemoryUserDetailsManager(admin, user)
    }

    @Bean
    fun filterChain(http: HttpSecurity): SecurityFilterChain {
        http
            .authorizeHttpRequests {
                it.requestMatchers("/admin").hasRole("ADMIN")
                it.anyRequest().authenticated()
            }
            .formLogin {
                it.loginPage("/login")
                    .defaultSuccessUrl("/home", true)
                    .successHandler(CustomLoginSuccessHandler())
                    .permitAll()
            }
            .logout {
                it.logoutUrl("/logout")
                    .logoutSuccessUrl("/login?logout") // 👈 redirects to login with logout param
                    .invalidateHttpSession(true)
                    .deleteCookies("JSESSIONID")
                    .permitAll()
            }
            .exceptionHandling {
                it.accessDeniedPage("/access-denied")
            }

        return http.build()
    }
}
