package tasks.contracts;

import tasks.models.enums.FeedbackEnums;

public interface Feedback extends Task{

    int getRating();

    FeedbackEnums getStatus();

}
