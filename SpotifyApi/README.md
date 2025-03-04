# Integrating Spotify API in Spring Boot Application

## Overview
This is a Spring Boot application that consumes the Spotify API using the PKCE OAuth 2.0 Flow. It fetches data from Spotify and displays the following:

- **Top Played Tracks** (All time, Past 6 months, Past month)
- **Top Played Artists** (All time, Past 6 months, Past month)
- **Recently Played Tracks**
- **Saved Albums**
- **Saved Tracks**
- **Newest Released Tracks**
- **Featured Playlists**
- **Search Tracks/Playlist/Artists**

## Features
- OAuth 2.0 PKCE flow for secure authentication
- Spotify API integration for fetching user data
- Real-time data updates from Spotify

## Resources

* [Spotify API Docs](https://developer.spotify.com/documentation/web-api/)

  
## Technologies Used
- Spring Boot
- Spotify API
- OAuth 2.0 PKCE Flow
- Maven

# Spotify App Setup

1. Go to the [Spotify Developer Console](https://developer.spotify.com/dashboard) and create a new app.

2. Set the redirect URI to `http://localhost:8080/callback`.

3. Copy the `client-id` generated for the app and configure it along with the redirect URI in the `application.properties` file:

```
com.kiran.songsy.app.client-id=<client-id>
com.kiran.songsy.app.redirect-url=http://localhost:8080/callback
```

  ## How to Run

1. Clone the repository:
```
git clone <repo_url>
```
2. Navigate to the project folder:
```
cd <project_folder>
```
3. Build and run the Spring Boot application:
```
mvn spring-boot:run
```
4. The server will start on port 8080. You can change the port in the application.properties file if needed.
To view the application, go to:
```
http://localhost:8080
```
