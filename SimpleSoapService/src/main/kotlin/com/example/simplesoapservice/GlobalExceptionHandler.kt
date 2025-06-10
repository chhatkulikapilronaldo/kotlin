package com.example.simplesoapservice

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.ErrorResponse
import org.springframework.web.bind.annotation.ExceptionHandler


@Controller
class GlobalExceptionHandler {


    @ExceptionHandler(Exception::class)
    fun handleException(ex: Exception): ResponseEntity<String> {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
            .body("An error occured: ${ex.message} ")
    }
}
