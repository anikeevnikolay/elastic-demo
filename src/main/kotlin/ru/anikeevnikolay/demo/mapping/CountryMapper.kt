package ru.anikeevnikolay.demo.mapping

import org.springframework.stereotype.Service
import ru.anikeevnikolay.demo.domain.Country
import ru.anikeevnikolay.demo.model.CountryDto

@Service
class CountryMapper {

    //todo mapstruct
    fun map(entity: Country): CountryDto = CountryDto(
        id = entity.id,
        name = entity.name,
        language = entity.language,
        code = entity.code
    )

    fun map(dto: CountryDto): Country = Country(
        id = dto.id,
        name = dto.name,
        language = dto.language,
        code = dto.code
    )
}