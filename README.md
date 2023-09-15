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

### 13. Templating

- Templating is used to generate dynamic content
- Freemaker, Velocity, Mustache, Thymeleaf

### 14. Auto Reloading


--- 

## Section 3 : Building a Ktor Server for the Backend

### 15. Setting up the project

### 16. Install Plugins

### 17. Create Model Classes

### 18. Create Repository

### 19. Create Root Endpoint

### 20. Create Custom Endpoints Part 1

### 21. Create Custom Endpoints Part 2   

### 22. Create Search endpoint

### 23. Create Status Pages