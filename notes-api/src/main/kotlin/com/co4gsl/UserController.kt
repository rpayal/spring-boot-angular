package com.co4gsl

import com.co4gsl.entity.Note
import com.co4gsl.entity.NotesRepository
import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.security.oauth2.core.oidc.user.OidcUser
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import java.security.Principal

@RestController
class UserController(val repository: NotesRepository) {

    @GetMapping("/user/notes")
    fun notes(principal: Principal): List<Note> {
        println("Fetching all notes for user: ${principal.name}")
        val notes = repository.findAllByUser(principal.name)
        if (notes.isEmpty()) {
            return listOf()
        } else {
            return notes
        }
    }

    @GetMapping("/user")
    fun user(@AuthenticationPrincipal user: OidcUser) : OidcUser {
        return user
    }
}