package party.afraidto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class App {
    private final TodoItemDao todoItemDao;

    public static void main( String[] args ) {
        SpringApplication.run(App.class, args);
    }

    public App(TodoItemDao todoItemDao) {
        this.todoItemDao = todoItemDao;
    }
}
