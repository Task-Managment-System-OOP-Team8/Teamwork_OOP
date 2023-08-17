package com.company.oopTaskManagement.teams.contracts;

import com.company.oopTaskManagement.tasks.CommentImpl;
import com.company.oopTaskManagement.tasks.History;
import com.company.oopTaskManagement.tasks.contracts.Task;

import java.util.ArrayList;

public interface Member {
    String getName();
    ArrayList<Task> getTasks();

//todo-не е ли по-добре да взимаме листа от класа ?
    ArrayList<History> getHistory();

     void addTask(Task task);
     void removeTask(Task task);

     void addCommentToTask(Task taskToAddComment, CommentImpl commentToAdd);

     void removeCommentToTask(Task taskToRemoveComment, CommentImpl commentToRemove);


   //  void addActivity(String activity);
}
