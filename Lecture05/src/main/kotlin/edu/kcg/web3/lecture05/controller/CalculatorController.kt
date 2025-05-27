package edu.kcg.web3.lecture05.controller

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam

@Controller
class CalculatorController {

    @GetMapping("/calculator")
    fun showCalculator(
        @RequestParam(required = false) num1: Double?,
        @RequestParam(required = false) num2: Double?,
        @RequestParam(required = false) operation: String?,
        model: Model
    ): String {
        if (num1 != null && num2 != null && operation != null) {
            val result = when (operation) {
                "add" -> num1 + num2
                "sub" -> num1 - num2
                "mul" -> num1 * num2
                "div" -> if (num2 != 0.0) num1 / num2 else null
                else -> null
            }

            model.addAttribute("num1", num1)
            model.addAttribute("num2", num2)
            model.addAttribute("operation", operation)

            if (result != null) {
                model.addAttribute("result", result)
            } else {
                model.addAttribute("error", "Invalid operation or divide by zero")
            }
        }

        return "calculator"
    }
}
