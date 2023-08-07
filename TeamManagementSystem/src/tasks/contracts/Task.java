package tasks.contracts;

import java.util.ArrayList;

public interface Task extends Commentable,Assignable {
    String getTitle();
    String getDescription();
    int getId();


}
