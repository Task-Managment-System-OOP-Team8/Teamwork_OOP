package com.company.oopTaskManagement.tasks.models;

import com.company.oopTaskManagement.tasks.models.enums.FeedbackEnums;


public class FeedbackImpl extends TaskImpl implements com.company.oopTaskManagement.tasks.contracts.Feedback {


    private int rating;
    private FeedbackEnums status;

    public FeedbackImpl(String title, String description, int rating) {
        super(title,description);
       setRating(rating);
        this.status= FeedbackEnums.NEW;
    }
    @Override
    public int getRating() {
        return rating;
    }

    @Override
    public FeedbackEnums getStatus() {
        return status;
    }


//todo- print method
    @Override
    public String getAsString() {
        return null;
    }


    private void setRating(int rating) {
        this.rating = rating;
    }
}
