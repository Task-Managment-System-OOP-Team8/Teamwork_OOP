package teams.contracts;

import tasks.contracts.Task;

import java.util.ArrayList;

public interface Trackable {
    String getName();
    ArrayList<Task> getTask();

    ArrayList<String> getHistory();

}
