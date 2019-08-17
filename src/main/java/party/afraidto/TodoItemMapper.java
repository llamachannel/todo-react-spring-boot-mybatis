package party.afraidto;

import java.util.List;
import org.apache.ibatis.annotations.*;

@Mapper
public interface TodoItemMapper {
    @Insert("insert into todo (id, text, isCompleted) values (null, #{text}, #{isCompleted})")
    @Options(useGeneratedKeys=true, keyProperty="id")
    public int insertItem(TodoItem todo);

    @Select("SELECT id, text, isCompleted FROM todo")
    List<TodoItem> getItems();

    @Select("SELECT id, text, isCompleted FROM todo WHERE id = #{id}")
    @Results(value = {
      @Result(property = "id", column = "id"),
      @Result(property="text", column = "text"),
      @Result(property="isCompleted", column = "isCompleted")
    })
    TodoItem getItem(int id);

    @Delete("delete from todo where id=#{id}")
	public void deleteTodoItemById(Integer id);
}
