package com.example.simplespringkotlin

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
@RestController
@RequestMapping("/")
class HelloController {
    @GetMapping

    fun hello(): String {
        return "Hello!!! I am kapil !!!"
    }

}