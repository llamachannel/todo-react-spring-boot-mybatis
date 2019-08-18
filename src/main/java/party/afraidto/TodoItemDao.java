package party.afraidto;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;
import party.afraidto.domain.TodoItem;

/*
import org.springframework.beans.factory.annotation.Autowired;

@Component
public class TodoItemDao {
    @Autowired
    TodoItemMapper mapper;

    public int insertItem(TodoItem item) {
        System.out.println("insertItem -- about to call mapper");
        TodoItem newItem = mapper.insertItem(item);
        System.out.println("insertItem, after mapper, newItem = ");
        System.out.println(newItem);
        return newItem.getId();
    }

    public TodoItem getItem(int id) {
        return mapper.getItem(id);
    }

    public List<TodoItem> getItems() {
        return mapper.getItems();
    }
}
*/

@Component
public class TodoItemDao {

  private final SqlSession sqlSession;

  public TodoItemDao(SqlSession sqlSession) {
    this.sqlSession = sqlSession;
  }

  public List<TodoItem> getItems() {
    return this.sqlSession.selectList("getItems");
  }

  public TodoItem getItemById(long id) {
    return this.sqlSession.selectOne("getItemById", id);
  }

  public long insertItem(TodoItem item) {
      this.sqlSession.insert("insertItem", item);
      return item.getId();
  }

  public boolean completeItem(long id) {
      this.sqlSession.update("completeItem", id);
      return true;
  }

}
