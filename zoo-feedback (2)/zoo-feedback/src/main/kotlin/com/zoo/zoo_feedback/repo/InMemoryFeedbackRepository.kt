/*Student Name: Chhatkuli Kapil
Student Id: M24W7304
 */
package com.zoo.zoo_feedback.repo

import com.zoo.zoo_feedback.model.Feedback
import org.springframework.stereotype.Repository

@Repository
class InMemoryFeedbackRepository {
    private val feedbacks = mutableListOf<Feedback>()

    fun save(feedback: Feedback) {
        feedbacks.add(feedback)
    }

    fun findAll(): List<Feedback> = feedbacks
}
