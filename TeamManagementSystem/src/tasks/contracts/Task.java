package tasks.contracts;

import tasks.models.enums.FeedbackEnums;

public interface Task extends  Printable {
    String getTitle();
    String getDescription();
    int getId();


//comments? history?
}
