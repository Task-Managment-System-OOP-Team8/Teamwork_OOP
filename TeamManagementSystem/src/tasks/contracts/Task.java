package tasks.contracts;

import tasks.models.enums.StatusEnums;

public interface Task extends Commentable {
    String getTitle();
    String getDescription();
    int getId();

    StatusEnums getStatus();


}
