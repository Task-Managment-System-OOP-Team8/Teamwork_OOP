package teams;

import Utils.ValidationHelpers;
import tasks.contracts.Task;
import teams.contracts.Trackable;
import java.util.ArrayList;

public class Board implements Trackable {
    public static final int BOARD_NAME_MAX_LENGTH = 10;
    public static final int BOARD_NAME_MIN_LENGTH = 5;
    public static final String INVALID_BOARD_NAME = String.format(
            "Board name must be between %d and %d symbols", BOARD_NAME_MIN_LENGTH, BOARD_NAME_MAX_LENGTH);
    private String name;
    private ArrayList<Task> tasks;
    private ArrayList<String> history;

    public Board(String name) {
        this.name = name;
        tasks = new ArrayList<>();
        history = new ArrayList<>();
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

    private void setName(String name) {
        ValidationHelpers.ValidateIntRange(
                name.length(), BOARD_NAME_MIN_LENGTH, BOARD_NAME_MAX_LENGTH, INVALID_BOARD_NAME);
        this.name = name;
    }
}