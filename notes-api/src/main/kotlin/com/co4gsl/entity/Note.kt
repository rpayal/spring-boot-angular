package com.co4gsl.entity

import com.fasterxml.jackson.annotation.JsonIgnore
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.rest.core.annotation.RepositoryRestResource
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
data class Note (@Id @GeneratedValue var id: Long? = null,
                 var title: String? = null,
                 var text: String? = null,
                 @JsonIgnore var user: String? = null)

@RepositoryRestResource
interface NotesRepository : JpaRepository<Note, Long> {
    fun findAllByUser(name: String): List<Note>
}
