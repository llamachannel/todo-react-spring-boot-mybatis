package party.afraidto;

import org.apache.ibatis.annotations.*;

@Mapper
public interface TodoItemMapper {
    @Insert("insert into todo (text, isCompleted) values (#{text}, #{isCompleted})")
    public int insertItem(TodoItem todo);

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
