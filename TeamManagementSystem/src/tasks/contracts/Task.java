package tasks.contracts;

import java.util.ArrayList;

public interface Task extends Commentable {
    String getTitle();
    String getDescription();
    int getId();


}
