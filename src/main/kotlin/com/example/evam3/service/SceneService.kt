package com.example.evam3.service

import com.example.evam3.entity.Scene
import com.example.evam3.repository.SceneRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class SceneService {
    @Autowired
    lateinit var sceneRepository : SceneRepository

    fun list (): List<Scene>{
        return sceneRepository.findAll()
    }

    fun save(scene: Scene): Scene {
        try {
            scene.description?.takeIf { it.trim().isNotEmpty() }
                    ?: throw Exception("La descripción de la escena no debe estar vacía")

            return sceneRepository.save(scene)
        } catch (ex: Exception) {
            throw ResponseStatusException(HttpStatus.BAD_REQUEST, ex.message)
        }
    }

    fun update(scene: Scene): Scene {
        try{
            sceneRepository.findById(scene.id)
                ?:throw Exception("Id no existe")

            return sceneRepository.save(scene)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }

    fun updateBudget(scene: Scene): Scene {
        try {
            val response = sceneRepository.findById(scene.id)
                ?:throw Exception ("El Id escrito no existe")
            response.apply {
                budget=scene.budget
            }
            return sceneRepository.save(response)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }

    fun listById (id:Long?): Scene?{
        return sceneRepository.findById(id)
    }

    fun delete (id: Long?): Boolean?{
        try {
            val response = sceneRepository.findById(id)
                ?:throw Exception("El Id escrito no existe")
            sceneRepository.deleteById(id!!)
            return true
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }
}