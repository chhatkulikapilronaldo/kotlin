package com.example.rolebasedloginlogger.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller
class LoginController {

    @GetMapping("/login")
    fun login(): String = "login"

    @GetMapping("/home")
    fun home(): String = "home"

    @GetMapping("/access-denied")
    fun denied(): String = "access-denied"
}
