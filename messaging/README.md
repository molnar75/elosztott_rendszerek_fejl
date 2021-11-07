# Stomp Websocket szerver + Jquery kliens
## Projekt használata
* Nyissuk meg az `messaging` projektünket eclipsben majd futtassuk.

        MessagingApplication.java vagy messaging mappa -> Run as -> Sping Boot App

* Az alkalmazás a http://localhost:8080/ porton indul el.
* A `connect` gombra kattintva csatlakozhatunk a szobához.
* Csatlakozás után a jobb oldali mezőbe beírt szöveget el tudjuk küldeni, ami küldés után egyből megjelenik a `Messages` alatt.
* Egy példa ilyen ünezetre:

      {"arrivedMessage":"Hello World!","sender":"me","target":"*"}
      
* A `Disconnect` gomb segítségével ki tudunk lépni a szobából, ilyenkor eltűnnek az üzenetek.