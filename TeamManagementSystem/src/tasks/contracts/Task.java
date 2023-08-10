package tasks.contracts;

import tasks.models.enums.FeedbackEnums;

public interface Task extends Commentable {
    String getTitle();
    String getDescription();
    int getId();


//comments? history?
}
