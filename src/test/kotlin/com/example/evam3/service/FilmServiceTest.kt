package com.example.evam3.service

import com.example.evam3.entity.Film
import com.example.evam3.repository.FilmRepository
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito

class FilmServiceTest {

    @Mock
    private lateinit var filmRepository: FilmRepository

    @InjectMocks
    private lateinit var filmService: FilmService

    @Test
    fun testList() {
    }

    @Test
    fun save() {
    }

    @Test
    fun update() {
    }

    @Test
    fun delete() {
    }
}