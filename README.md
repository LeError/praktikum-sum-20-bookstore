# Entwicklung von Enterprise-Backend-Applikationen mit Spring Boot

Dieses Projekt wurde für das SAP Sommerpraktikum (MAK) 2020 angelegt.

### Aufgabe

* Benötigte Queries im JPA Repository ([IBookRepository.java](srv/src/main/java/com/sap/devcamp/bookstore/repositories/IBookRepository.java)) 
anlegen. 
  * Umsetzen einer findAll Query oder nutzen der default Variante
  * Umsetzen einer findOneByIsbn Query oder nutzen der default Variante
  * Umsetzen einer findBooksByAuthorLike Query
  * Umsetzen einer deleteBookByIsbn Query oder nutzen der default Variante
  * Umsetzen einer existsBookByIsbn Query oder nutzen der default Variante
* Implementiere das Interface [IBookService.java](srv/src/main/java/com/sap/devcamp/bookstore/services/IBookService.java) in [BookService.java](srv/src/main/java/com/sap/devcamp/bookstore/services/BookService.java)
  * note: in der Methode `getBookByAuthor` muss der Suchbegriff, für die Query, um die Wildcard '`*`' ergänzt werden 
* Implementiere die API Endpoints im [BookController.java](srv/src/main/java/com/sap/devcamp/bookstore/rest/BookController.java)
* Implementiere die GET API Endpoints im [BookUiController.java](srv/src/main/java/com/sap/devcamp/bookstore/rest/BookUiController.java)
* Starte die Spring Boot Application 
* Navigiere im Browser auf die [Swagger UI](http://localhost:8080/swagger-ui.html)
  * Betrachte die API Endpoints des book-ui-controllers
  * Betrachte die API Endpoints des book-controllers
* Teste die Endpoints des book-controllers mittels Postman und nutze die Swagger Doku zur Hilfe
* Betrachte die Endpoints des book-ui-controllers im Browser
