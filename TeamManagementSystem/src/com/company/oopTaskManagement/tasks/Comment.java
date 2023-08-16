package com.company.oopTaskManagement.tasks;

//TODO
public class Comment  {

private String comments;
private final String author;


    public Comment(String author, String comments) {
        this.author=author;
       setComments(comments);
    }

    public String getAuthor() {
        return author;
    }


    public void setComments(String comments) {
        this.comments = comments;
    }

}
