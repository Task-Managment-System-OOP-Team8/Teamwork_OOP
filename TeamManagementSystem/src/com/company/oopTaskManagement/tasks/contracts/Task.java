package com.company.oopTaskManagement.tasks.contracts;

public interface Task extends  Printable,Commentable {
    String getTitle();
    String getDescription();
    int getId();
    void addComment(Comment comment);


//comments? history?
}
