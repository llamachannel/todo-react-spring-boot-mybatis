package party.afraidto;

public class TodoItem {
    private Integer id;
    private String text;
    private boolean isCompleted;

    public TodoItem() { }

    public TodoItem(Integer id, String text, boolean isCompleted) {
        this.id = id;
        this.text = text;
        this.isCompleted = isCompleted;
    }

    public Integer getId() {
        return this.id;
    }

    public String getText() {
        return this.text;
    }

    public boolean getIsCompleted() {
        return this.isCompleted;
    }
}
