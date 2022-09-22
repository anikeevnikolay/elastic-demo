package ru.anikeevnikolay.demo.service

import ru.anikeevnikolay.demo.model.CountryDto

interface CountryService {

    fun getById(id: String): CountryDto?

    fun getAll(): List<CountryDto>

    fun save(dto: CountryDto)

    fun findByNameLike(name: String): List<CountryDto>

    fun delete(id: String)
}