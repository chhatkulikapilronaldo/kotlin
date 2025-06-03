/*
 * Student Name: Chhatkuli Kapil
 * Student ID: M24W7304
 */

package com.zoo.zoo_feedback.controller

import com.zoo.zoo_feedback.model.Feedback
import com.zoo.zoo_feedback.repo.InMemoryFeedbackRepository
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*
import org.springframework.ui.Model

// Marks this class as a Spring MVC Controller that handles web requests
@Controller
class FeedbackController(
    // Dependency injection of the in-memory feedback repository
    private val feedbackRepo: InMemoryFeedbackRepository
) {

    // Route: GET /feedback-form
    // Description: Displays the feedback form page
    @GetMapping("/feedback-form")
    fun showForm(model: Model): String {
        // Add an empty Feedback object to the model to bind form data
        model.addAttribute("feedback", Feedback(
            "", "", "", "", "", "", "", "", "", "", "", "", "", ""
        ))
        // Return the name of the Thymeleaf template (feedback_form.html)
        return "feedback_form"
    }

    // Route: POST /submit-feedback
    // Description: Handles form submission and saves feedback data
    @PostMapping("/submit-feedback")
    fun submitForm(@ModelAttribute feedback: Feedback): String {
        // Save the submitted feedback to the in-memory repository
        feedbackRepo.save(feedback)
        // Redirect back to the form with a success flag
        return "redirect:/feedback-form?submitted=true"
    }

    // Route: GET /feedbacks
    // Description: Returns all submitted feedbacks as a JSON list
    @ResponseBody
    @GetMapping("/feedbacks")
    fun allFeedbacks(): List<Map<String, String>> {
        // Convert each Feedback object to a Map for display as JSON
        return feedbackRepo.findAll().map {
            mapOf(
                "Q1" to it.q1,
                "Q2" to it.q2,
                "Q3" to it.q3,
                "Q4" to it.q4,
                "Q5" to it.q5,
                "Q6" to it.q6,
                "Q7" to it.q7,
                "Q8" to it.q8,
                "Q9" to it.q9,
                "Q10" to it.q10,
                "Q11" to it.q11,
                "Q12" to it.q12,
                "Q13" to it.q13,
                "Comments" to it.comments
            )
        }
    }
}
