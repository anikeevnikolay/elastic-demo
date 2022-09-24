# elastic-demo
Демонстрация работы с эластиком

## Запуск
- Развернуть контейнеры
- Запустить приложение, чтобы корректно создался индекс эластика с нужным маппингом
- Создать топики по названиям индексов с желаемым числом партиций
- Загрузить класс для коннекта, выполнив команду внутри его образа `confluent-hub install confluentinc/kafka-connect-elasticsearch:14.0.0`
- Создать задачу коннекта с конфигом похожим на этот
```
{
  "name": "CountryElasticsearchSinkConnector",
  "config": {
    "connector.class": "io.confluent.connect.elasticsearch.ElasticsearchSinkConnector",
    "tasks.max": "1",
    "key.converter": "org.apache.kafka.connect.storage.StringConverter",
    "value.converter": "org.apache.kafka.connect.json.JsonConverter",
    "topics": "demo_country",
    "connection.url": "http://host.docker.internal:9200",
    "key.ignore": "false",
    "schema.ignore": "true",
    "value.converter.schemas.enable": "false"
  }
}
```
- Загрузить в одноименный с индексом топик данные в формате payload = {тело объекта без идентификатора}, key = id записи в эластике.
Ключ должен сериализоваться как строка, значение как JSON