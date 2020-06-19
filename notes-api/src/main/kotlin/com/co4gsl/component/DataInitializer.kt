package com.co4gsl.component

import com.co4gsl.entity.Note
import com.co4gsl.entity.NotesRepository
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.stereotype.Component
import org.springframework.stereotype.Repository

@Component
class DataInitializer(val repository: NotesRepository) : ApplicationRunner {

    @Throws(Exception::class)
    override fun run(args: ApplicationArguments?) {
        listOf("Note 1", "Note 2", "Note 3").forEach {
            repository.save(Note(title = it, text = it + " Text", user = "user"))
        }
        repository.findAll().forEach { println(it) }
    }
}