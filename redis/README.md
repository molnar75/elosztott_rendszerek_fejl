# Redis
## Projekt használata
* Indítsuk el a Redis szervet egy docker konténerben a következő parancs segítségével: 

      docker run -p 16379:6379 -d redis:6.0 redis-server --requirepass "mypass"

* Nyissuk meg a `redis` projektet eclipsben majd futtassuk.

       RedisApplication.java vagy redis mappa -> Run as -> Sping Boot App
       
* Az alkalamzás a http://localhost:8080/ porton indul el.
* Egy `POST` kérést küldve a címre új személyt tudunk megadni. A küldendő JSON fomrátum a következő:

        {"id": "0", "firstname": "Test", "lastname": "User"}'
        
* Ezután a http://localhost:8080/person/ porton megadva a user id-ját le tudjuk kérdezni az adott személyt.

        http://localhost:8080/person/0

* Válaszként egy JSON dokumentumot kapunk ami a következő módon néz ki:

        {
            "id": "0",
            "firstname": "Test",
            "lastname": "User"
        }