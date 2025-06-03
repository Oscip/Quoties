# Quoties-App

Die Quoties-App ist eine Webanwendung, die es Benutzern ermöglicht, zufällige Wörter mit Definitionen zu erhalten und Zitate anzuzeigen, die zu diesen Wörtern passen oder sie enthalten. Die App besteht aus einem **Next.js-Frontend** und einem **Spring Boot-Backend**.

## Features

- **Zufälliges Wort:** Die App ruft ein zufälliges Wort aus einer öffentlichen API ab, zusammen mit der Definition des Wortes.
- **Zitate suchen:** Basierend auf dem zufälligen Wort werden Zitate angezeigt, die das Wort enthalten oder thematisch dazu passen.
- **Wort suchen:** Ein Wort in der Suchleiste eingeben und passende Zitate angezeigt bekommen.
- **Backend-Integration:** Das Backend ist mit Spring Boot entwickelt und bietet REST-APIs, um das zufällige Wort und passende Zitate abzurufen.

## Architektur

- **Frontend:** Next.js (React)
- **Backend:** Spring Boot (Java)
- **Datenbank:** In diesem Beispiel werden keine Datenbankoperationen benötigt, aber es könnte eine Datenbank verwendet werden, um Zitate zu speichern.

## Installation und Setup

### Voraussetzungen

- Node.js (für das Frontend)
- Java (JDK 17 oder höher)
- Maven (für das Backend)

### Frontend (Next.js)

1. **Klonen des Repositories:**

   ```bash
   git clone https://github.com/Oscip/Quoties.git
   cd Quoties/quoties-fe
   ```

2. **Abhängigkeiten installieren:**

   ```bash
   npm install
   ```

3. **Entwicklungsserver starten:**

   ```bash
   npm run dev
   ```

   Das Frontend wird unter [http://localhost:3000](http://localhost:3000) verfügbar sein.


### Backend (Spring Boot)

1. **Klonen des Repositories:**

   ```bash
   git clone https://github.com/Oscip/Quoties.git
   cd Quoties/quoties-be
   ```

2. **Abhängigkeiten installieren**

   ```bash
   mvn clean install
   ```

3. **Spring Boot-Server starten:**

   ```bash
   mvn spring-boot:run
   ```

   Das Backend wird unter [http://localhost:8080](http://localhost:8080) verfügbar sein.

### APIs

Das Backend integriert eine öffentliche API, um ein zufälliges Wort zu bekommen und Zitate zu suchen, die dieses Wort enthalten.

#### Endpunkte (Backend API)

1. **GET /api/word**
    - Beschreibung: Gibt ein zufälliges Wort zusammen mit seiner Definition zurück.
    - Antwort:
      ```json
      {
        "word": "inspiration",
        "definition": "the process of being mentally stimulated to do or feel something, especially to do something creative."
      }
      ```

2. **GET /api/quotes**
    - Beschreibung: Gibt eine Liste von Zitaten zurück, die das zufällige Wort enthalten oder zu diesem Thema passen.
    - Antwort:
      ```json
      [
        {
          "quote": "The only way to do great work is to love what you do.",
          "author": "Steve Jobs"
        },
        {
          "quote": "Inspiration exists, but it has to find you working.",
          "author": "Pablo Picasso"
        }
      ]
      ```
      - Beschreibung: Gibt ein zufälliges Wort zusammen mit seiner Definition zurück.
      - Antwort:
        ```json
        {
          "word": "inspiration",
          "definition": "the process of being mentally stimulated to do or feel something, especially to do something creative."
        }
        ```

### Testen

Die Applikation wird mit JUnit im Backend getestet und die API-Calls an sich mit Postman.

### Produktion

1. **Frontend für Produktion bauen:**

   ```bash
   npm run build
   npm run start
   ```

2. **Spring Boot für Produktion bauen:**

   ```bash
   mvn clean package
   java -jar target/quoties-app.jar
   ```

3. **Frontend kann dann auf Vercel deployt werden.**

## Technologien

- **Frontend:**
    - Next.js
    - React
    - Fetch (für API-Anfragen)

- **Backend:**
    - Spring Boot
    - Java 17+
    - Spring Data JPA (optional)
    - Integration mit einer öffentlichen API für zufällige Wörter