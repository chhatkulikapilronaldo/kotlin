/*
 * Student Name: Chhatkuli Kapil
 * Student ID: M24W7304
 */

package com.zoo.zoo_feedback.model

// Data class to hold feedback responses for 13 survey questions and optional comments
data class Feedback(
    val q1: String,   // Response to Question 1
    val q2: String,   // Response to Question 2
    val q3: String,   // Response to Question 3
    val q4: String,   // Response to Question 4
    val q5: String,   // Response to Question 5
    val q6: String,   // Response to Question 6
    val q7: String,   // Response to Question 7
    val q8: String,   // Response to Question 8
    val q9: String,   // Response to Question 9
    val q10: String,  // Response to Question 10
    val q11: String,  // Response to Question 11
    val q12: String,  // Response to Question 12
    val q13: String,  // Response to Question 13
    val comments: String // Additional comments provided by the visitor
)
