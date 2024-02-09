package com.example.evam3.service

import com.example.evam3.entity.Character
import com.example.evam3.entity.Scene
import com.example.evam3.repository.CharacterRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class CharacterService {
    @Autowired
    lateinit var characterRepository: CharacterRepository

    fun list (): List<Character>{
        return characterRepository.findAll()
    }

    fun save (character: Character): Character{
        try {
            character.description?.takeIf { it.trim().isNotEmpty() }
                ?: throw Exception("La descripción del personaje no debe estar vacía")

            return characterRepository.save(character)
        } catch (ex: Exception) {
            throw ResponseStatusException(HttpStatus.BAD_REQUEST, ex.message)
        }
    }

    fun update (character: Character): Character{
        try{
            characterRepository.findById(character.id)
                ?:throw Exception("El Id ingresado no Existe")

            return characterRepository.save(character)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }

    fun updateCost(character: Character): Character {
        try {
            val response = characterRepository.findById(character.id)
                ?:throw Exception ("El Id escrito no existe")
            response.apply {
                cost=character.cost
            }
            return characterRepository.save(response)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }

    fun listById (id:Long?): Character?{
        return characterRepository.findById(id)
    }

    fun delete (id: Long?): Boolean?{
        try {
            val response = characterRepository.findById(id)
                ?:throw Exception("El Id escrito no existe")
            characterRepository.deleteById(id!!)
            return true
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }
}