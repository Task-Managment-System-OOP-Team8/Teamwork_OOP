package com.company.oopTaskManagement.tasks.contracts;

import com.company.oopTaskManagement.tasks.models.enums.FeedbackEnums;

public interface Feedback extends Task{

    int getRating();

    FeedbackEnums getStatus();

}
