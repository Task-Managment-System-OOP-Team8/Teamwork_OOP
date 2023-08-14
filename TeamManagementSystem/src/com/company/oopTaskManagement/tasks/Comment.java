package com.company.oopTaskManagement.tasks;

import com.company.oopTaskManagement.tasks.contracts.Commentable;

import java.util.ArrayList;
//TODO
public class Comment implements Commentable {

private String comments;
private String author;


    public Comment(String author, String comments) {
        setAuthor(author);
       setComments(comments);
    }

    @Override
    public ArrayList<Comment> getComments() {
        return new ArrayList<>();
    }

    @Override
    public String getAuthor() {
        return author;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    private void setAuthor(String author) {
        this.author = author;
    }
}
