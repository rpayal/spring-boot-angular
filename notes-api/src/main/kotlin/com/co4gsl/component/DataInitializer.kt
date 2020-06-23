package com.co4gsl.component

import com.co4gsl.entity.Note
import com.co4gsl.entity.NotesRepository
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.context.annotation.Profile
import org.springframework.stereotype.Component
import org.springframework.stereotype.Repository

@Profile("dev")
@Component
class DataInitializer(val repository: NotesRepository) : ApplicationRunner {

    @Throws(Exception::class)
    override fun run(args: ApplicationArguments?) {
        for (x in 0..1000) {
            repository.save(Note(title = "Note ${x}", text = "Text-${x}", username = "rpayal@hotmail.com"))
        }
        repository.findAll().forEach { println(it) }
    }
}