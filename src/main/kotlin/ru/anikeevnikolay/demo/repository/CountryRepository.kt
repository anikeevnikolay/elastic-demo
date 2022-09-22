package ru.anikeevnikolay.demo.repository

import org.springframework.data.repository.PagingAndSortingRepository
import org.springframework.stereotype.Repository
import ru.anikeevnikolay.demo.domain.Country

@Repository
interface CountryRepository : PagingAndSortingRepository<Country, String>