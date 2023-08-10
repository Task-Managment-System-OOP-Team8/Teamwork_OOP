package teams.contracts;

import tasks.Comment;
import tasks.contracts.Task;
import java.util.ArrayList;

public interface Member {
    String getName();
    ArrayList<Task> getTasks();

    ArrayList<String> getHistory();

     void addTask(Task task);
     void removeTask(Task task);

     void addCommentToTask(Task taskToAddComment, Comment commentToAdd);

     void removeCommentToTask(Task taskToRemoveComment,Comment commentToRemove);
}
