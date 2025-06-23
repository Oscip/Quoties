# Quoties-App

Die Quoties-App ist eine Webanwendung, die es Benutzern ermöglicht, zufällige Wörter mit Definitionen zu erhalten und Zitate anzuzeigen, die zu diesen Wörtern passen oder sie enthalten. Die App besteht aus einem **Next.js-Frontend** und einem **Spring Boot-Backend**.

## Projektinformationen

- **Autor:innen:** Oscar Peach, Mike Zogheib, Fabian Beck  
- **Schule:** Berufsbildungsschule Winterthur (BBW)  
- **Zeitraum:** 15.04.2025 – 24.06.2025

## Zusammenfassende Erklärung 

Die Quoties-App ist eine innovative Webanwendung, die es Benutzern ermöglicht, zufällige Wörter zu entdecken und Zitate zu finden, die diese Wörter enthalten oder thematisch dazu passen. Die App nutzt eine öffentliche API, um ein zufälliges Wort mit seiner Definition abzurufen und bietet eine benutzerfreundliche Oberfläche, um Zitate zu suchen und anzuzeigen. Das Frontend ist in Next.js (React) entwickelt, während das Backend auf Spring Boot basiert, um RESTful APIs bereitzustellen.


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

1. **GET /api/word/random**
    - Beschreibung: Gibt ein zufälliges Wort zusammen mit seiner Definition zurück.
    - Antwort:
      ```json
      {
        "word": "inspiration",
        "definition": "the process of being mentally stimulated to do or feel something, especially to do something creative."
      }
      ```

2. **GET /api/word/{nummer}**
    - Beschreibung: Gibt ein zufälliges Wort mit der Nummer zurück, die in der URL angegeben ist.
    - Antwort:
      ```json
      {
        "word": "flying",
        "definition": "the action of moving through the air by means of wings or an aircraft."
      }
      {
        "word": "studying",
        "definition": "the devotion of time and attention to acquiring knowledge on a subject, especially by reading."
      }
      ```

3. **GET /api/quotes/new**
    - Beschreibung: Gibt ein Zufallszitat zurück, das das zufällige Wort enthält, von dennen beide von Englisch auf Deutsch auch übersetzt zurückgegeben werden.
    - Antwort:
      ```json
      [
         {
            "quote": "\"We don't need new taxes. We need new taxpayers, people that are gainfully employed, making money and paying into the tax system. And then we need a government that has the discipline to take that additional revenue and use it to pay down the debt and never grow it again.\" — Marco Rubio",
            "quoteTranslated": "„Wir brauchen keine neuen Steuern. Wir brauchen neue Steuerzahler, Menschen, die erwerbstätig sind, Geld verdienen und in das Steuersystem einzahlen. Und dann brauchen wir eine Regierung, die die Disziplin hat, diese zusätzlichen Einnahmen zu nehmen und sie zu verwenden, um die Schulden zu begleichen und sie nie wieder wachsen zu lassen.\" — Marco Rubio",
            "word": "gainfully",
            "wordTranslated": "gewinnbringend",
            "definition": "In a gainful manner; profitably.",
            "definitionTranslated": "Gewinnbringend."
         }
      ]
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

## 📊 Persönliche Auswertung (Reflexion)
Die Arbeit an der Quoties-App hat uns nicht nur technisches Wissen vermittelt, sondern auch unsere Fähigkeiten in Projektorganisation, Versionskontrolle mit Git, Teamarbeit und Dokumentation verbessert. Wir haben gelernt, wie man moderne Webarchitekturen entwirft und wie wichtig saubere Schnittstellen und strukturierter Code sind.

### Besonders stolz sind wir auf:

Die reibungslose Kommunikation zwischen Frontend und Backend

Das benutzerfreundliche Design und die intuitive UI

Die stabile Integration externer APIs