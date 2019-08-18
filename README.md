# Todo app built in spring boot + react 

WIP

 - Rest api is database-backed.
 - react displays results of call to rest API

TODO:
 - add new items
 - remove items
 - mark existing items as completed
 - hide completed items
 - add option for toggling display of completed items

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
│   │       ├── templates
│   │       │   └── index.html
└── webpack.config.js
```
