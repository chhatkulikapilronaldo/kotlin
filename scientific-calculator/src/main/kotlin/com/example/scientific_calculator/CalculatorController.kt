/*Student Name: Chhatkuli kapil
student_id: M24W7304  */

/*Student Name: Chhatkuli kapil
student_id: M24W7304  */
package com.example.scientific_calculator

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam

@Controller
class CalculatorController {

    @GetMapping("/")
    fun index(model: Model): String {
        return "index"
    }

    @PostMapping("/calculate")
    fun calculate(
        @RequestParam operation: String,
        @RequestParam input1: String,
        @RequestParam(required = false) input2: String?,
        @RequestParam fullName: String,
        @RequestParam studentId: String,
        model: Model
    ): String {
        val num1 = input1.toDoubleOrNull()
        val num2 = input2?.toDoubleOrNull()

        val result = if (num1 != null) {
            ScientificFunctions.calculate(operation, num1, num2)
        } else {
            "Invalid numeric input"
        }

        model.addAttribute("result", result)
        model.addAttribute("fullName", fullName)
        model.addAttribute("studentId", studentId)

        return "index"
    }
}
