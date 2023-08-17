package com.company.oopTaskManagement.tasks.contracts;

import com.company.oopTaskManagement.tasks.History;

import java.util.List;

public interface Task extends  Printable,Commentable {
    String getTitle();
    String getDescription();
    int getId();

    List<History> getHistory();

    void addComment(Comment comment);

    void addHistory(String history);

//comments? history?
}
