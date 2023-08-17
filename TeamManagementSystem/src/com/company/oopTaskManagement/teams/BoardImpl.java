package com.company.oopTaskManagement.teams;

import com.company.oopTaskManagement.Utils.ValidationHelpers;
import com.company.oopTaskManagement.tasks.History;
import com.company.oopTaskManagement.tasks.contracts.Task;
import com.company.oopTaskManagement.teams.contracts.Board;

import java.util.ArrayList;

public class BoardImpl implements Board {
    public static final int BOARD_NAME_MAX_LENGTH = 10;
    public static final int BOARD_NAME_MIN_LENGTH = 5;
    public static final String INVALID_BOARD_NAME = String.format(
            "Board name must be between %d and %d symbols", BOARD_NAME_MIN_LENGTH, BOARD_NAME_MAX_LENGTH);
    private String name;
    private ArrayList<Task> tasks;
    private ArrayList<History> history;

    public BoardImpl(String name) {
        setName(name);
        tasks = new ArrayList<>();
        history = new ArrayList<>();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public ArrayList<Task> getTasks() {
        return new ArrayList<>(tasks);
    }

    @Override
    public ArrayList<History> getHistory() {
        return new ArrayList<>(history);
    }

    @Override
    public void addTask(Task task) {
        tasks.add(task);
    }

    @Override
    public void removeTask(Task task) {
        tasks.remove(task);
    }

    @Override
    public void addActivity(History activity) {
        history.add(activity);
    }

    private void setName(String name) {
        ValidationHelpers.ValidateIntRange(
                name.length(), BOARD_NAME_MIN_LENGTH, BOARD_NAME_MAX_LENGTH, INVALID_BOARD_NAME);
        this.name = name;
    }

@Override
    public String toString(){
        return String.format("Board name: %s\n",getName());
}
}