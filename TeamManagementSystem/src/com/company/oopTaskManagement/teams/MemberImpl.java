package com.company.oopTaskManagement.teams;

import com.company.oopTaskManagement.Utils.ValidationHelpers;
import com.company.oopTaskManagement.tasks.CommentImpl;
import com.company.oopTaskManagement.tasks.History;
import com.company.oopTaskManagement.tasks.contracts.Task;
import com.company.oopTaskManagement.teams.contracts.Member;

import java.util.ArrayList;

public class MemberImpl implements Member {
    public static final int MEMBER_NAME_MAX_LENGTH = 15;
    public static final int MEMBER_NAME_MIN_LENGTH = 5;
    public static final String INVALID_MEMBER_NAME = String.format(
            "Member name must be between %d and %d symbols",MEMBER_NAME_MIN_LENGTH,MEMBER_NAME_MAX_LENGTH);
    private String name;
    private ArrayList<Task> tasks;
    private ArrayList<History> history;

    public MemberImpl(String name) {
        setName(name);
        this.tasks = new ArrayList<>();
        this.history = new ArrayList<>();
    }
    @Override
    public String getName() {
        return name;
    }

    @Override
    public ArrayList<Task> getTasks() {
        return new ArrayList<>(tasks);
    }
    //TODO
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
//todo - нещо не е ок с кастване
    @Override
    public void addCommentToTask(Task taskToAddComment, CommentImpl commentToAdd) {
        taskToAddComment.addComment(commentToAdd);

    }

    @Override
    public void removeCommentToTask(Task taskToRemoveComment, CommentImpl commentToRemove) {
        if (!taskToRemoveComment.getComment().contains(commentToRemove)){
            throw new IllegalArgumentException("Task doesn't contain that comment");
        }


    }
    //TODO
    @Override
    public void addActivity(String activity) {
        history.add(new History(activity));
    }

    @Override
    public void getHistory(String format) {

    }

    @Override
    public String toString() {
        return String.format("Member name: %s", getName());
    }

    private void setName(String name) {
        ValidationHelpers.ValidateIntRange(
                name.length(), MEMBER_NAME_MIN_LENGTH, MEMBER_NAME_MAX_LENGTH, INVALID_MEMBER_NAME);
        this.name = name;
    }
}


