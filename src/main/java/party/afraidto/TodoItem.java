package party.afraidto;

public class TodoItem {
    private Integer id;
    private String text;
    private boolean isCompleted;

    public TodoItem() { }

    public TodoItem(String text, boolean isCompleted) {
        this.text = text;
        this.isCompleted = isCompleted;
    }

    public TodoItem(Integer id, String text, boolean isCompleted) {
        this.id = id;
        this.text = text;
        this.isCompleted = isCompleted;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getText() {
        return this.text;
    }

    public boolean getIsCompleted() {
        return this.isCompleted;
    }
}
