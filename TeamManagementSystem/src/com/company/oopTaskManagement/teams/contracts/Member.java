package com.company.oopTaskManagement.teams.contracts;

import com.company.oopTaskManagement.tasks.Comment;
import com.company.oopTaskManagement.tasks.contracts.Task;

import java.util.ArrayList;

public interface Member {
    String getName();
    ArrayList<Task> getTasks();

    ArrayList<String> getHistory();

     void addTask(Task task);
     void removeTask(Task task);

     void addCommentToTask(Task taskToAddComment, Comment commentToAdd);

     void removeCommentToTask(Task taskToRemoveComment,Comment commentToRemove);
     void addActivity(String activity);
}
