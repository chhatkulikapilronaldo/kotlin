/*
 * Student Name: Chhatkuli Kapil
 * Student ID: M24W7304
 */

// Define the package for this application
package com.zoo.zoo_feedback

// Import necessary Spring Boot classes
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

// This annotation marks the class as the main entry point for a Spring Boot application
@SpringBootApplication
class ZooFeedbackApplication // Main application class

// Main function that starts the Spring Boot application
fun main(args: Array<String>) {
	runApplication<ZooFeedbackApplication>(*args) // Launches the application
}
