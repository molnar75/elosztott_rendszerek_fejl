# kafaka-consumer
## Alkalmazás futtatása
Megnyitjuk a projektet eclipse sgítségével. 

    DemoApplication.java vagy kafka-consumer mappa -> Run as -> Spring Boot App

Ha elindítjuk vele párhuzamosan a kafka-producert és azon keresztül üzenetet küldünk akkor azok megjelennek a logok között.

Üzenetre példa:

    {"message":"Hello World","from":"producer","room":"chat-room"}