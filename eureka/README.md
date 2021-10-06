# Eureka microservices
## Projekt használata
A projekt 4 modulból épül fel:

* eureka-server
* order-service
* storage-service
* gateway-service

Ezekhez a modulokhoz tartozik az eureka gyökerében egy `pom.xml` aminek a futtatásával egyszerre le tudjuk buildelni ezeket a modulokat. Érdemes az `erueka-server`-t először elindítani hogy a servicek tudjanak megfelelően csatlakozni a build során.

Ha az `eureka-server` projektet elindítottuk akkor a http://localhost:8761/ címen már elérhető a szerver felülete. Itt tudjuk nyomon követni hogy mely servicek csatlakoztak fel sikeresen.

Amint a build sikeresen lefutott indítsuk el mindegyik service projektet külön-külön: 

    *application.java vagy a fő mappa neve *-service -> Run as -> Spring Boot App

Ha esetleg bármelyik megadott port foglalt akkor az `application.properties` fileban a `server.port`-ot átírva lehet módosítani.

Amennyiben sikeresen elindultak a servicek akkor a http://localhost:8761/ címen az `Instances currently registered with Eureka` címsor alatt látnunk kell őket.

* Ha meghívjuk a http://localhost:8080/order végpontot akkor az `order-service` válaszát látjuk. Minden meghívással a `Remainincg products` száma csökken eggyel.
* Ha a http://localhost:8081/deliver végpontot hívjuk meg akkor a `storage-service` válaszát látjuk, azon belül is magának a productnak a számát amit már az előző meghívásokkal csökkentettünk. Amennyiben ezt is röbbször hívjuk meg itt is mindig csökken az érték.
* Ha ezek után ráfrissítünk az `order-service` végpontjára akkor láthatjuk, hogy ott is csökkent a mennyiség.  
* A http://localhost:8000 végponton a `gateway-service` érhető el. Rajta keresztül meg tudjuk hívni a többi servicet is. A http://localhost:8000/order végpont alatt tudjuk elérni az order-servicet, itt szintén a már csökkentett product számát látjuk.  