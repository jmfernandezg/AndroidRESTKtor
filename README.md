# AndroidRESTKtor
Training for Android App with REST API and Ktor Server

- URL: https://udemy.com/course/build-modern-android-app-with-rest-api-and-ktor-server


## Section 1 : Introduction

### 1.1 Introduction

- Ktor is a framework for building asynchronous servers and clients in connected systems using the powerful Kotlin programming language.
- Ktor is built from the ground up using coroutines.
- For Android we will use JetPack Compose
- We will use retrofit and paging library

### 2: Repository and resources 

- Two Projects: Backend server and android application

---

## Section 2 : Ktor Server

### 3.1 Ktor Server Introduction
- Ktor supports plugins for features such as authentication, templating, WebSockets, and more.
- Plugin for serialization
- Plugin for Authentication
- Plugin for Routing

### 4: IntelliJ IDEA

- For Ktor, we will use Idea Ultimate
- For Android, we will use Android Studio
 

### 5: Create Ktor Project

- We will use Gradle and Kotlin / JVM with Kotlin DSL support
- Dependencies
  - ktor-server-core
  - ktor-server-netty
  - logback classic

#### 5.1: Create Ktor Project
- Main class `io.ktor.server.netty.EngineMain.main(args)`
- Configuration `application.conf` file

### 6. Ktor Project Generator

https://start.ktor.io

### 7 Settings and Configuration

- Supported engines: Jetty and Netty
- EngineMain: configuration in application.conf
- embeddedServer: configuration in code
  - Gradle script main class should be Application
- HOCON: Human-Optimized Config Object Notation

### 8: Modules

- Modules are used to group routes and features

### 9. Plugins

- Plugins are used to add features to the application

### 10. Postman

- Postman is a tool for testing REST APIs
 

### 11. Requests / responses
- Parameters: `call.parameters["username"]`
- Headers: `call.headers["Connection"]`
- Send headers: `call.response.header("Content-Type", "application/json")`
- Content Negotiation Plugin: Serialization and deserialization
- Redirect: `call.responseRedirect`

### 12. Static content

- Static content are certain files that don't change
- Static content is served from the `resources` folder
- Add dependency ktor-html-builder

### 13. Templating

- Templating is used to generate dynamic content
- Freemaker, Velocity, Mustache, Thymeleaf
- Add dependency io.ktor:ktor-server-html-builder

### 14. Auto Reloading

- Set developmentMode = true in application.conf
- Set watchPaths = listOf("classes", "resources")

--- 

## Section 3 : Building a Ktor Server for the Backend

### 15. Setting up the project

- The server will provide a new character name from various sources
- Project can be generated from IDEA or from https://start.ktor.io
- Common plugins: Serialization, Content Negotiation, Routing
- Uses koin for dependency injection

### 16. Install Plugins
- Koin: should be the first module configured
- Modules
- Serialization
- Routing
- DefaultHeaders

### 17. Create Model Classes

- In this project we'll create a movie Character model class
- We'll use the `@Serializable` annotation
- Well use a ApiResult class to wrap the result 

### 18. Create Repository

- The repository will provide the data for the server
- We'll use a `List` to store the data
- New package is repository

### 19. Create Root Endpoint

- Create a root endpoint

### 20. Create Custom Endpoints Part 1

- `require` page 1 to a max of 10


### 21. Create Custom Endpoints Part 2   
- Create a custom endpoint to get all characters

### 22. Create Search endpoint
- Create a custom endpoint to a list of characters that maches a search term

### 23. Create Status Pages

- Requires dependency io.ktor:ktor-server-status-pages
