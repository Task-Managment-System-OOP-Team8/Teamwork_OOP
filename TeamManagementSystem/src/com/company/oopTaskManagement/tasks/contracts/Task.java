package com.company.oopTaskManagement.tasks.contracts;

public interface Task extends  Printable,Commentable {
    String getTitle();
    String getDescription();
    int getId();



//comments? history?
}
