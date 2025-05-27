package com.example.simpleform

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PostMapping

@Controller
class FormController {

    @GetMapping("/form")
    fun showForm(model: Model): String {
        model.addAttribute("formData", FormData())
        return "form"
    }

    @PostMapping("/form")
    fun processForm(@ModelAttribute("formData") formData: FormData): String {
        // You can process the form data here, e.g., save it to a database
        return "result"
    }
}