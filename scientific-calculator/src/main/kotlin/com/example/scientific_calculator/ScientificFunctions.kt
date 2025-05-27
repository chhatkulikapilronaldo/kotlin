
/*Student Name: Chhatkuli kapil
student_id: M24W7304  */
package com.example.scientific_calculator

import kotlin.math.*

object ScientificFunctions {
    fun calculate(operation: String, input1: Double, input2: Double? = null): String {
        return try {
            val result = when (operation) {
                "+" -> input1 + (input2 ?: 0.0)
                "-" -> input1 - (input2 ?: 0.0)
                "*" -> input1 * (input2 ?: 0.0)
                "/" -> if (input2 == 0.0) "Division by zero" else (input1 / (input2 ?: 1.0)).toString()
                "^" -> input1.pow(input2 ?: 1.0)
                "square" -> input1.pow(2)
                "sqrt" -> sqrt(input1)
                "cbrt" -> cbrt(input1)
                "log10" -> log10(input1)
                "ln" -> ln(input1)
                "inv" -> if (input1 == 0.0) "Division by zero" else (1 / input1).toString()
                "sin" -> sin(input1)
                "cos" -> cos(input1)
                "tan" -> tan(input1)
                else -> "Invalid operation"
            }
            result.toString()
        } catch (e: Exception) {
            "Invalid input"
        }
    }
}
