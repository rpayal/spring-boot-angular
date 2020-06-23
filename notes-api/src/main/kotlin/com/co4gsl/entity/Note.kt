package com.co4gsl.entity

import com.fasterxml.jackson.annotation.JsonIgnore
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.rest.core.annotation.RepositoryRestResource
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
data class Note (@Id @GeneratedValue var id: Long? = null,
                 var title: String? = null,
                 var text: String? = null,
                 @JsonIgnore var username: String? = null)

@RepositoryRestResource
interface NotesRepository : JpaRepository<Note, Long> {
    fun findAllByUsername(name: String, pageable: Pageable): Page<Note>
    fun findAllByUsernameAndTitle(name: String, title: String, pageable: Pageable): Page<Note>
}
