package com.example.json02

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api")
class PersonController {
    @GetMapping("/person")
    fun getPersons(): Map<String, Person> {
        return mapOf(
            "person1" to Person("Ella", 25),
            "person2" to Person("Alfie", 30),
            "person3" to Person("Anne", 20)
        )
    }


    /*fun getPerson(): Person {
        return Person("Ella", 25)
        //return Person("Alfie", 30)
       // return Person("Anne", 20)
    }*/

}