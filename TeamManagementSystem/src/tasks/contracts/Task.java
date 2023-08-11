package tasks.contracts;

import tasks.models.enums.FeedbackEnums;

public interface Task extends Commentable, Printable {
    String getTitle();
    String getDescription();
    int getId();


//comments? history?
}
