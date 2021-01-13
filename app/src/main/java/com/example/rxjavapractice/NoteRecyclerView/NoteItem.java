package com.example.rxjavapractice.NoteRecyclerView;

public class NoteItem {
    private String priority;
    private String title;
    private String description;

    public NoteItem(String priority, String title, String description) {
        this.priority = priority;
        this.title = title;
        this.description = description;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
