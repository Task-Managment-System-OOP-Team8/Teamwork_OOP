package tasks.contracts;

import java.util.ArrayList;

public interface Task {
    String getTitle();
    String getDescription();
    int getId();
    ArrayList<Commentable> getComments();
}
