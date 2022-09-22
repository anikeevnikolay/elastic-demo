package ru.anikeevnikolay.demo.domain

import org.springframework.data.annotation.Id
import org.springframework.data.elasticsearch.annotations.*
import ru.anikeevnikolay.demo.util.AdditionalElasticField

@Document(indexName = "demo_country")
class Country(

    @Id
    var id: String,

    @MultiField(
        mainField = Field(type = FieldType.Text),
        otherFields = [InnerField(type = FieldType.Keyword, suffix = AdditionalElasticField.keyword)]
    )
    var name: String,

    @Field(type = FieldType.Keyword)
    var code: String,

    @Field(type = FieldType.Keyword)
    var language: String
)