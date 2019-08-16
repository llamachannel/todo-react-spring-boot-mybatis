package party.afraidto;

public class TodoItem {
    private Integer id;
    private String text;
    private boolean isCompleted;

    public TodoItem(Integer id, String text, boolean isCompleted) {
        this.id = id;
        this.text = text;
        this.isCompleted = isCompleted;
    }

    public String getText() {
        return this.text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean getIsCompleted() {
        return this.isCompleted;
    }
}
