package com.example.rolebasedloginlogger.model

import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.slf4j.LoggerFactory
import org.springframework.security.core.Authentication
import org.springframework.security.web.authentication.AuthenticationSuccessHandler
import java.time.LocalDateTime

class CustomLoginSuccessHandler : AuthenticationSuccessHandler {
    private val logger = LoggerFactory.getLogger(CustomLoginSuccessHandler::class.java)

    override fun onAuthenticationSuccess(
        request: HttpServletRequest,
        response: HttpServletResponse,
        authentication: Authentication
    ) {
        val username = authentication.name
        val time = LocalDateTime.now()
        logger.info("User '$username' logged in at $time")

        response.sendRedirect("/home")
    }
}
