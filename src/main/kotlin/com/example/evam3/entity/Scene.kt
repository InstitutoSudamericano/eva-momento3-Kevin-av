package com.example.evam3.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table

@Entity
@Table(name="scene")
class Scene {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(updatable = false, nullable = false)
    var id: Long? = null
    var description: String? = null
    var budget: Long? = null
    var minutes: Long? = null
    @ManyToOne
    @JoinColumn(name = "film_id", nullable = false)
    var film: Film? = null
}