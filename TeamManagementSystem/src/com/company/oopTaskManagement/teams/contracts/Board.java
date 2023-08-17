package com.company.oopTaskManagement.teams.contracts;

import com.company.oopTaskManagement.tasks.History;
import com.company.oopTaskManagement.tasks.contracts.Task;

import java.util.ArrayList;

public interface Board {
    String getName();
    ArrayList<Task> getTasks();

    ArrayList<History> getHistory();

    void addTask(Task task);

    void removeTask(Task task);

    void addActivity(History activity);


}
