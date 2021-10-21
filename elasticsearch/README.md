# Elasticsearch

* Első lépésként le kell húznunk az elasticsearch imaget:

      docker pull docker.elastic.co/elasticsearch/elasticsearch:7.15.1

* Ezután futtatjuk a konténert:

      docker run -p 9200:9200 -p 9300:9300 -e "discovery.type=single-node" docker.elastic.co/elasticsearch/elasticsearch:7.15.1

* A http://localhost:9200/ címre egy `GET` kérést küldünk és ha megfelelően elindult a szerver akkor a következő JSON válaszhoz hasonlót kell kapjunk:

      {
        "name" : "19e041b787ce",
        "cluster_name" : "docker-cluster",
        "cluster_uuid" : "lMoqryNqRKWWDKHdluE8qA",
        "version" : {
            "number" : "7.15.1",
            "build_flavor" : "default",
            "build_type" : "docker",
            "build_hash" : "83c34f456ae29d60e94d886e455e6a3409bba9ed",
            "build_date" : "2021-10-07T21:56:19.031608185Z",
            "build_snapshot" : false,
            "lucene_version" : "8.9.0",
            "minimum_wire_compatibility_version" : "6.8.0",
            "minimum_index_compatibility_version" : "6.0.0-beta1"
        },
        "tagline" : "You Know, for Search"
      }
    
* Nyissuk meg az `elasticsearch` projektünket eclipsben majd futtassuk.

        DemoApplication.java vagy elasticsearch mappa -> Run as -> Sping Boot App
        
* Ezután a http://localhost:8080/ porton lesz elérhető a szerver ami már kapcsolódott is az elasticseach-höz. 
* Ha az elasticsearch-t nem indítottuk el, akkor a szerver nem fog tudni elindulni.
* Amennyiben a `/chat` végpontra egy post kérést küldünk a ChatMessageDto-ban meghatározott struktúra szerint akkor belerakja a rendszer az üzenetet az elasticsearchbe.
* Példa az üzenetre: 

      {
        "id": "1",
        "message": "Hello World!",
        "sender": "Fanni",
        "roomId": "1",
        "roomName": "room"
      }
      
* Ha sikeres a küldés akkor a `/chat` végpontra ha küldünk egy `GET` kérést aminek a bodyjában megadunk egy `query` értéket, akkor tudunk szűrni az üzenetekre `sender` alapján.
* Például ha én a következő body-t küldöm:

      {
      "query": "Fanni"
      } 
      
* Akkor a következő üzenetet kapom válaszként: 

      {
        "content": [
            {
                "id": "1",
                "message": "Hello World!",
                "sender": "Fanni",
                "roomId": "1",
                "roomName": "room"
            }
        ],
        "pageable": {
            "sort": {
                "empty": true,
                "sorted": false,
                "unsorted": true
            },
            "offset": 0,
            "pageNumber": 0,
            "pageSize": 10,
            "unpaged": false,
            "paged": true
        },
        "last": true,
        "totalPages": 1,
        "totalElements": 1,
        "size": 10,
        "number": 0,
        "sort": {
            "empty": true,
            "sorted": false,
            "unsorted": true
        },
        "numberOfElements": 1,
        "first": true,
        "empty": false
      }
      
* Látható hogy legfelül megjelent az imént elküldött üzenetem. 
* Kereshetünk message alapján is a `/chat/bymessage` végponton. A query ugyan úgy néz ki mint az előbb csak az értékének a `message` értékét adjuk meg. 

      {
      "query": "Hello World!"
      } 

* A válasz pontosan ugyan az lesz mint az előző esetben. 