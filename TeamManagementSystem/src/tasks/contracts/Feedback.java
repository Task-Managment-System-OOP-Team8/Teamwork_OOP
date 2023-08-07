package tasks.contracts;

import tasks.models.enums.FeedbackStatusEnums;

public interface Feedback {

    int getRating();
    FeedbackStatusEnums getStatus();

}
