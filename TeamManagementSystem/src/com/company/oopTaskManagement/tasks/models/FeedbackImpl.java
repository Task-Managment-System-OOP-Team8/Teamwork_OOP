package com.company.oopTaskManagement.tasks.models;

import com.company.oopTaskManagement.tasks.contracts.Feedback;
import com.company.oopTaskManagement.tasks.models.enums.FeedbackEnums;
import com.company.oopTaskManagement.tasks.Comment;

import java.util.ArrayList;

public class  FeedbackImpl extends TaskImpl implements Feedback {


    private int rating;
    private FeedbackEnums status;

    public FeedbackImpl(String title, String description, int rating) {
        super(title,description);
       setRating(rating);
        this.status= FeedbackEnums.NEW;

    }

    public ArrayList<Comment> getComments() {
        return new ArrayList<>();
    }

    @Override
    public int getRating() {
        return rating;
    }

    @Override
    public FeedbackEnums getStatus() {
        return status;
    }

    //TODO

    public String getAuthor() {
        return null;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public String getAsString() {
        return null;
    }

    @Override
    public ArrayList<Comment> getComment() {
        return null;
    }
    private void setRating(int rating) {
        this.rating = rating;
    }
}
