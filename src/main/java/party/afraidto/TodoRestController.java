package party.afraidto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/todo")
public class TodoRestController {
    @Autowired
    TodoItemDao dao;

    @RequestMapping(method = RequestMethod.GET)
    public String getAllItems() {
        return "TODO: all items";
    }

    @RequestMapping(method = RequestMethod.GET, path = "/getItem")
    public TodoItem getItem(@RequestParam int id) {
        return dao.getItem(id);
    }
}
