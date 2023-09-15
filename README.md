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