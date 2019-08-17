package party.afraidto.domain;

import java.io.Serializable;

public class TodoItem implements Serializable {

    private static final long serialVersionUID = 1L;
    private Long id;
    private String text;
    private boolean isCompleted;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public void setIsCompleted(boolean isCompleted) {
        this.isCompleted = isCompleted;
    }

    @Override
    public String toString() {
        return getId() + "," + getText() + "," + getIsCompleted();
    }


    /*
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
    */
}
