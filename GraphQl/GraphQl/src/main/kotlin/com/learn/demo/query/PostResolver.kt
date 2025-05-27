package com.learn.demo.query

import org.springframework.graphql.data.method.annotation.QueryMapping
import  org.springframework.stereotype.Controller
import java.util.UUID

@Controller
class PostResolver {

    @QueryMapping
    fun getPosts(): List<PostDto> {
        return listOf(
            PostDto(
                teacher = "Dr.Abar",
                title = "GraphQl Demo Project",
                greeting = "WelCome to my FirstGraphQl Spring Boot project"
            )
        )
    }
}

data class PostDto(
    val teacher: String,
    val title: String,
    val greeting: String? =null
)