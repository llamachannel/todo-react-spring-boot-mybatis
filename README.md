# Todo app built in spring boot + react 

## Overview

WIP

 - Rest api works, talks to MySQL database
 - react hits the rest API
 - can add, remove items, and toggled completedness

TODO:
 - add option for toggling display of completed items
 - edit todo items


### File structure

```
├── package.json
├── pom.xml
├── src
│   ├── main
│   │   ├── java
│   │   │   └── party
│   │   │       └── afraidto
│   │   │           ├── App.java
│   │   │           ├── domain
│   │   │           │   └── TodoItem.java
│   │   │           ├── TodoItemDao.java
│   │   │           └── TodoRestController.java
│   │   ├── js
│   │   │   └── app.js
│   │   └── resources
│   │       ├── application.properties
│   │       ├── mybatis-config.xml
│   │       ├── party
│   │       │   └── afraidto
│   │       │       └── TodoItemMapper.xml
│   │       ├── static
│   │       │   └── main.css
│   │       └─ templates
│   │           └── index.html
└── webpack.config.js
```

## Building and running

To compile the Spring Boot REST API, run:

```
mvn clean compile
```

To compile the React app (i.e. to run webpack on it) and then launch a local web server, run:

```
mvn spring-boot:run
```
