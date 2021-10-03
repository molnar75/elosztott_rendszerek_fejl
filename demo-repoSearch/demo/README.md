# Spring alkalmazás

## A projekt futtatása

1.Nyissuk meg a projektet Eclipse segítségével. 

2.A DemoApplication.java vagy demo projekt mappa -> Run as -> Spring Boot App

* Ezután az elindult alkalmazás a böngészőből a http://localhost:8080 címen érhető el. 
*     http://localhost:8080/
* Amint a végpontra egy GET kérést küldünk megjelenik a bal felső sarokban a `Hello World!` felirat.
*     http://localhost:8080/calculator
* A `/calulcator` végpont 3 query paramétert vár, 2 számot és egy operátort és a számok összegét adja vissza JSON formátumban. A végpont paraméterek nélküli meghívása `400 Bad Request` választ eredményez.

*     http://localhost:8080/calculator?operandus1=1&operandus2=1&operator=+
* Ha megadjuk az operandusokat akkor már lefut a számítás és az eredmény bal felül jelenik meg. Jelen esetben 2.0 látható a képernyőn.
*     http://localhost:8080/repoSearch
* A `/repoSearch` végpont 1 query string paramétert vár. Az alkalmazás a Github API-t hívja meg és lekérdezi a paraméterként megkapott stringre illeszkedő repoknak a listáját. Ezt válaszként JSON formátumban adja vissza. Ha nem adjuk meg ezt a paramétert akkor a stringre beállított `@NonNull` miatt az oldal `500 Internal Server Error` választ ad.
*     http://localhost:8080/repoSearch?queryString=hello
* Ha megadjuk a paramétert akkor lefut a kérés és például a `hello` értékre a következő választ kapjuk:
*     ["phonegap-start","HelloGitHub","hello","Hello-World","hello-algorithm","ycy","decaffeinate","example-helloworld","ruby-hello-world","alexa","groundwork","HelloCodeSchoolProject","helloflask","phonegap-template-hello-world","howdy","HelloDaemon","hellocharts-android","helloworld","pifafu","hello-world","Hello-world","hello","dockercloud-hello-world","maven-hello-world","cordova-plugin-hello","algorithm-study","hellogitworld","hello-world","node-hello","aframe-boilerplate"]

