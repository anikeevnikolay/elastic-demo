package ru.anikeevnikolay.demo.service.impl

import org.elasticsearch.index.query.QueryBuilder
import org.elasticsearch.index.query.QueryBuilders
import org.springframework.data.elasticsearch.core.ElasticsearchOperations
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder
import org.springframework.stereotype.Service
import ru.anikeevnikolay.demo.domain.Country
import ru.anikeevnikolay.demo.mapping.CountryMapper
import ru.anikeevnikolay.demo.model.CountryDto
import ru.anikeevnikolay.demo.repository.CountryRepository
import ru.anikeevnikolay.demo.service.CountryService

@Service
private class CountryServiceImpl(
    val operations: ElasticsearchOperations,
    val mapper: CountryMapper,
    val repo: CountryRepository
) : CountryService {
    override fun getById(id: String): CountryDto? = operations.get(id, Country::class.java)?.let { mapper.map(it) }

    //todo нафиг метод
    override fun getAll(): List<CountryDto> = repo.findAll().map { mapper.map(it) }

    override fun save(dto: CountryDto) {
        operations.save(mapper.map(dto))
    }

    override fun findByNameLike(searchPhrase: String): List<CountryDto> {
        val queryBuilder = QueryBuilders.matchPhraseQuery(Country::name.name, searchPhrase)
            as QueryBuilder
        val query = NativeSearchQueryBuilder()
            .withQuery(queryBuilder)
            .build()
        return operations.search(query, Country::class.java)
            .map { mapper.map(it.content) }
            .toList()
    }

    override fun delete(id: String) {
        operations.delete(id, Country::class.java)
    }
}