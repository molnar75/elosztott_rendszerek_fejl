# Kafka topicon keresztül történő kommunikáció

A spring alkalmazásához először is szükséges a kafka konténer elindítása.

Ehhez a `kafka-borker` mappába belépve futtatni kell a `docker-compose up -d` parancsot.

Miután a konténer elindult a `kafka-producer` és a `kafka-consumer` alkalmazásokat kell elindítanunk. 

Mind a kettő alkalmazás gyökreében található 1-1 README.md file ami ebben, és a kommunikációban segítséget nyújt. 

A konténerek listáját a `docker ps` paranccsal tudjuk lekérdezni.

Amint megvan a konténer id-ja be tudunk lépni a shelljébe és rá tudunk állítani egy consumert és egy producert egy test topicra.

    docker exec -it kontener_id bash

Ezután be kell lépnünk a bin mappába:

    cd opt/kafka/bin
    
Itt már ki tudjuk listázni a megnyitott topicokat:

    kafka-topics.sh --bootstrap-server :9092 --list
    
Majd két külön terminálból eldinítjuk a consumert:

    kafka-console-consumer.sh --bootstrap-server :9092 --topic test
    
Majd a producert:

    kafka-console-producer.sh --bootstrap-server :9092 --topic test
    
A producer termináljában megjelenik egy `>` jel. Ami üzenetet ezután írunk majd elküldjük megjelenik a consumer termináljában.