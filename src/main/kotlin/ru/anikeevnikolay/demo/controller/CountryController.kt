package ru.anikeevnikolay.demo.controller

import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import ru.anikeevnikolay.demo.model.CountryDto
import ru.anikeevnikolay.demo.service.CountryService

@RestController
@RequestMapping("country")
class CountryController(
    val service: CountryService
) {

    @GetMapping("{id}")
    fun getById(@PathVariable id: String): CountryDto? = service.getById(id)

    @GetMapping("all")
    fun getAll(): List<CountryDto> = service.getAll()

    @PostMapping
    fun save(@RequestBody dto: CountryDto) = service.save(dto)

    @GetMapping("search")
    fun findByName(name: String): List<CountryDto> = service.findByNameLike(name)

    @DeleteMapping()
    fun deleteById(id: String) = service.delete(id)
}