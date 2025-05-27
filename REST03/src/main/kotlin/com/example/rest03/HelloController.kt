package com.example.rest03
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/hello")

class HelloController {
    @GetMapping
    fun sayHello(): String{
        return "simple REST API test"
    }

}