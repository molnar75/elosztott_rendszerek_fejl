# kafaka-producer
## Alkalmazás futtatása
Megnyitjuk a projektet eclipse sgítségével. 

    DemoApplication.java vagy kafka-producer mappa -> Run as -> Spring Boot App

Miután elindult az alkalmazás a http://localhost:8081/send-message végpontra POST hívással JSON formájában üzenetet tudunk küldeni.

JSON tartalma:

* `message`
* `from`
* `room`

A hívást megtehetjük például Postman segítségével, de parancssorból is a `curl` segítségével

    curl --header "Content-Type: application/json" 
     --request POST 
     --data "{\"message\":\"Hello World\", \"from\":\"producer\", \"room\":\"chat-room\"}" http://localhost:8081/send-message   

Ha sikeres az üzenet küldése akkor a következő üzenetet kapjuk a logok között:

    Success message SendResult [producerRecord=ProducerRecord(topic=chat-rooms, partition=null, headers=RecordHeaders(headers = [], isReadOnly = true), key=0, value={"message":"Hello World","from":"producer","room":"chat-room"}, timestamp=null), recordMetadata=chat-rooms-0@1]
