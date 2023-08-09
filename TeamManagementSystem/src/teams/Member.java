package teams;

import Utils.ValidationHelpers;
import tasks.contracts.Task;
import teams.contracts.Trackable;
import java.util.ArrayList;

public class Member implements Trackable {
    public static final int MEMBER_NAME_MAX_LENGTH = 15;
    public static final int MEMBER_NAME_MIN_LENGTH = 5;
    public static final String INVALID_MEMBER_NAME = String.format(
            "Member name must be between %d and %d symbols",MEMBER_NAME_MIN_LENGTH,MEMBER_NAME_MAX_LENGTH);
    private String name;
    private ArrayList<Task> tasks;
    private ArrayList<String> history;

    public Member(String name) {
        this.name = name;
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
    //TODO
    @Override
    public ArrayList<Task> getTasks() {
        return null;
    }
    //TODO
    @Override
    public ArrayList<String> getHistory() {
        return null;
    }

    public void addTasks(Task task) {
        tasks.add(task);
    }

    public void addActivity(String activity) {
        history.add(activity);
    }
}
