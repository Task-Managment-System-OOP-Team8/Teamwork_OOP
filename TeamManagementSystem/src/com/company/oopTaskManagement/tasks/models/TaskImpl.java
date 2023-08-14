package com.company.oopTaskManagement.tasks.models;

import com.company.oopTaskManagement.Utils.ValidationHelpers;
import com.company.oopTaskManagement.tasks.Comment;
import com.company.oopTaskManagement.tasks.History;
import com.company.oopTaskManagement.tasks.contracts.Task;

import java.util.ArrayList;

public abstract class TaskImpl implements Task {
    private static final int TITLE_MIN_LENGTH = 10;
    private static final int TITLE_MAX_LENGTH = 50;
    private static final String INVALID_TITLE = String.format(
            "Title must be between %d and %d symbols", TITLE_MIN_LENGTH, TITLE_MAX_LENGTH);
    private static final int DESCRIPTION_MIN_LENGTH = 10;
    private static final int DESCRIPTION_MAX_LENGTH = 500;
    private static final String INVALID_DESCRIPTION = String.format(
            "Description must be between %d and %d symbols", DESCRIPTION_MIN_LENGTH, DESCRIPTION_MAX_LENGTH);
    protected String title;
    private final int id;
    public static int totalId = 1;

    protected String description;
    protected ArrayList<Comment> comments;
    protected ArrayList<History> history;


    public TaskImpl(String title, String description) {
        this.id = totalId;
        totalId++;
        setTitle(title);
        setDescription(description);
        this.comments = new ArrayList<>();
        this.history = new ArrayList<>();

    }

    private void setTitle(String title) {
        ValidationHelpers.ValidateIntRange(title.length(), TITLE_MIN_LENGTH, TITLE_MAX_LENGTH, INVALID_TITLE);
        this.title = title;
    }


    public void setDescription(String description) {
        ValidationHelpers.ValidateIntRange(description.length(), DESCRIPTION_MIN_LENGTH, DESCRIPTION_MAX_LENGTH, INVALID_DESCRIPTION);
        this.description = description;
    }
/*
public String getAuthor(){
        this.author;

    }*/


    public void addComment(String author, String message) {
        comments.add(new Comment(author, message));
    }

    public void addHistory(String input) {
        history.add(new History(input));
    }

    @Override
    public abstract String getTitle();

    @Override
    public abstract String getDescription();

    @Override
    public int getId() {
        return this.id;
    }

    public void displayHistory() {
        for (History log : history) {
            System.out.println(log.viewInfo());
        }
    }

    @Override
    public String toString() {
        return String.format("Task id: %s%nTask title: %s%nTask description: %s%n ", id, title, description);

    }
}