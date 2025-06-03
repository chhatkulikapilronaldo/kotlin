/*Student Name: Chhatkuli Kapil
Student Id: M24W7304
 */

package com.zoo.zoo_feedback.controller

import com.zoo.zoo_feedback.model.Feedback
import com.zoo.zoo_feedback.repo.InMemoryFeedbackRepository
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*
import org.springframework.ui.Model

@Controller
class FeedbackController(
    private val feedbackRepo: InMemoryFeedbackRepository
) {
//Feeedback_form API
    @GetMapping("/feedback-form")
    fun showForm(model: Model): String {
        model.addAttribute("feedback", Feedback(
            "", "", "", "", "", "", "", "", "", "", "", "", "", ""
        ))
        return "feedback_form"
    }
//submit feedback API
    @PostMapping("/submit-feedback")
    fun submitForm(@ModelAttribute feedback: Feedback): String {
        feedbackRepo.save(feedback)
        return "redirect:/feedback-form?submitted=true"
    }
//API feedback
    @ResponseBody
    @GetMapping("/feedbacks")
    fun allFeedbacks(): List<Map<String, String>> {
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
