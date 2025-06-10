package com.example.soapostrequestsample

import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/user")
class UserController {

    private val users = mutableListOf(
        user(1, "Sa", "alice@example.com"),
        user(2, "Bob", "bob@example.com")
    )

    @GetMapping
    fun getAllUsers(): List<user> = users

    @PostMapping
    fun createUser(@RequestBody user: user): String {
        users.add(user)
        return "User added: ${user.name}"
    }
}
