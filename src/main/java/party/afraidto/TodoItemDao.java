package party.afraidto;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;
import party.afraidto.domain.TodoItem;

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

  public boolean deleteItemById(long id) {
    return this.sqlSession.delete("deleteItemById", id) > 0;
  }

  public long insertItem(TodoItem item) {
      this.sqlSession.insert("insertItem", item);
      return item.getId();
  }

  public boolean completeItem(long id) {
      this.sqlSession.update("completeItem", id);
      return true;
  }

  public boolean uncompleteItem(long id) {
      this.sqlSession.update("uncompleteItem", id);
      return false;
  }

}
