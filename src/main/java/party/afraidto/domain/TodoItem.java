package party.afraidto.domain;

public class TodoItem {
    private int id;
    private String text;
    private boolean isCompleted;

    public TodoItem() { }

    public TodoItem(String text, boolean isCompleted) {
        this.text = text;
        this.isCompleted = isCompleted;
    }

    public TodoItem(int id, String text, boolean isCompleted) {
        this.id = id;
        this.text = text;
        this.isCompleted = isCompleted;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return this.text;
    }

    public boolean getIsCompleted() {
        return this.isCompleted;
    }
}
