/*
 * Student Name: Chhatkuli Kapil
 * Student ID: M24W7304
 */

package com.zoo.zoo_feedback.repo

import com.zoo.zoo_feedback.model.Feedback
import org.springframework.stereotype.Repository

// Marks this class as a Spring-managed repository component
@Repository
class InMemoryFeedbackRepository {

    // In-memory list to store feedback objects
    private val feedbacks = mutableListOf<Feedback>()

    // Saves a new feedback entry to the list
    fun save(feedback: Feedback) {
        feedbacks.add(feedback)
    }

    // Returns all stored feedback entries as a list
    fun findAll(): List<Feedback> = feedbacks
}
