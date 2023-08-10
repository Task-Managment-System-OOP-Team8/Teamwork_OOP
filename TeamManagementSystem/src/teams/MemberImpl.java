package teams;

import Utils.ValidationHelpers;
import tasks.Comment;
import tasks.contracts.Task;
import teams.contracts.Member;

import java.util.ArrayList;

public class MemberImpl implements Member {
    public static final int MEMBER_NAME_MAX_LENGTH = 15;
    public static final int MEMBER_NAME_MIN_LENGTH = 5;
    public static final String INVALID_MEMBER_NAME = String.format(
            "Member name must be between %d and %d symbols", MEMBER_NAME_MIN_LENGTH, MEMBER_NAME_MAX_LENGTH);
    private String name;
    private ArrayList<Task> tasks;
    private ArrayList<String> history;

    public MemberImpl(String name) {
        setName(name);
        this.tasks = new ArrayList<>();
        this.history = new ArrayList<>();
    }

    private void setName(String name) {
        ValidationHelpers.ValidateIntRange(
                name.length(), MEMBER_NAME_MIN_LENGTH, MEMBER_NAME_MAX_LENGTH, INVALID_MEMBER_NAME);
        this.name = name;
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
    public ArrayList<String> getHistory() {
        return  new ArrayList<>(history);
    }

    @Override
    public void addTask(Task task) {
        tasks.add(task);

    }

    @Override
    public void removeTask(Task task) {
    tasks.remove(task);
    }
//TODO
    @Override
    public void addCommentToTask(Task taskToAddComment, Comment commentToAdd) {

    }

    @Override
    public void removeCommentToTask(Task taskToRemoveComment,Comment commentToRemove) {

    }

}

