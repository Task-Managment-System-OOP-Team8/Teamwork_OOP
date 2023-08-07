package tasks.contracts;

import tasks.models.enums.FeedbackEnums;

public interface Feedback {

    int getRating();
    FeedbackEnums getStatus();

}
