package tasks.models;

import Utils.ValidationHelpers;
import tasks.Comment;
import tasks.contracts.Feedback;
import tasks.models.enums.FeedbackStatusEnums;
import teams.Member;

import java.util.ArrayList;

public class FeedbackImpl extends TaskImpl implements Feedback {

    public static final int DESCRIPTION_MAX_LENGTH = 500;
    public static final int DESCRIPTION_MIN_LENGTH = 10;
    public static final String INVALID_DESCRIPTION_LENGTH = String.format(
            "Description must be between %d and %d symbols", DESCRIPTION_MIN_LENGTH, DESCRIPTION_MAX_LENGTH);
    public static final int TITLE_MAX_LENGTH = 50;
    public static final int TITLE_MIN_LENGTH = 10;
    public static final String INVALID_TITLE_LENGTH = String.format(
            "Title must be between %d and %d symbols", TITLE_MIN_LENGTH, TITLE_MAX_LENGTH);
    private String title;
    private String description;
    private int rating;
    private FeedbackStatusEnums status;
    private ArrayList<Comment> comments;
    private ArrayList<String> history;

    public FeedbackImpl(String title, String description, int rating) {
        this.title = title;
        this.description = description;
        this.rating = rating;
    }

    private void setTitle(String title) {
        ValidationHelpers.ValidateIntRange(title.length(),
                TITLE_MIN_LENGTH, TITLE_MAX_LENGTH, INVALID_TITLE_LENGTH);
        this.title = title;
    }


    private void setDescription(String description) {
        ValidationHelpers.ValidateIntRange(description.length(),
                DESCRIPTION_MIN_LENGTH, DESCRIPTION_MAX_LENGTH, INVALID_DESCRIPTION_LENGTH);
        this.description = description;
    }

    private void setRating(int rating) {
        this.rating = rating;
    }
//TODO
    @Override
    public ArrayList<String> getComments() {
        return null;
    }

    @Override
    public int getRating() {
        return rating;
    }

    @Override
    public FeedbackStatusEnums getStatus() {
        return status;
    }

    @Override
    public Member getMember() {
        return assignee;
    }
//TODO
    @Override
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
}
