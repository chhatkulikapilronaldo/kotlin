package edu.kcg.web3.lecture05.config
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.web.SecurityFilterChain

@EnableWebSecurity
class SecurityConfig {

    private val logger = LoggerFactory.getLogger(SecurityConfig::class.java)

    @Autowired
    fun configureGlobal(auth: AuthenticationManagerBuilder, passwordEncoder: PasswordEncoder) {
        logger.info("Configuring in-memory authentication")
        auth.inMemoryAuthentication()
            .withUser("user")
            .password(passwordEncoder.encode("password"))
            .roles("USER")
            .and()
            .withUser("admin")
            .password(passwordEncoder.encode("password"))
            .roles("ADMIN")
    }

    @Bean
    fun filterChain(http: HttpSecurity): SecurityFilterChain {
        http
            .logout()
            .logoutUrl("/logout")
            .logoutSuccessUrl("/")
            .invalidateHttpSession(true)
            .and()
            .authorizeRequests()
            .antMatchers("/", "/login", "/css/**").permitAll()
            .antMatchers("/calculator", "/calculate").authenticated()
            .antMatchers("/home").hasAnyRole("USER", "ADMIN")
            .antMatchers("/admin/**").hasRole("ADMIN")
            .anyRequest().authenticated()
            .and()
            .formLogin()

        return http.build()
    }


}
